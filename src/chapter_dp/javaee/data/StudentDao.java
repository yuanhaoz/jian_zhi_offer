package chapter_dp.javaee.data;

import java.util.List;

/**
 * 创建数据访问对象接口。
 * @author yuanhao
 * @date 2018/7/7 20:13
 */
public interface StudentDao {

    public List<Student> getAllStudents();
    public Student getStudent(int rollNo);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);

}
