package chapter_dp.create.prototype;

/**
 * @author yuanhao
 * @date 2018/3/10 20:01
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
