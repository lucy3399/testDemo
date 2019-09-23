package module;

import java.util.function.Supplier;

/**
 * Created by zhuting on 2019/9/18.
 */
public class SupplierTest {
    public static void main(String[] args) {
        //不接收参数同时返回一个结果 场景:工厂(若工厂是接收一个参数返回结果,则使用function)
        Supplier<String> supplier=()->"hello world";
        System.out.println(supplier.get());
    }
}
