package chapter_dp.structure.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建实现了 Criteria 接口的实体类。
 * @author yuanhao
 * @date 2018/6/5 21:40
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }

        return singlePersons;
    }
}
