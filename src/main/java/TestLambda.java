import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by zhuting on 2019/8/25.
 */
public class TestLambda {

    public static void main(String[] args) {
        test6();

    }

    public static void test1() {
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");

/*
        Lambda表达式的基结构：
             (param1,param2,param3) ->{
             }

        注：event参数类型没有加，是借助于编译器，编译器可以根据上下文推断出事件类型，所以你可以省略，
        但是不是所有的情况都可以推断出，所以有时需要自己加上参数类型*/

        jButton.addActionListener(event -> {
            System.out.println("Button Pressed");
            System.out.println("hello world");
            System.out.println("excuted");
        });
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=================================");
        //2 foreach from jdk1.5
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("=================================");
        //3 jdk 1.8
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        list.forEach((Integer i) -> System.out.println(i)); //为了可读性,也可以加类型

        list.forEach(i -> System.out.println(i));

        list.forEach(System.out::println); //通过method reference方法引用的方式来创建一个函数式接口的实例

        //Consumer代表了一个操作,接收一个参数但是不返回结果.与其他函数接口不同的是,Consumer有可能修改接收的参数的值

        //对于list调用forach循环时,对于每一个元素调用Consumer里面的accept方法,accept方法内部将每一个元素进行了打印操作
        //关于Consumer接口位于jdk1.8新增包java.util.function中,
        /*
        *该接口上面有注解@FunctionalInterface 函数式接口
        * 什么是函数式接口?
         * 1)有该注解的接口都是函数式接口;若一个接口有且只有一个抽象方法那么这个接口就是函数式接口
        *  2)函数式接口 可以通过lambda表达式,方法引用或构造方法引用来创建函数式接口的实例,
        *
        * 疑问:接口里面显然是抽象方法,提到抽象方法的概念是否多余?
        * 答:不多余,jdk1.8开始接口中不仅包含抽象方法,还可以包含有具体实现的方法,这个方法称为默认方法
        *
        * 如果某个接口只有一个抽象方法,但是我们并没有给该接口声明FuncationalInterface注解,那么编译器依旧会将其看做是函数式接口
        * 如果我们在某个接口上声明了FunctionalInterface注解,那么编译器就会按照函数式接口来要求该接口
        * 不满足以下两点编译器就会生成错误信息:
        * 1.类型是接口类型,而且不是注解类型,枚举或者类
        * 2.注解类型满足函数式接口的要求(仅一个抽象方法)
        * */
    }


    public static void test3() {
        TheInterface i1 = () -> {
        };
        System.out.println(i1.getClass().getInterfaces()[0]);


        TheInterface2 i2 = () -> {
        };  //将lambda表达式赋值给了对象的引用
        System.out.println(i2.getClass().getInterfaces()[0]);

        //单独给出 ()->{}不可以 ,因为是什么类型的 需要编译器通过上下文得知的,比如上面的例子
//         ()->{}
    }


    public static void test4() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world2");
            }
        }).start();

        new Thread(() -> System.out.println("hello world")).start();
    }


    //将字符串中所有大写变成小写
    public static void test5() {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        //变成大写输出
        list.forEach(s -> System.out.println(s.toUpperCase()));

        //变成大写放入另一个集合 遍历输出
        ArrayList<String> list2 = new ArrayList<>();
        list.forEach(s -> list2.add(s.toUpperCase()));
        list2.forEach(s -> System.out.println(s));

        //变成大写放入另一个集合 遍历输出
        list.stream().map(item -> item.toUpperCase()).forEach(s -> System.out.println(s));
        list.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));
//      list.stream();//串行流  list.parallelStream(); //并行流
        //item -> item.toUpperCase() 和 String::toUpperCase都符合ucntion接口apply方法的要求
        /*
        * Collection接口 ->单列集合顶层接口
        * 在Collection接口中可以看到有一个实现,默认方法:
        *  default Stream<E> stream() { return StreamSupport.stream(spliterator(), false);  }
        * */
    }


    public static void test6() {
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
        //打印结果: interface java.util.function.Function
        /*
         *    public String toUpperCase() {
               return toUpperCase(Locale.getDefault());
              }
         *
         */
        //你可以看到Function<String, String> 中指定接收和返回参数都是String,而toUpperCase本身是入参为空,返回String的
        //那么是如何 和Function<String, String> 对应的呢?
        // String::toUpperCase;是四种方法引用的其中一种, toUpperCase() 是实例方法非静态方法, 一定由对象去调用
        //所以若是使用 类::实例方法,则对应lambda第一个输入参数一定是调用那个方法的对象.

    }


/*

@FunctionalInterface
interface MyInterface1 {
    void test();
    String myString();
}
*/

//若一个接口声明了一个抽象方法,但是此抽象方法是重写了Object类中public方法,则不会给接口抽象方法加1
//根本原因Object类是所有类的父类,你定义的类也是直接或者间接的继承Object


    @FunctionalInterface
    interface MyInterface {
        void test();

        String toString();
    }

//class Test1{
//   public void myTest(MyInterface myInterface){
//       System.out.println(1);
//       myInterface.test();
//       System.out.println(2);
//   }
//    public static void main(String[] args) {
//       /* Test1 test1 = new Test1();
//        test1.myTest(new MyInterface() {
//            @Override
//            public void test() {
//                System.out.println("myTest");
//            }
//        });
//        test1.myTest(()-> {System.out.println("myTest");});
//        System.out.println("=================");
//        MyInterface myInterface=()->{ System.out.println("hello");};
//        System.out.println(myInterface.getClass());
//        System.out.println(myInterface.getClass().getSuperclass());
//        System.out.println(myInterface.getClass().getInterfaces()[0]);*/
//    }
//}


    @FunctionalInterface
    interface TheInterface {
        void myMethod(); //不接收参数不返回值
    }


    @FunctionalInterface
    interface TheInterface2 {
        void myMethod();
    }
}