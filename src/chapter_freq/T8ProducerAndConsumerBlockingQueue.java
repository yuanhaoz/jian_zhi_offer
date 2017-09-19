package chapter_freq;

import java.util.concurrent.LinkedBlockingQueue;

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

 三、BlockingQueue阻塞队列方法
 BlockingQueue是JDK5.0的新增内容，它是一个已经在内部实现了同步的队列，实现方式采用的是我们第2种await() / signal()方法。它可以在生成对象时指定容量大小。它用于阻塞操作的是put()和take()方法。
 put()方法：类似于我们上面的生产者线程，容量达到最大时，自动阻塞。
 take()方法：类似于我们上面的消费者线程，容量为0时，自动阻塞。
 关于BlockingQueue的内容网上有很多，大家可以自己搜，我在这不多介绍。
 * Created by 18710 on 2017/9/13.
 */
public class T8ProducerAndConsumerBlockingQueue {

    public static void main(String[] args) {
        // 仓库对象
        Storage1 storage = new Storage1();

        // 生产者对象
        Producer2 p1 = new Producer2(storage);
        Producer2 p2 = new Producer2(storage);
        Producer2 p3 = new Producer2(storage);
        Producer2 p4 = new Producer2(storage);
        Producer2 p5 = new Producer2(storage);
        Producer2 p6 = new Producer2(storage);
        Producer2 p7 = new Producer2(storage);

        // 消费者对象
        Consumer2 c1 = new Consumer2(storage);
        Consumer2 c2 = new Consumer2(storage);
        Consumer2 c3 = new Consumer2(storage);

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

class Storage1 {
    // 仓库最大存储量
    private final int MAX_SIZE = 100;
    // 仓库存储的载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(100);

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public LinkedBlockingQueue<Object> getList() {
        return list;
    }

    public void setList(LinkedBlockingQueue<Object> list) {
        this.list = list;
    }

    // 生产num个产品
    public void produce(int num) {
        // 如果仓库剩余容量为0
        if (list.size() == MAX_SIZE) {
            System.out.println("【库存量】:" + MAX_SIZE + "/t暂时不能执行生产任务!");
        }
        for (int i = 1; i <= num; i++) {
            try {
                list.put(new Object()); // 放入产品，自动阻塞
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("【现仓储量为】:" + list.size());
    }

    // 消费num个产品
    public void consume(int num) {
        // 如果仓库存储量不足
        if (list.size() == 0) {
            System.out.println("【库存量】:0/t暂时不能执行生产任务!");
        }
        for (int i = 1; i <= num; i++) {
            try {
                list.take(); // 消费产品，自动阻塞
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("【现仓储量为】:" + list.size());

    }

}

/**
 * 生产者
 */
class Producer2 extends Thread {
    // 每次生产的产品数
    private int num;
    // 所在放置的仓库
    private Storage1 storage;
    // 构造函数，设置仓库
    public Producer2(Storage1 storage) {
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

    public Storage1 getStorage() {
        return storage;
    }

    public void setStorage(Storage1 storage) {
        this.storage = storage;
    }
}

/**
 * 消费者
 */
class Consumer2 extends Thread {
    // 每次消费的产品数
    private int num;
    // 所在放置的仓库
    private Storage1 storage;
    // 构造函数，设置仓库
    public Consumer2(Storage1 storage) {
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

    public Storage1 getStorage() {
        return storage;
    }

    public void setStorage(Storage1 storage) {
        this.storage = storage;
    }
}
