package user;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class CreateUserBodyRequest {
    private final String createUserApi = "https://stellarburgers.nomoreparties.site/api/auth/register";
    Faker faker = new Faker(new Locale("ru"));
    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }


    @Step("Генерация Уникальных данных для создания пользователя")
    public void generateUniqueData() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        CreateUserRequest createData = new CreateUserRequest(email, password, name);
        requestBodyGenerate(createData);
    }

    @Step("Генерация Уникальных данных для создания пользователя БЕЗ password")
    public void generateUniqueNoPasswordData() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        CreateUserRequest createData = new CreateUserRequest(email, name);
        requestBodyGenerate(createData);
    }

    @Step("Генерация Уникальных данных для создания пользователя БЕЗ name")
    public void generateUniqueNoNameData() {

        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        CreateUserRequest createData = new CreateUserRequest(email, password);
        requestBodyGenerate(createData);
    }

    @Step("Генерация Уникальных данных для создания пользователя БЕЗ email")
    public void generateUniqueNoEmailData() {
        String name = faker.name().firstName();
        String password = faker.internet().password();
        CreateUserRequest createData = new CreateUserRequest(password, name);
        requestBodyGenerate(createData);
    }

    @Step("Генерация тела запроса ")
    public void requestBodyGenerate(CreateUserRequest createData) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(createData)
                .when()
                .post(createUserApi);
        setResponse(response);
    }

    @Step("Генерация тела запроса для НЕ уникального пользователя")
    public void requestBodyGenerateNoUnique() {
        CreateUserRequest createData = new CreateUserRequest("email@email.ru", "password", "name");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(createData)
                .when()
                .post(createUserApi);
        setResponse(response);
    }
}
