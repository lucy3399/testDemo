package module;

import java.util.*;

/**
 * Created by zhuting on 2019/9/1.
 */
public class StringComparator {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("zhangsan","lisi","wangwu");
/*      //I:
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1); //倒序
            }
        });
        System.out.println(names);  //[zhangsan, wangwu, lisi]*/

        //II:
        //Comparator 1.8中compare也成为了函数式方法
        Collections.sort(names,(String  o1,String o2)->{
            return  o2.compareTo(o1);
        });
        System.out.println(names);

        //II:
        //去掉入参类型由编译器推倒
        Collections.sort(names,(  o1, o2)->{
            return  o2.compareTo(o1);
        });
        System.out.println(names);


        //IV:
        //去掉{},以及return可以
        //补充:   expression:  o2.compareTo(o1)
        //       statement:  {return  o2.compareTo(o1);}
        //因为就一条所以可以使用表达式风格代替
        Collections.sort(names,(  o1, o2)-> o2.compareTo(o1));
        System.out.println(names);

        //III:
        //Comparator 1.8中compare也成为了函数式方法
        Collections.sort(names,Comparator.reverseOrder());
        System.out.println(names);
    }
}
