package chapter_dp.javaee.service;

/**
 * 创建服务定位器。
 * @author yuanhao
 * @date 2018/7/8 9:04
 */
public class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName) {
        // 首先查找缓存
        Service service = cache.getService(jndiName);
        if (service != null) {
            return service;
        }
        // 缓存中不存在，创建服务。
        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }

}
