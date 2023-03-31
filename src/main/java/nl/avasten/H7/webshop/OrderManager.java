package nl.avasten.H7.webshop;

import java.util.ArrayList;
import java.util.UUID;

// This is actually the DAO
public class OrderManager {

  private static final OrderManager ordermanager = new OrderManager();
  private ArrayList<Order> orders;

  private OrderManager() {
    this.orders = new ArrayList<>();
  }

  public static OrderManager getOrderManager() {
    return ordermanager;
  }

  public void addOrder(Order order) {
    this.orders.add(order);
  }

  public void printAllOrders() {
    if (orders.size() == 0) {
      System.out.println("Geeen orders geplaatst!");
    } else {
      for (Order o : orders) {
        System.out.println(o.toString());
      }
    }
  }

  public Order getOrder(UUID id) {
    return this.orders.stream()
        .filter(item -> item.getId() == id)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
