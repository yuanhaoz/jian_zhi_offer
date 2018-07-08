package chapter_dp.behavior.command;

/**
 * @author yuanhao
 * @date 2018/6/10 14:34
 */
public class CommandPatternDemo {

    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }

}
