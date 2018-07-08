package chapter_dp.javaee.business;

/**
 * 创建业务代表。
 * @author yuanhao
 * @date 2018/7/1 20:44
 */
public class BusinessDelegate {

    private BusinessLookUp lookupService = new BusinessLookUp();

    private BusinessService businessService;

    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing();
    }

}
