package chapter_dp.behavior.template;

/**
 * 使用 Game 的模板方法 play() 来演示游戏的定义方式。
 * @author yuanhao
 * @date 2018/6/19 15:23
 */
public class TemplatePatternDemo {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }

}
