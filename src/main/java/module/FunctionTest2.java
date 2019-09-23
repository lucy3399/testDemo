package module;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by zhuting on 2019/9/1.
 */
//compose和after方法的使用
public class FunctionTest2 {
    public static void main(String[] args) {

        FunctionTest2 test = new FunctionTest2();
        System.out.println(test.compute1(2,value->value*3,value->value*value)); //12
        System.out.println(test.compute2(2,value->value*3,value->value*value));  //36


        System.out.println(test.compute3(1,2,(value1,value2) -> value1+value2));
        System.out.println(test.compute3(1,2,(value1,value2) -> value1-value2));
        System.out.println(test.compute3(1,2,(value1,value2) -> value1*value2));
        System.out.println(test.compute3(1,2,(value1,value2) -> value1/value2));

        System.out.println(test.compute4(2,3,(value1,value2)->value1+value2,value->value*value)); //25


    }

    public int compute1(int a, Function<Integer,Integer> function1 ,Function<Integer,Integer> function2){
        //对于compose方法而言,先执行function2的apply,将执行的结果再做为function1的apply的方法输入来执行
       return function1.compose(function2).apply(a);
    }


    public int compute2(int a, Function<Integer,Integer> function1 ,Function<Integer,Integer> function2){
        //对于andThen方法而言,先执行function1的apply,将执行的结果再做为function2的apply的方法来执行
        return function1.andThen(function2).apply(a);
    }

    //求和
    public int add(int a,int b){
        return a+b;
    }
    //使用BiFunction来实现  两个参数一个结果
    public int compute3(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a,b);
    }


    public int compute4(int a, int b, BiFunction<Integer,Integer,Integer> biFunction,Function<Integer,Integer> function){
        //先应用biFunction的apply再去应用Function的apply
        //第二个参数Function不是BiFunction的原因,因为先是使用的biFunction,返回值只有一个,所以只有一个值做为输入,所以是Function
        return biFunction.andThen(function).apply(a,b);
    }
}
