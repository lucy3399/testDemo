package module;

import java.util.function.Function;

/**
 * Created by zhuting on 2019/9/1.
 * Function中apply抽象方法 :接收一个参数,返回一个值
 */
public class FunctionTest {
    //重点在于理解lambda表达式 传递的是行为而不是值
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        //value->{return 2*value;} 将行为做为参数传入
        System.out.println(functionTest.compute(1,value->{return 2*value;}));  //statement
        System.out.println(functionTest.compute(1,value-> 2*value));  //expression
        //过去上述的实现是我们预先定义好行为(各个方法),然后调用;
        // 而现在定义了function apply(a),具体什么行为现在是不知道的,而是用的时候传递的

        //高阶函数:若一个函数接收一个函数做为参数,或者返回一个函数做为返回值,那么这种函数就要做高阶函数,相当于函数的函数,
        // JavaScript,scala中有大量使用.jdk1.8开始java也支持了,上述的compute我们就看作为高阶函数

        System.out.println(functionTest.convert(1,value-> String.valueOf(value+"hello world")));  //expression


    }

    /**
     * 接收一个整型参数和一个fucntion类型的参数(其唯一的抽象方法是apply)
     * @param a
     * @param function
     * @return
     */
    public int compute(int a,Function<Integer,Integer> function){
        //其实function.apply是由用户使用的时候传入的,即传递行为; 执行的就是return 2*value;
        int apply = function.apply(a);
        return  apply;
    }

    public String convert(int a,Function<Integer,String> function){
        //Function<Integer,String>  代表输入的是整型,输出的是String
        return function.apply(a);

    }


}
