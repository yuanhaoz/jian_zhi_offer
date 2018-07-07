package chapter_dp.javaee.intercepting;

/**
 * 创建客户端 Client。
 * @author yuanhao
 * @date 2018/7/7 21:02
 */
public class Client {

    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }
}
