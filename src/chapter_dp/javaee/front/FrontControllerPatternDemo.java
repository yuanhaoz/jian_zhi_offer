package chapter_dp.javaee.front;

/**
 * 使用 FrontController 来演示前端控制器设计模式。
 * @author yuanhao
 * @date 2018/7/7 20:41
 */
public class FrontControllerPatternDemo {

    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }

}
