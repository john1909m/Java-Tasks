public class Chef extends Employee {

    public Chef(String name, int age, double salary) {
        super(name, age, salary, "Chef");
    }

    @Override
    public void work(){
        System.out.println("Chef "+ getName() + " is preparing dishes");
    }
}
