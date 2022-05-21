package user;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import models.UserModel;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class ChangeUserRequest {
    private final String changeUserInfoApi = "https://stellarburgers.nomoreparties.site/api/auth/user";
    //Get получение данных пользователя
    //Patch обновление данных полльзователя
    Faker faker = new Faker(new Locale("ru"));
    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    CreateUserBodyRequest createNewUser = new CreateUserBodyRequest();
    CreateUserRequest newUserData = new CreateUserRequest();

    public CreateUserBodyRequest getCreateNewUser() {
        return createNewUser;
    }

    public CreateUserRequest getNewUserData() {
        return newUserData;
    }

    @Step("Генерация нового пользователя и получение его данных")
    public void generateUniqueUser() {
        createNewUser.generateUniqueData();
        setResponse(createNewUser.getResponse());
        newUserData = getResponse()
                .as(CreateUserRequest.class);
    }

    @Step("Получение токена")
    public String getToken() {
        return getResponse().as(CreateUserRequest.class).getAccessToken();
    }

    @Step("Запрос обновления данных")
    public void requestDataAboutNewUser() {
        ChangeUser responseUserData = given()
                .header("Content-type", "application/json")
                .header("authorization", newUserData.getAccessToken())
                .when()
                .get(changeUserInfoApi).as(ChangeUser.class);
    }

    @Step("Обновление данных об почте")
    public Response changeNewUserEmailAndNameData() {
        newUserData.setUser(new UserModel(faker.name().firstName(), faker.internet().emailAddress()));
        Response responseU;
        return responseU = given()
                .header("Content-type", "application/json")
                .header("authorization", newUserData.getAccessToken())
                .body(newUserData.getUser())
                .when()
                .patch(changeUserInfoApi);

    }

    @Step("Обновление данных об почте")
    public void changeNewUserEmailDataNoToken() {
        newUserData.setUser(new UserModel(newUserData.getUser().getName(), faker.internet().emailAddress()));

        Response responseUserData = given()
                .header("Content-type", "application/json")
                .body(newUserData)
                .when()
                .patch(changeUserInfoApi);
        setResponse(responseUserData);
    }

    @Step("Обновление данных об имени")
    public void changeNewUserNameDataNotoken() {
        newUserData.setUser(new UserModel("NewUserName", newUserData.getUser().getEmail()));
        Response responseUserData = given()
                .header("Content-type", "application/json")

                .body(newUserData)
                .when()
                .patch(changeUserInfoApi);
        setResponse(responseUserData);
    }


}
