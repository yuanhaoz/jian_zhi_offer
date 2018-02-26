package chapter_dp.create.abstractFactory;

import chapter_dp.create.factory.Circle;
import chapter_dp.create.factory.Rectangle;
import chapter_dp.create.factory.Square;
import chapter_dp.create.factory.Shape;

/**
 * @author yuanhao
 * @date 2018/2/26 16:49
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
