package chapter_dp.create.prototype;

/**
 * @author yuanhao
 * @date 2018/3/11 10:01
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
