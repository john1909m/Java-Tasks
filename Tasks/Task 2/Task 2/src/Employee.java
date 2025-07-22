public class Employee extends Person {
    private double salary;
    private String role;
    Employee(String name, int age, double salary, String role) {
        super(name, age);
        this.salary = salary;
        this.role = role;
    }
    public double getSalary() {
        return salary;
    }
    public String getRole() {
        return role;
    }
    public void work(){
        System.out.println("Employee Role: "+ role);
    }
}
