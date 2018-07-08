package chapter_dp.javaee.service;

/**
 * 创建实体服务。
 * @author yuanhao
 * @date 2018/7/8 8:56
 */
public class Service1 implements Service {

    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service1");
    }

}
