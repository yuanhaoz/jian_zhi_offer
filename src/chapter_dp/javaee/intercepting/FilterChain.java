package chapter_dp.javaee.intercepting;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建过滤器链。
 * @author yuanhao
 * @date 2018/7/7 20:58
 */
public class FilterChain {

    private List<Filter> filters = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
