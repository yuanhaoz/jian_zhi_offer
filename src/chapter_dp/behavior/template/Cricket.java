package chapter_dp.behavior.template;

/**
 * 创建扩展了上述类的实体类。
 * @author yuanhao
 * @date 2018/6/19 15:18
 */
public class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

}
