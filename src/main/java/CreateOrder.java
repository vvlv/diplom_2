import java.util.ArrayList;
import java.util.List;

public class CreateOrder {
    private List<String> ingredients;

    private String name;
    private boolean success;
    private Order order;

    public CreateOrder () {}
    public CreateOrder (List<String> ingredients) {
        this.ingredients = ingredients;
    }
    public CreateOrder (String name, Order order, boolean success) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
