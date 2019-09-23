package module;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * Created by zhuting on 2019/9/18.
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest=  new  BinaryOperatorTest();
        System.out.println(binaryOperatorTest.compute(1,2,(a,b)->a+b));
        System.out.println(binaryOperatorTest.compute(1,2,(a,b)->a-b));
        System.out.println("--------------");

        System.out.println(binaryOperatorTest.getShort("hello123","world",(a,b)->a.length()-b.length()));
        System.out.println(binaryOperatorTest.getShort("hello123","world",(a,b)->a.charAt(0)-b.charAt(0)));

    }


   //使用BinaryOperator进行数字加减 (与BiFunction的区别在于BinaryOperator中泛型是相同的)
    public  int compute(int a, int b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }


    public  String getShort(String a, String b, Comparator<String> comparator){
//        return BinaryOperator.minBy(comparator).apply(a,b);
        return BinaryOperator.maxBy(comparator).apply(a,b);
    }
}
