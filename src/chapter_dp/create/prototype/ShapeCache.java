package chapter_dp.create.prototype;

import java.util.Hashtable;

/**
 * @author yuanhao
 * @date 2018/3/11 10:03
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        System.out.println("比较原来对象和克隆对象的hashcode()判断复制的对象是在堆中新建了一个对象：" + cachedShape.hashCode() + "，" + cachedShape.clone().hashCode());
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);

    }

}
