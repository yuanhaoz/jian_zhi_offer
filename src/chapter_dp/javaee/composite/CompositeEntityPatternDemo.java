package chapter_dp.javaee.composite;

/**
 * 使用 Client 来演示组合实体设计模式的用法
 * @author yuanhao
 * @date 2018/7/2 10:13
 */
public class CompositeEntityPatternDemo {

    public static void main(String[] args) {
        Client client = new Client();
        client.setData("Test", "Data");
        client.printData();
        client.setData("Second Test", "Data1");
        client.printData();
    }

}
