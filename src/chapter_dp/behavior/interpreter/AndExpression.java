package chapter_dp.behavior.interpreter;

/**
 * 创建实现了上述接口的实体类。
 * @author yuanhao
 * @date 2018/6/11 21:35
 */
public class AndExpression implements Expression {

    private Expression expr1 = null;
    private Expression expr2 = null;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
    
}
