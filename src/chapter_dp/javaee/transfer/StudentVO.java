package chapter_dp.javaee.transfer;

/**
 * 创建传输对象。
 * @author yuanhao
 * @date 2018/7/8 9:19
 */
public class StudentVO {

    private String name;
    private int rollNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public StudentVO(String name, int rollNo) {

        this.name = name;
        this.rollNo = rollNo;
    }
}
