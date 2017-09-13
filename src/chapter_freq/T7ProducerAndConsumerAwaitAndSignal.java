package chapter_freq;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者/消费者问题的多种Java实现方式

 实质上，很多后台服务程序并发控制的基本原理都可以归纳为生产者/消费者模式，而这是恰恰是在本科操作系统课堂上老师反复讲解，而我们却视而不见不以为然的。在博文《一种面向作业流(工作流)的轻量级可复用的异步流水开发框架的设计与实现》中将介绍一种生产者/消费者模式的具体应用。
 生产者消费者问题是研究多线程程序时绕不开的经典问题之一，它描述是有一块缓冲区作为仓库，生产者可以将产品放入仓库，消费者则可以从仓库中取走产品。解决生产者/消费者问题的方法可分为两类：（1）采用某种机制保护生产者和消费者之间的同步；（2）在生产者和消费者之间建立一个管道。第一种方式有较高的效率，并且易于实现，代码的可控制性较好，属于常用的模式。第二种管道缓冲区不易控制，被传输数据对象不易于封装等，实用性不强。因此本文只介绍同步机制实现的生产者/消费者问题。
 同步问题核心在于：如何保证同一资源被多个线程并发访问时的完整性。常用的同步方法是采用信号或加锁机制，保证资源在任意时刻至多被一个线程访问。Java语言在多线程编程上实现了完全对象化，提供了对同步机制的良好支持。在Java中一共有四种方法支持同步，其中前三个是同步方法，一个是管道方法。
 （1）wait() / notify()方法
 （2）await() / signal()方法
 （3）BlockingQueue阻塞队列方法
 （4）PipedInputStream / PipedOutputStream
 本文只介绍最常用的前三种，第四种暂不做讨论，有兴趣的读者可以自己去网上找答案。

 二、await() / signal()方法
 在JDK5.0之后，Java提供了更加健壮的线程处理机制，包括同步、锁定、线程池等，
 它们可以实现更细粒度的线程控制。await()和signal()就是其中用来做同步的两种方法，
 它们的功能基本上和wait() / nofity()相同，完全可以取代它们，但是它们和新引入的锁定机制Lock直接挂钩，
 具有更大的灵活性。通过在Lock对象上调用newCondition()方法，将条件变量和一个锁对象进行绑定，进而控制并发程序访问竞争资源的安全。
 *
 * Created by 18710 on 2017/9/13.
 */
public class T7ProducerAndConsumerAwaitAndSignal {

    public static void main(String[] args) {
        // 仓库对象
        Storage storage = new Storage();

        // 生产者对象
        Producer1 p1 = new Producer1(storage);
        Producer1 p2 = new Producer1(storage);
        Producer1 p3 = new Producer1(storage);
        Producer1 p4 = new Producer1(storage);
        Producer1 p5 = new Producer1(storage);
        Producer1 p6 = new Producer1(storage);
        Producer1 p7 = new Producer1(storage);

        // 消费者对象
        Consumer1 c1 = new Consumer1(storage);
        Consumer1 c2 = new Consumer1(storage);
        Consumer1 c3 = new Consumer1(storage);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }

}

/**
 * 仓库类
 */
class Storage {
    // 仓库最大存储量
    private final int MAX_SIZE = 100;
    // 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<>();
    // 锁
    private final Lock lock = new ReentrantLock();
    // 仓库满的条件变量
    private final Condition full = lock.newCondition();
    // 仓库空的条件变量
    private final Condition empty = lock.newCondition();

    // 生产num个产品
    public void produce(int num) {
        // 获得锁
        lock.lock();
        // 如果仓库剩余容量不足
        while (list.size() + num > MAX_SIZE) {
            System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:"
                    + list.size() + "/t暂时不能执行生产任务!");
            try {
                // 由于条件不满足，生产阻塞
                full.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 生产条件满足情况下，生产num个产品
        for (int i = 1; i <= num; i++) {
            list.add(new Object());
        }
        System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());
        // 唤醒其它所有线程
        full.signalAll();
        empty.signalAll();
        // 释放锁
        lock.unlock();
    }

    public void consume(int num) {
        // 获得锁
        lock.lock();
        // 如果仓库存储量不足
        while (list.size() < num) {
            System.out.println();
            try {
                System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:" + list.size()
                        + "/t暂时不能执行生产任务!");
                empty.await(); // 由于条件不满足，消费阻塞
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 消费条件满足情况下，消费num个产品
        for (int i = 1; i < num; i++) {
            list.remove();
        }
        System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());
        // 唤醒其它所有线程
        empty.notifyAll();
        full.notifyAll();
        // 释放锁
        lock.unlock();
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }
}

/**
 * 生产者
 */
class Producer1 extends Thread {
    // 每次生产的产品数
    private int num;
    // 所在放置的仓库
    private Storage storage;
    // 构造函数，设置仓库
    public Producer1(Storage storage) {
        this.storage = storage;
    }
    // 线程run函数
    public void run() {
        storage.produce(num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}

/**
 * 消费者
 */
class Consumer1 extends Thread {
    // 每次消费的产品数
    private int num;
    // 所在放置的仓库
    private Storage storage;
    // 构造函数，设置仓库
    public Consumer1(Storage storage) {
        this.storage = storage;
    }
    // 线程run函数
    public void run() {
        storage.consume(num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}