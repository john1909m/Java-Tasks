import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John",21,3000,"Engineer"));
        employees.add(new Employee("Moahmed",21,3000,"Engineer"));
        employees.add(new Chef("Ahmed",21,3000));
        employees.add(new Chef("Karim",21,3000));
        employees.add(new Waiter("Omar",21,3000));
        employees.add(new Waiter("Salma",21,3000));
        for(Employee e:employees){
            e.introduce();
            e.work();
            System.out.println("----------------------------");
        }


    }
}
