package module;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zhuting on 2019/9/8.
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        PredicateTest2 predicateTest2 = new PredicateTest2();
        //打印偶数
        predicateTest2.conditionFilter(list,item->item%2==0);
        System.out.println("===================");
        //打印奇数
        predicateTest2.conditionFilter(list,item->item%2!=0);
        System.out.println("===================");
        //打印出大于5的数字
        predicateTest2.conditionFilter(list,item->item>5);
        System.out.println("===================");
        //打印出所有的元素
        predicateTest2.conditionFilter(list,item->true);
        System.out.println("===================");
        //一个元素都不打印
        predicateTest2.conditionFilter(list,item->false);
        System.out.println("-------------------");
        //>5并且是偶数
        predicateTest2.conditionFilter2(list,item->item>5,item->item%2!=0);
        System.out.println("-------------------");
        System.out.println(predicateTest2.isEqual("test").test("test"));
    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        for (Integer integer : list) {
            if(predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2){
        for (Integer integer : list) {
//            predicate.or(predicate2).test(integer)
//                    predicate.or(predicate2).negate().test(integer)
            if(predicate.and(predicate2).test(integer)){
                System.out.println(integer);
            }
        }
    }

    public  Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }
}
