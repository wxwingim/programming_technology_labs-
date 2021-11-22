import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {
//        String [] array = {"aaa", "AA", "bb", "ccc", "bb", "aaa", "ccc", "ccc"};
//
//        StrArray strArray = new StrArray(array);
//        strArray.StreamArray();

        // создать отделы
        // вывести n старшиш сотрудников(имена) в отделе в строку

        List<Employee> employees =  new ArrayList<>(Arrays.asList(
                new Employee("John", 30, 1000, Employee.Department.department1),
                new Employee("Anna", 40, 3000, Employee.Department.department1),
                new Employee("Erick", 25, 1400, Employee.Department.department1),
                new Employee("Lee", 51, 3500, Employee.Department.department1),
                new Employee("Kira", 32, 2000, Employee.Department.department2),
                new Employee("Alex", 27, 2300, Employee.Department.department2),
                new Employee("Jeck", 36, 5100, Employee.Department.department2)
        ));

        Staff staff = new Staff(employees);

        System.out.println(staff.Avg());

        System.out.println(staff.NSenior(3));

        System.out.println(staff.NSeniorFromDep(2, Employee.Department.department1));
    }
}
