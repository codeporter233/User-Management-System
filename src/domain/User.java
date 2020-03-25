package domain;

public class User {
    private int id;
    private String name;
    private String email;
    private String qq;
    private String gender;
    private int age;
    private String address;


    public User() {
    }

    public User(int id, String name, String email, String qq, String gender, int age, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.qq = qq;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public User(String name, String email, String qq, String gender, int age, String address) {
        this.name = name;
        this.email = email;
        this.qq = qq;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
