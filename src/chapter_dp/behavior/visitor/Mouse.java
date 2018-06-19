package chapter_dp.behavior.visitor;

/**
 * 创建扩展了上述类的实体类。
 * @author yuanhao
 * @date 2018/6/19 19:25
 */
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
    
}
