package chapter_dp.behavior.strategy;

/**
 * 创建 Context 类。
 * @author yuanhao
 * @date 2018/6/19 15:00
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
