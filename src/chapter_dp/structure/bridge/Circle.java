package chapter_dp.structure.bridge;

/**
 * 创建实现了 Shape 接口的实体类。
 * @author yuanhao
 * @date 2018/6/4 20:43
 */
public class Circle extends Shape {

    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }

}
