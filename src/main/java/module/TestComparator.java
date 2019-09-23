package module;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhuting on 2019/9/21.
 */
public class TestComparator {
    public static void main(String[] args) {
        User u1 = new User("zhangsan", 28, "C++");
        User u2 = new User("zhangsan", 28, "C++");
        User u3 = new User("wangwu", 22, "C");
        User u4 = new User("xiaoliu", 26, "Python");
        User u5 = new User("jiqjiq", 11, "Go");

        System.out.println(u1.equals(u2)); // true
//        System.out.println(u1.compareTo(u2) == 0); // true
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
        System.out.println("排序之前...........");
        users.forEach((u) -> System.out.println(u));

        // 排序
        Collections.sort(users);

        System.out.println("排序之后...");
        users.forEach((u) -> System.out.println(u));
    }
}
