package chapter_dp.create.abstractFactory;

import chapter_dp.create.factory.Shape;

/**
 * @author yuanhao
 * @date 2018/2/26 16:48
 */
public abstract class AbstractFactory {

    abstract Color getColor(String color);
    abstract Shape getShape(String shape);

}
