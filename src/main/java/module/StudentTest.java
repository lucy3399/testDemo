package module;

import java.util.function.Supplier;

/**
 * Created by zhuting on 2019/9/18.
 */
public class StudentTest {
    public static void main(String[] args) {
        //创建对象获取名字
        Supplier<Student> supplier=()->new Student();
        System.out.println(supplier.get().getName());

        System.out.println("===============");

        //构造方法引用
        Supplier<Student> supplier1 = Student::new;
        //上述方式  Student::new之所知道是寻找无参构造方法是因为
        // 编译器编译时知道左侧是Supplier无入参
        System.out.println(supplier1.get().getName());

        System.out.println("===============");

    }
}
