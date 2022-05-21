package order;

import models.OrderModel;

import java.util.List;

public class CreateOrder {
    private List<String> ingredients;

    private String name;
    private boolean success;
    private OrderModel order;

    public CreateOrder() {
    }

    public CreateOrder(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public CreateOrder(String name, OrderModel order, boolean success) {
        this.name = name;
        this.order = order;
        this.success = success;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }
}
