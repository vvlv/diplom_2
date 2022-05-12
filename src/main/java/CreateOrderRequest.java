import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class CreateOrderRequest {
    private final String createOrderApi = "https://stellarburgers.nomoreparties.site/api/orders";

    Faker faker = new Faker(new Locale("ru"));
    private Response response;
    public void setResponse (Response response){
        this.response = response;
    }
    public Response getResponse (){
        return response;
    }



    @Step("Формирование тела запроса")
    public void createOrderBody () {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("61c0c5a71d1f82001bdaaa6d");
        ingredients.add("61c0c5a71d1f82001bdaaa71");
        Response responseUserData =  given()
                .header("Content-type", "application/json")
                .body(new CreateOrder(ingredients))
                .when()
                .post(createOrderApi);
        setResponse(responseUserData);
    }
    @Step("чтение тела ответа за запрос с заказом")
    public void responseOrderCheck () {
        CreateOrder responseOrder = getResponse().as(CreateOrder.class);
    }
    @Step("Логин пользователем и формирование запроса с токеном")
    public void loginAndGiveToken () {
        ChangeUserRequest login = new ChangeUserRequest();
        login.generateUniqueUser();


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
    @Step("Формирование тела запроса без ингридиентов")
    public void createOrderBodyNoIngredients () {
        List<String> ingredients = new ArrayList<>();

        Response responseUserData =  given()
                .header("Content-type", "application/json")
                .body(new CreateOrder(ingredients))
                .when()
                .post(createOrderApi);
        setResponse(responseUserData);
    }
    @Step("Формирование тела запроса c неверных хешем ингридиентов")
    public void createOrderBodyWrongHashIngredients () {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("654356789hgf");
        ingredients.add("654356789hgf");
        Response responseUserData =  given()
                .header("Content-type", "application/json")
                .body(new CreateOrder(ingredients))
                .when()
                .post(createOrderApi);
        setResponse(responseUserData);
    }
}
