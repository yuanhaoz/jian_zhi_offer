package chapter_dp.behavior.nullobject;

/**
 * 创建扩展了上述类的实体类。
 * Created by 18710 on 2018/6/18.
 */
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
