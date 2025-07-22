public class Waiter extends Employee {
    public Waiter(String name, int age,double salary) {
        super(name,age,salary,"Waiter");
    }
    @Override
    public void work() {
        System.out.println("Waiter "+ getName() + " is serving customers");
    }
}
