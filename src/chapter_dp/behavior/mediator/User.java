package chapter_dp.behavior.mediator;

/**
 * 创建 user 类。
 * @author yuanhao
 * @date 2018/6/13 9:21
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {

        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }

}
