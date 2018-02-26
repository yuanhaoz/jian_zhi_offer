package chapter_dp.create.abstractFactory;

import chapter_dp.create.factory.Shape;

/**
 * @author yuanhao
 * @date 2018/2/26 16:52
 */
public class ColorFactory extends AbstractFactory {

    @Override
    Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
