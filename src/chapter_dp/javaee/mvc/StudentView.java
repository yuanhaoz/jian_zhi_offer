package chapter_dp.javaee.mvc;

/**
 * 创建视图。
 * @author yuanhao
 * @date 2018/4/8 20:10
 */
public class StudentView {

    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }

}
