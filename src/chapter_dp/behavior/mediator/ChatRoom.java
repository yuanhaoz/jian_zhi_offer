package chapter_dp.behavior.mediator;

import java.util.Date;

/**
 * 创建中介类。
 * @author yuanhao
 * @date 2018/6/13 9:21
 */
public class ChatRoom {

    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + "[" + user.getName() + "] : " + message);
    }

}
