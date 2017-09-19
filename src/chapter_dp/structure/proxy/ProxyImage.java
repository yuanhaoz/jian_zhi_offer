package chapter_dp.structure.proxy;

/**
 *
 * Created by 18710 on 2017/9/14.
 */
public class ProxyImage implements Image {

    private RealImage realImage; // 代理图片类，具体实现的图片类
    private String fileName; // 文件名字

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) { // 代理展示图片
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

}
