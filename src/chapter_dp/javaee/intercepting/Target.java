package chapter_dp.javaee.intercepting;

/**
 * 创建 Target。
 * @author yuanhao
 * @date 2018/7/7 20:57
 */
public class Target {

    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }

}
