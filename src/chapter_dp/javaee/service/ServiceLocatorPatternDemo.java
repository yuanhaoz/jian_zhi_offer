package chapter_dp.javaee.service;

/**
 * 使用 ServiceLocator 来演示服务定位器设计模式。
 * @author yuanhao
 * @date 2018/7/8 9:06
 */
public class ServiceLocatorPatternDemo {

    public static void main(String[] args) {
        Service service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
        service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
    }

}
