package chapter_dp.create.abstractFactory;

/**
 * @author yuanhao
 * @date 2018/2/26 16:47
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
