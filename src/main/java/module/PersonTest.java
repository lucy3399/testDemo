package module;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by zhuting on 2019/9/1.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 20);
        Person p2 = new Person("lisi", 30);
        Person p3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(p1, p2, p3);
        PersonTest personTest = new PersonTest();
        List<Person> zhangsan = personTest.getPersonByUsername("zhangsan", persons);
        zhangsan.forEach(value -> System.out.println(value));
        System.out.println("================================");
        List<Person> personResult = personTest.getPersonsByAge(20, persons);
        personResult.forEach(value -> System.out.println(value));
        System.out.println("================================");
        List<Person> personResult1 = personTest.getPersonByAge2(20, persons,
                (age, personList) ->
                { return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());}
        );
        personResult1.forEach(value -> System.out.println(value));
        System.out.println("================================");
        List<Person> personResult2 = personTest.getPersonByAge2(20, persons,
                (age, personList) ->
                { return personList.stream().filter(person -> person.getAge() <= age).collect(Collectors.toList());}
        );
        personResult2.forEach(value -> System.out.println(value));
    }

    public  List<Person> getPersonByUsername(String name,List<Person> persons){
       //Predicate和Function类似,也是一个函数式接口,接收一个参数返回布尔值;
        // 具体函数的实现是判断传入的参数是否符合某个规则,符合return true,否则false
        return persons.stream().filter(person ->person.getUsername().equals(name)).collect(Collectors.toList());
   //上述将person转化为一个流,过滤符合person对象里面的username和传入的参数中的name相同,最后转换为list
    }

    //根据年龄进行查询 俩入参,一结果->BiFunction
    public List<Person> getPersonsByAge(int age,List<Person> persons){
        BiFunction<Integer,List<Person>,List<Person>> biFunction=
        (ageOfPerson,personList)->personList.stream().filter(person->person.getAge()>age).collect(Collectors.toList());
        //注意expression是没有{},若是statement body需要{}
        return biFunction.apply(age,persons);
    }

    //灵活性:对于年龄的限制,用的时候再传递进来,实现了行为传递的灵活性
    public List<Person> getPersonByAge2(int age,List<Person> persons,  BiFunction<Integer,List<Person>,List<Person>> biFunction){
          return biFunction.apply(age,persons);
    }
}
