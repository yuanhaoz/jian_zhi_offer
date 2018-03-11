package chapter_dp.create.builder;

/**
 * @author yuanhao
 * @date 2018/3/10 19:22
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
