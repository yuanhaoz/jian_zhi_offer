package chapter_dp.structure.decorator;

/**
 * 创建实现了 Shape 接口的抽象装饰类
 * Created by yuanhao on 2017/10/8.
 */
public class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
