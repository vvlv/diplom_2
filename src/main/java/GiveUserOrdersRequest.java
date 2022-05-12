import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GiveUserOrdersRequest {
    private final String createOrderApi = "https://stellarburgers.nomoreparties.site/api/orders";
    private final String giveOrderApi ="https://stellarburgers.nomoreparties.site/api/orders";

    private Response response;
    public void setResponse (Response response){
        this.response = response;
    }
    public Response getResponse (){
        return response;
    }
    private String localUseToken;

    public String getLocalUseToken() {
        return localUseToken;
    }

    public void setLocalUseToken(String localUseToken) {
        this.localUseToken = localUseToken;
    }

    @Step("Формирование пользователя и заказа")
    public void createUserAndOrder() {
        ChangeUserRequest login = new ChangeUserRequest();
        login.generateUniqueUser();
setLocalUseToken(login.getToken());
        List<String> ingredients = new ArrayList<>();
        ingredients.add("61c0c5a71d1f82001bdaaa6d");
        ingredients.add("61c0c5a71d1f82001bdaaa71");
        Response responseUserData =  given()
                .header("Content-type", "application/json")
                .header("authorization", login.getToken())
                .body(new CreateOrder(ingredients))
                .when()
                .post(createOrderApi);
        setResponse(responseUserData);

    }
    @Step("Запрос получения заказов без токена")
    public void giveOrderNoToken () {
        Response responseUserData =  given()
                .header("Content-type", "application/json")
                .when()
                .get(giveOrderApi);
        setResponse(responseUserData);
    }
    @Step("Запрос получения заказов авторизированным пользователем")
    public void giveOrderToken () {
        Response responseUserData =  given()
                .header("Content-type", "application/json")
                .header("authorization", getLocalUseToken())
                .when()
                .get(giveOrderApi);
        setResponse(responseUserData);
    }
}