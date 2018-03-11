package chapter_dp.create.prototype;

/**
 * @author yuanhao
 * @date 2018/3/11 10:02
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}
