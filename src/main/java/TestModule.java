import module.Cluster;

/**
 * Created by zhuting on 2019/8/28.
 * https://www.cnblogs.com/hpyg/p/8005599.html
 * 在Java中
 * 基本类型作为参数传递时，是传递值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的
 * 对象作为参数传递时，是把对象在内存中的地址拷贝了一份传给了参数。
 *
 * 基本类型（byte,short,int,long,double,float,char,boolean）为传值；
 * 对象类型（Object，数组，容器）为传引用；String、Integer、Double等immutable类型
 * 因为类的变量设为final属性，无法被修改，只能重新赋值或生成对象。
 * 当Integer作为方法参数传递时，对其赋值会导致原有的引用被指向了方法内的栈地址，失去原有的的地址指向，
 * 所以对赋值后的Integer做任何操作都不会影响原有值。

 原文链接：https://blog.csdn.net/weixin_36759405/article/details/82764339
 * ，
 */
public class TestModule {
     static final String cluster2  = "eg";

    public static void main(String[] args) {


      Cluster cluster = new Cluster();
        cluster.setGroup("group1");
        String a="aaaaa";
        System.out.println(a);
        modifyValue(cluster,a);
        System.out.println("asd"+cluster);
        System.out.println(a);

    }

    private static void modifyValue(Cluster cluster,String a) {

         a="bbbbbbbb";
        System.out.println(a);
        cluster.setGroup("group2");
    }


}
