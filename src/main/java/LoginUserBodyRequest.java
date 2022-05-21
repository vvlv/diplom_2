import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import user.LoginUserRequest;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class LoginUserBodyRequest {
    private final String loginUserApi = "https://stellarburgers.nomoreparties.site/api/auth/login";
    Faker faker = new Faker(new Locale("ru"));
    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    @Step("Генерация Запроса для логина")
    public void generateUniqueData() {

        String email = "ivan1990@ya.ru";
        String password = "qwerty1";
        LoginUserRequest createData = new LoginUserRequest(email, password);
        requestBodyGenerate(createData);
    }

    @Step("Генерация тела запроса ")
    public void requestBodyGenerate(LoginUserRequest createData) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(createData)
                .when()
                .post(loginUserApi);
        setResponse(response);
    }

    @Step("Получение ответа при регистрации")
    public void responseLoginBody() {
        LoginUserRequest example = getResponse()
                .as(LoginUserRequest.class);
    }

    @Step("Генерация данных без почты")
    public void generateNoEmailData() {

        String email = null;
        String password = "qwerty1";
        LoginUserRequest createData = new LoginUserRequest(email, password);
        requestBodyGenerate(createData);
    }

    @Step("Генерация данных без пароля")
    public void generateNoPassData() {

        String email = "ivan1990@ya.ru";
        String password = null;
        LoginUserRequest createData = new LoginUserRequest(email, password);
        requestBodyGenerate(createData);
    }

    @Step("Генерация данных Неправильный пароль")
    public void generateWrongPassData() {

        String email = "ivan1990@ya.ru";
        String password = "qwerty11";
        LoginUserRequest createData = new LoginUserRequest(email, password);
        requestBodyGenerate(createData);
    }

    @Step("Генерация данных неверная почта")
    public void generateWrongEmailData() {

        String email = "ivan1990@ya.ruu";
        String password = "qwerty1";
        LoginUserRequest createData = new LoginUserRequest(email, password);
        requestBodyGenerate(createData);
    }
}
