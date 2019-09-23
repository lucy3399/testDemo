package module;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by zhuting on 2019/9/1.
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate= p ->p.length()>5;
        System.out.println(predicate.test("hello"));
    }

}
