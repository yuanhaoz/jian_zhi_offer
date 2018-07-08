package chapter_dp.behavior.nullobject;

/**
 * 创建扩展了上述类的实体类。
 * Created by 18710 on 2018/6/18.
 */
public class NullCustomer extends AbstractCustomer {

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }
}
