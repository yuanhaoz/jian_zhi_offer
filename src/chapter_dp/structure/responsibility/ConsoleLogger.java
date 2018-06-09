package chapter_dp.structure.responsibility;

/**
 * 创建扩展了该记录器类的实体类。
 * @author yuanhao
 * @date 2018/6/9 16:29
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }

}
