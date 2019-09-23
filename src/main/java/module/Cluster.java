package module;

/**
 * Created by zhuting on 2019/8/28.
 */
public class Cluster {
    private String group;


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


    @Override
    public String toString() {
        return "Cluster{" +
                "group='" + group + '\'' +
                '}';
    }
}
