package chapter_dp.structure.bridge;

/**
 * 使用 Shape 和 DrawAPI 类画出不同颜色的圆。
 * @author yuanhao
 * @date 2018/6/4 20:46
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }

}
