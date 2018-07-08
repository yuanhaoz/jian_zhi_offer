package chapter_dp.behavior.interpreter;

/**
 * 创建实现了上述接口的实体类。
 * @author yuanhao
 * @date 2018/6/11 21:35
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
