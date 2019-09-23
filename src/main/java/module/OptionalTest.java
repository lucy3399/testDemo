package module;

import java.util.Optional;

/**
 * Created by zhuting on 2019/9/19.
 */
public class OptionalTest {
    //场景eg:db查询出的数据可能为null可能不为null则ofNullable工厂方法
    //确定肯定为null或者不为null用empty或of
    public static void main(String[] args) {
//        Optional<String> optional = Optional.of("hello");
//        Optional<String> optional = Optional.empty();
        Optional<String> optional = Optional.ofNullable("hello");
        //需要这样搭配isPresent使用才会没有告警,但此也不完美,依然麻烦
       /* if(optional.isPresent()){
            System.out.println(optional.get());
        }

        if(optional.isPresent()){ //不要这样写,要通过函数式的方式去写
        ...
        }else{
        ...
        }
        */

        //optional推荐使用方式:值不为null才去做,否则什么也不做
        optional.ifPresent(item -> System.out.println(optional.get()));
        System.out.println("----------");
        //如果里面有值打印值,没有值,则把"word"打印出来
        System.out.println(optional.orElse("word"));
        System.out.println("----------");
        //接收supplier接口,不接收参数返回一个值,如果没有值,获取一个值,打印出来
        System.out.println(optional.orElseGet(()->"nihao"));
    }
}
