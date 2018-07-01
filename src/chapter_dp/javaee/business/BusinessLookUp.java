package chapter_dp.javaee.business;

/**
 * 创建业务查询服务。
 * @author yuanhao
 * @date 2018/7/1 20:43
 */
public class BusinessLookUp {

    public BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }

}
