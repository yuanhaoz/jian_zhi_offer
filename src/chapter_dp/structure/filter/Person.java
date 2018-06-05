package chapter_dp.structure.filter;

/**
 * 创建一个类，在该类上应用标准。
 * @author yuanhao
 * @date 2018/6/5 21:37
 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, String gender, String maritalStatus) {

        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }
}
