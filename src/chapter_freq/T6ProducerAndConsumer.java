package chapter_freq;

/**
 *生产者/消费者问题的多种Java实现方式

 实质上，很多后台服务程序并发控制的基本原理都可以归纳为生产者/消费者模式，而这是恰恰是在本科操作系统课堂上老师反复讲解，而我们却视而不见不以为然的。在博文《一种面向作业流(工作流)的轻量级可复用的异步流水开发框架的设计与实现》中将介绍一种生产者/消费者模式的具体应用。
 生产者消费者问题是研究多线程程序时绕不开的经典问题之一，它描述是有一块缓冲区作为仓库，生产者可以将产品放入仓库，消费者则可以从仓库中取走产品。解决生产者/消费者问题的方法可分为两类：（1）采用某种机制保护生产者和消费者之间的同步；（2）在生产者和消费者之间建立一个管道。第一种方式有较高的效率，并且易于实现，代码的可控制性较好，属于常用的模式。第二种管道缓冲区不易控制，被传输数据对象不易于封装等，实用性不强。因此本文只介绍同步机制实现的生产者/消费者问题。
 同步问题核心在于：如何保证同一资源被多个线程并发访问时的完整性。常用的同步方法是采用信号或加锁机制，保证资源在任意时刻至多被一个线程访问。Java语言在多线程编程上实现了完全对象化，提供了对同步机制的良好支持。在Java中一共有四种方法支持同步，其中前三个是同步方法，一个是管道方法。
 （1）wait() / notify()方法
 （2）await() / signal()方法
 （3）BlockingQueue阻塞队列方法
 （4）PipedInputStream / PipedOutputStream
 本文只介绍最常用的前三种，第四种暂不做讨论，有兴趣的读者可以自己去网上找答案。

 一、wait() / notify()方法
 wait() / nofity()方法是基类Object的两个方法，也就意味着所有Java类都会拥有这两个方法，这样，我们就可以为任何对象实现同步机制。
 wait()方法：当缓冲区已满/空时，生产者/消费者线程停止自己的执行，放弃锁，使自己处于等等状态，让其他线程执行。
 notify()方法：当生产者/消费者向缓冲区放入/取出一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态。

 * Created by 18710 on 2017/9/12.
 */
public class T6ProducerAndConsumer {
    public static void main(String[] args) {
        StackBasket ss = new StackBasket();
        Producer producer = new Producer(ss);
        Consumer consumer = new Consumer(ss);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

// 生产者和消费者使用的对象
class Mantou {
    private int id;

    public Mantou(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mantou{" +
                "id=" + id +
                '}';
    }
}

// 共享栈空间
class StackBasket {
    Mantou[] sm = new Mantou[6];
    int index = 0;

    /**
     * 生产方法：
     * 同步方法，持有方法锁
     * 首先判断循环满否，满的话使该线程等待，释放同步方法锁，允许消费
     * 当不满时首先唤醒正在等待的消费方法，但是也只能让其进入就绪状态
     * 等生产结束释放同步方法锁后消费才能持有该锁进行消费
     * @param m 生产对象
     */
    public synchronized void push(Mantou m) { // 注意 synchronized 表示同步方法
        try {
            while (index == sm.length) {
                System.out.println("-------生产满了-------");
                this.wait(); // 生产者等待
            }
            this.notify(); // 唤醒等待线程
        } catch (Exception e) {
            e.printStackTrace();
        }
        sm[index] = m;
        index++;
        System.out.println("生产了：" + m + "共" + index + "个馒头");
    }

    /**
     * 消费方法：
     * 同步方法，持有方法锁
     * 首先循环判断空否，空的话使该线程等待，释放同步方法锁，允许生产
     * 当不空的时候首先唤醒正在等待的生产方法，但是也只能让其进入就绪状态
     * 等消费结束释放同步方法锁后生产才能持有该锁进行生产
     * @return 消费对象
     */
    public synchronized Mantou pop() {  // 注意 synchronized 表示同步方法
        try {
            while (index == 0) {
                System.out.println("-------消费光了-------");
                this.wait(); // 消费者等待
            }
            this.notify(); // 唤醒等待线程
        } catch(Exception e) {
            e.printStackTrace();
        }
        index--;
        System.out.println("消费了：" + sm[index] + "共" + index + "个馒头");
        return sm[index];
    }

}

/**
 * 生产者：线程类
 */
class Producer implements Runnable{

    // 共享栈
    StackBasket ss = new StackBasket();

    public Producer(StackBasket ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) { // 生产20个
            Mantou m = new Mantou(i);
            ss.push(m);
            try {
                Thread.sleep((int)(Math.random()*500));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者：线程类
 */
class Consumer implements Runnable{

    // 共享栈
    StackBasket ss = new StackBasket();

    public Consumer(StackBasket ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) { // 消费20次
            ss.pop();
            try {
                Thread.sleep((int)(Math.random()*500));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}