package chapter_dp.create.builder;

/**
 * @author yuanhao
 * @date 2018/3/10 19:21
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
