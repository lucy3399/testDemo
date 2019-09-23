package module;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by zhuting on 2019/9/19.
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee1 = new Employee();
        employee1.setName("lisi");

        Company company = new Company();
        company.setName("com1");

        List<Employee> employees = Arrays.asList(employee, employee1);
        company.setEmployees(employees); //注释掉 开启 测试

    /*    List<Employee> list = company.getEmployees();
        if (null != list) {
            return list;
        } else {
            return new ArrayList<Employee>();
        }*/

        //下面用函数式编程实现上述内容
        //构造容器
        Optional<Company> optional = Optional.ofNullable(company);
        //map映射的意思,一个输入一个输出,
        System.out.println(optional.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));
    }

    //注意:不要使用Optional做为方法参数,或者类中成员变量 (没有实现序列化接口)
    //而通常是做为方法的返回值,用于规避NPE

   static class Company {

        public Company() {
        }

        private String name;
        private List<Employee> employees;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }


    static class Employee {
        private String  name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
