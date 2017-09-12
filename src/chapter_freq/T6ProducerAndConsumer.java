package chapter_freq;

/**
 *
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