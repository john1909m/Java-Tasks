package Services.impls;

import Data.DishData;
import Data.OrderData;
import Models.Customer;
import Models.Dish;
import Models.Order;
import Services.interfaces.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private Customer customer;
    public CustomerServiceImpl(Customer customer) {
        this.customer = customer;

    }
    @Override
    public void viewMenu(){
        DishData.printMenu();

    }
    @Override
    public void makeOrder(String dishName,int quantity){
        Dish dish=DishData.getDishByName(dishName);
        if(dish==null){
            System.out.println("Invalid dish name "+dishName);
            return;
        }
        Order order=new Order(dish,quantity,customer);
        customer.getOrders().add(order);
        OrderData orderData=new OrderData();
        orderData.addOrder(order);
        System.out.println("Order "+dish.getDishName()+" has been created");
    }


}
