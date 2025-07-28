package Services.impls;

import Data.DishData;
import Data.OrderData;
import Models.Chef;
import Models.Dish;
import Models.Order;
import Models.OrderStatus;
import Services.interfaces.ChefService;

import java.util.List;


public class ChefServiceImpl implements ChefService {
    private static Chef chef;

    public ChefServiceImpl(Chef chef) {
        this.chef = chef;
    }
    @Override
    public void addDish(String dishName, double price) {
        Dish dish = new Dish(dishName, price);
        DishData.addDish(dish);
        System.out.println("Dish "+dishName+" added successfully");
    }
    @Override
    public void editDish(String name, String newName, double newPrice) {
        boolean found=false;
        for (Dish dish:DishData.getDishes()) {
            if(dish.getDishName().equals(name)) {
                dish.setDishName(newName);
                dish.setDishPrice(newPrice);
                found=true;
                break;
            }
        }
        if(!found) {
            System.out.println("Dish "+name+" not found");
        }else  {
            System.out.println("Dish "+name+" updated successfully");
        }
    }
    @Override
    public void viewOrders() {
        OrderData orderData = new OrderData();
        List<Order> orders = orderData.getOrders();
        System.out.println("----------All Orders ----------");
        for (Order order:orders) {
            System.out.println("ID: " + order.getId() +
                    " | Dish: " + order.getDish().getDishName() +
                    " | Qty: " + order.getQuantity() +
                    " | Status: " + order.getOrderStatus() +
                    " | Customer: " + order.getCustomer().getUsername());
        }
        System.out.println("--------------------");
    }
    @Override
    public void updateOrderStatus(int orderId, OrderStatus status){

        Order order=OrderData.getOrderById(orderId);
        if(order!=null){
            order.setOrderStatus(status);
            System.out.println("Order #" + orderId + " updated to: " + status);

        }else  {
            System.out.println("Order #" + orderId + " not found");
        }
}
}
