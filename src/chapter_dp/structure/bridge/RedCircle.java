package chapter_dp.structure.bridge;

/**
 * 创建实现了 DrawAPI 接口的实体桥接实现类。
 * @author yuanhao
 * @date 2018/6/4 20:40
 */
public class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }

}
