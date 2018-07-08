package chapter_dp.javaee.business;

/**
 * 创建实体服务类。
 * @author yuanhao
 * @date 2018/4/8 20:10
 */
public class EJBService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
