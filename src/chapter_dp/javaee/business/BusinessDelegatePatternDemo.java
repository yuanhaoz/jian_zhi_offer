package chapter_dp.javaee.business;

/**
 * 使用 BusinessDelegate 和 Client 类来演示业务代表模式。
 * @author yuanhao
 * @date 2018/7/1 20:47
 */
public class BusinessDelegatePatternDemo {

    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }

}
