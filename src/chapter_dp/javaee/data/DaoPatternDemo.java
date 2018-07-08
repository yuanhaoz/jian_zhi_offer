package chapter_dp.javaee.data;

/**
 * 使用 StudentDao 来演示数据访问对象模式的用法。
 * @author yuanhao
 * @date 2018/7/7 20:20
 */
public class DaoPatternDemo {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        // 输出所有的学生
        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name: " + student.getName() + "]");
        }

        // 更新学生
        Student student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);

        // 获取学生
        student = studentDao.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name: " + student.getName() + "]");
    }

}
