package chapter_dp.structure.adapter;

/**
 * @author yuanhao
 * @date 2018/4/8 20:02
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // 什么也不做
    }

}
