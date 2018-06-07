package chapter_dp.structure.facade;

/**
 * @author yuanhao
 * @date 2018/6/7 21:12
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

    }

}
