package chapter_dp.structure.filter;

import java.util.List;

/**
 * 为标准（Criteria）创建一个接口。
 * @author yuanhao
 * @date 2018/6/5 21:38
 */
public interface Criteria {

    public List<Person> meetCriteria(List<Person> persons);

}
