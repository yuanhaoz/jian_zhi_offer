package chapter_dp.javaee.intercepting;

/**
 * 创建过滤管理器。
 * @author yuanhao
 * @date 2018/7/7 21:00
 */
public class FilterManager {

    FilterChain filterChain;

    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }

}
