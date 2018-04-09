package chapter_java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanhao
 * @date 2018/4/9 19:14
 */
public class Test1 {

    public static void main(String[] args) {
        Set<MyClass> set = new HashSet<>();
        set.add(new MyClass(5));
        set.add(new MyClass(2));
        set.add(new MyClass(6));
        System.out.print(set.size());
    }

}

class MyClass {
    Integer i;
    public MyClass(Integer y) {
        i = y;
    }
    public boolean equals(MyClass c) {
        return false;
    }
    public boolean equals(Object o) {
        return true;
    }
    public int hashCode() {
        return 32;
    }
}
