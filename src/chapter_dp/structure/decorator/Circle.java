package chapter_dp.structure.decorator;

/**
 * 创建实现接口Shape的实体类
 * Created by yuanhao on 2017/10/8.
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
