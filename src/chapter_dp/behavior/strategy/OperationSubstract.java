package chapter_dp.behavior.strategy;

/**
 * 创建实现接口的实体类。
 * @author yuanhao
 * @date 2018/6/19 14:59
 */
public class OperationSubstract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
