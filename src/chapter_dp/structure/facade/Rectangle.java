package chapter_dp.structure.facade;

/**
 * 创建实现接口的实体类。
 * @author yuanhao
 * @date 2018/6/7 21:09
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
