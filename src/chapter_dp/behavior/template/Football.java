package chapter_dp.behavior.template;

/**
 * 创建扩展了上述类的实体类。
 * @author yuanhao
 * @date 2018/6/19 15:18
 */
public class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
    
}
