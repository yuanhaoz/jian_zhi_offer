package chapter_dp.create.abstractFactory;

import chapter_dp.create.factory.Shape;

/**
 * @author yuanhao
 * @date 2018/2/26 16:54
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {

        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();
        Shape rect = shapeFactory.getShape("RECTANGLE");
        rect.draw();
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color red = colorFactory.getColor("RED");
        red.fill();
        Color green = colorFactory.getColor("GREEN");
        green.fill();
        Color blue = colorFactory.getColor("BLUE");
        blue.fill();
    }

}
