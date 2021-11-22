import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Staff {
    List<Employee> employees;

    public Staff(List<Employee> employees){
        this.employees = employees;
    }

    public Double Avg(){
        OptionalDouble result = employees.stream()
                .map(Employee::getSalary) // преобразовываем Stream Employee в Stream salary
                .mapToInt(e -> e).average();
        return result.getAsDouble();
    }

    public String NSenior (int n){
        String result = employees.stream()
                .sorted((o1,o2) -> o2.getAge() - o1.getAge())
                .limit(n)
                .map(Employee::getName)
                .collect(Collectors.joining(", " , n + " старших сотрудников: " , "."));
        return result;
    }
    public String NSeniorFromDep (int n, Employee.Department dep){
        String result = employees.stream()
                .filter(person -> person.getDep() == Employee.Department.department1)
                .sorted((o1,o2) -> o1.getAge() - o2.getAge())
                .limit(n)
                .map(Employee::getName)
                .collect(Collectors.joining(", " , n + " младших сотрудника(ов) из отдела: " , "."));
        return result;
    }
}
