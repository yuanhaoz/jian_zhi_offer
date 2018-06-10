package chapter_dp.behavior.command;

/**
 * 创建一个请求类。
 * @author yuanhao
 * @date 2018/6/10 14:28
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + "] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + "] sold");
    }

}
