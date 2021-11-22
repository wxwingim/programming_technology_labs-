public class Employee {
    private String name;
    private int age;
    private int salary;
    private Department dep;

    enum Department{
        department1(), department2;
    }

    public Employee(String name, int age, int salary, Department dep){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dep = dep;
    }

    public int getSalary() {

        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Department getDep() {
        return dep;
    }
}
