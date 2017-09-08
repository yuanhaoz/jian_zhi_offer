package chapter2;

/**
 * 单例模式：
 *
 * Created by 18710 on 2017/9/5.
 */
public class T2Singleton {

    /**
     * 单例模式，懒汉式，线程安全
     * 成员变量是私有静态常量并初始化赋值，构造函数私有，通过 public 方法获取SingleTon类的实例
     * 提前就赋值
     */
    public static class Singleton {
        private final static Singleton INSTANCE = new Singleton();
        private Singleton() {}
        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 单例模式，饿汉式，线程不安全
     * 成员变量是私有静态变量并初始化不赋值，构造方法私有，通过 public 方法判断 成员变量是否有值才进行赋值
     * 需要时判断赋值
     */
    public static class SingleTon2 {
        private static SingleTon2 instance = null;
        private SingleTon2() {

        }
        public static SingleTon2 getInstance() {
            if (instance == null) {
                instance = new SingleTon2();
            }
            return instance;
        }
    }

    /**
     * 单例模式，饿汉式，线程安全，多线程环境下效率高
     */
    public static class Singleton3 {
        private static Singleton3 instance = null;
        private Singleton3() {

        }
        public synchronized static Singleton3 getInstance() { // 加上同步方法
            if (instance == null) {
                instance = new Singleton3();
            }
            return instance;
        }
    }

    /**
     * 单例模式，饿汉式，变种，线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;
        static { // 静态类中声明
            instance = new Singleton4();
        }
        private Singleton4() {

        }
        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全（推荐）
     */
    public static class Singleton5 {
        private final static class SingletonHolder { // 使用静态内部类
            private static final Singleton5 INSTANCE = new Singleton5();
        }
        private Singleton5() {

        }
        private static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类，使用枚举方式，线程安全【推荐】
     */
    public enum SingleTon6 {
        INSTANCE;

        public void whateverMethod(){

        }
    }

    /**
     * 静态内部类，使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance = null; // volatile关键字保证原子性
        private Singleton7() {

        }
        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) { // synchronized关键字保证线程安全
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }

}