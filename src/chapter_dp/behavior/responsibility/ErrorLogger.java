package chapter_dp.behavior.responsibility;

/**
 * 创建扩展了该记录器类的实体类。
 * @author yuanhao
 * @date 2018/6/9 16:29
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }

}
