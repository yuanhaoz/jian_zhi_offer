package chapter_dp.behavior.visitor;

/**
 * 使用 ComputerPartDisplayVisitor 来显示 Computer 的组成部分。
 * @author yuanhao
 * @date 2018/6/19 19:31
 */
public class VisitorPatternDemo {

    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }

}
