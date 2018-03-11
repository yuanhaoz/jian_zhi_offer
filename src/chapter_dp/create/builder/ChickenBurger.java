package chapter_dp.create.builder;

/**
 * @author yuanhao
 * @date 2018/3/10 19:23
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
