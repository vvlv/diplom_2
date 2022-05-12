import org.junit.Test;

/*Создание заказа:
        с авторизацией,
        без авторизации,
        с ингредиентами,
        без ингредиентов,
        с неверным хешем ингредиентов.*/
public class CreateOrderTest {
    @Test
    public void orderCreate_NoAuth () {
        CreateOrderRequest order =new CreateOrderRequest();
        order.createOrderBody();
        order.getResponse().then().statusCode(200);
    }
    @Test
    public void orderCreate_Auth () {
        CreateOrderRequest order =new CreateOrderRequest();
        order.loginAndGiveToken();
        order.getResponse().then().statusCode(200);
    }
    @Test
    public void orderCreate_NoIngredients () {
        CreateOrderRequest order =new CreateOrderRequest();
        order.createOrderBodyNoIngredients();
        order.getResponse().then().statusCode(400);
    }
    @Test
    public void orderCreate_WrongHashIngredients () {
        CreateOrderRequest order =new CreateOrderRequest();
        order.createOrderBodyWrongHashIngredients();
        order.getResponse().then().statusCode(400);
    }

}
