package chapter_dp.create.singleton;

/**
 * 单例模式的几种实现方式
 单例模式的实现有多种方式，如下所示：

 1、懒汉式，线程不安全
 是否 Lazy 初始化：是

 是否多线程安全：否

 实现难度：易

 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。

 * Created by 18710 on 2017/9/14.
 */
public class Singleton {



    private static Singleton instance;
    private Singleton () {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}

/**
 * 2、懒汉式，线程安全
 是否 Lazy 初始化：是

 是否多线程安全：是

 实现难度：易

 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 优点：第一次调用才初始化，避免内存浪费。
 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 */
class Singleton1 {

    private static Singleton1 instance;
    private Singleton1 () {}

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}

/**
 * 3、饿汉式
 是否 Lazy 初始化：否

 是否多线程安全：是

 实现难度：易

 描述：这种方式比较常用，但容易产生垃圾对象。
 优点：没有加锁，执行效率会提高。
 缺点：类加载时就初始化，浪费内存。
 它基于 classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
 */
class Singleton2 {

    private static Singleton2 instance = new Singleton2();
    private Singleton2 () {}
    public static Singleton2 getInstance() {
        return instance;
    }

}
