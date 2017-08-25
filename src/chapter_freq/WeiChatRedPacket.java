package chapter_freq;

import java.util.Random;

/**
 * 微信红包算法
 * 比如发一个总额为50元的红包，总共分5个
 * 第一个：在0～10元之间随机产生一个数，作为这一个红包的钱数，设为x1
 * 第二个：剩下的钱为(50-x1)，然后在0～(50-x1)/(5-1)随机一个数，作为这份的钱数，设x2
 * 。。。
 * 第5份：剩下的钱为(50-x1-x2-...x4)，系统由0~(50-x1-x2-...-xn-1)/(5-4)随机一个数，作为这个份的钱数，设为xn
 *
 *  Created by 18710 on 2017/8/25.
 */
public class WeiChatRedPacket {

    /**
     * 红包类（内部类）
     */
    public static class Money {
        public static int remainNum; // 剩余的红包数量
        public static double remainMoney; // 剩余的钱
    }

    /**
     * 抢红包算法
     * @param myMoney 红包类
     * @return
     */
    public static double getRandomMoney(Money myMoney) {
        double min = 0.01;
        double max = myMoney.remainMoney / myMoney.remainNum * 2; // 随机，额度在 0.01和（剩余平均值*2）之间
        // 最后一个红包就是剩余的钱
        if (myMoney.remainNum == 1) {
            myMoney.remainNum--;
            return (double) Math.round(myMoney.remainMoney * 100) / 100;
        }
        // 随机分配红包
        Random r = new Random();
        double money = r.nextDouble() * max;
        money = money < min ? 0.01 : money; // 至少有0.01元钱
        money = Math.floor(money * 100) / 100;
        myMoney.remainNum--; //更新红包数和自己的钱树
        myMoney.remainMoney -= money;
        return money;
    }

    public static void main(String[] args) {
        Money m = new Money();
        m.remainNum = 5;
        int count = m.remainNum;
        m.remainMoney = 50;
        for (int i = 1; i <= count; i++) {
            System.out.println("第"+i+"次获取的红包为"+getRandomMoney(m)+"元");
        }
    }

}
