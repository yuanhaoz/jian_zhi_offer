package chapter_dp.create.builder;

/**
 * @author yuanhao
 * @date 2018/3/10 19:17
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price(); // 抽象类被子类继承，子类必须重写抽象类中的所有抽象方法

}
