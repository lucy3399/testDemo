package module;



/**
 * Created by zhuting on 2019/9/21.
 */



public class User implements Comparable<User> {

    private String name;

    private int age;

    private String job;

    @Override
    public int compareTo(User o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode() * 31 + getAge();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (! (obj instanceof User)){
            return false;
        }
        User u = (User)obj;
        return (getName().equals(u.getName())) && (getAge() == u.getAge()) && (getJob().equals(u.getJob()));
    }

    public User(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}