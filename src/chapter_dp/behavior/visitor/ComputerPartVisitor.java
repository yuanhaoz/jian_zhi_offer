package chapter_dp.behavior.visitor;

/**
 * 定义一个表示访问者的接口
 * @author yuanhao
 * @date 2018/6/19 19:23
 */
public interface ComputerPartVisitor {

    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);

}
