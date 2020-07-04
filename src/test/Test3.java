package test;

import java.lang.reflect.Field;

/**
 * @author yuanhao
 * @date 2019/11/15 10:37
 */
public class Test3 {

    public static void main(String[] args) {
        reflectProperty();
    }

    private static void reflectProperty() {
        try {
            Class<?> clazz = Class.forName("test.ApiType");
            Object obj = clazz.newInstance();
            Field field = clazz.getDeclaredField("dtype");
            field.setAccessible(true);
            field.set(obj, "DEAL_GROUP");
            System.out.println(field.get(obj));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
