package chapter_dp.javaee.front;

/**
 * 创建调度器 Dispatcher。
 * @author yuanhao
 * @date 2018/7/7 20:33
 */
public class Dispatcher {

    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher() {
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("STUDENT")) {
            studentView.show();
        } else {
            homeView.show();
        }
    }

}
