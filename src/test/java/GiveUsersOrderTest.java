import org.junit.Test;

/*
Получение заказов конкретного пользователя:
        авторизованный пользователь,
        неавторизованный пользователь.*/
public class GiveUsersOrderTest {
GiveUserOrdersRequest giveOrder = new GiveUserOrdersRequest();
@Test
    public void giveOrderNoAuth () {
    giveOrder.giveOrderNoToken();
    giveOrder.getResponse().then().statusCode(401);
}
    @Test
    public void giveOrderAuth () {
    giveOrder.createUserAndOrder();
        giveOrder.giveOrderToken();
        giveOrder.getResponse().then().statusCode(200);
    }
}
