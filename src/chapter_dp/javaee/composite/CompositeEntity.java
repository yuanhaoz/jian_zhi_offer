package chapter_dp.javaee.composite;

/**
 * 创建组合实体。
 * @author yuanhao
 * @date 2018/7/2 10:10
 */
public class CompositeEntity {

    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public void setData(String data1, String data2) {
        cgo.setData(data1, data2);
    }

    public String[] getData() {
        return cgo.getData();
    }

}
