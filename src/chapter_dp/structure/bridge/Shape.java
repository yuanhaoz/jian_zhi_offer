package chapter_dp.structure.bridge;

/**
 * 使用 DrawAPI 接口创建抽象类 Shape。
 * @author yuanhao
 * @date 2018/6/4 20:42
 */
public abstract class Shape {

    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
