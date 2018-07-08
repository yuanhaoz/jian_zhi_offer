package chapter_dp.behavior.visitor;

/**
 * 定义一个表示元素的接口
 * @author yuanhao
 * @date 2018/6/19 19:25
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
