package chapter_dp.javaee.business;

/**
 * 创建客户端。
 * @author yuanhao
 * @date 2018/7/1 20:46
 */
public class Client {

    BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    public void doTask() {
        businessDelegate.doTask();
    }

}
