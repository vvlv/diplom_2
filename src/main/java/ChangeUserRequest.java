import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class ChangeUserRequest {
    private final String changeUserInfoApi = "https://stellarburgers.nomoreparties.site/api/auth/user";
    //Get получение данных пользователя
    //Patch обновление данных полльзователя
    Faker faker = new Faker(new Locale("ru"));
    private Response response;
    public void setResponse (Response response){
        this.response = response;
    }
    public Response getResponse (){
        return response;
    }
    CreateUserBodyRequest createNewUser = new CreateUserBodyRequest();
    CreateUserRequest newUserData = new CreateUserRequest();

    @Step("Генерация нового пользователя и получение его данных")
    public void generateUniqueUser () {
        createNewUser.generateUniqueData();
        setResponse(createNewUser.getResponse());
        newUserData =  getResponse()
                .as(CreateUserRequest.class);
    }
    @Step("Получение токена")
    public String getToken () {
        return getResponse().as(CreateUserRequest.class).getAccessToken();
    }
    @Step("Запрос обновления данных")
    public void requestDataAboutNewUser () {
        ChangeUser responseUserData =  given()
                .header("Content-type", "application/json")
                .header("authorization", newUserData.getAccessToken())
                .when()
                .get(changeUserInfoApi).as(ChangeUser.class);
    }
    @Step("Обновление данных об почте")
    public void changeNewUserEmailData () {
        newUserData.setUser(new User(newUserData.getUser().getName(),faker.internet().emailAddress()));
        Response responseUserData =  given()
                .header("Content-type", "application/json")
                .header("authorization", newUserData.getAccessToken())
                .body(newUserData)
                .when()
                .patch(changeUserInfoApi);
        setResponse(responseUserData);
    }
    @Step("Обновление данных об имени")
    public void changeNewUserNameData () {
        newUserData.setUser(new User("NewUserName",newUserData.getUser().getEmail()));
        Response responseUserData =  given()
                .header("Content-type", "application/json")
                .header("authorization", newUserData.getAccessToken())
                .body(newUserData)
                .when()
                .patch(changeUserInfoApi);
        setResponse(responseUserData);
    }
    @Step("Обновление данных об почте")
    public void changeNewUserEmailDataNoToken () {
        newUserData.setUser(new User(newUserData.getUser().getName(),faker.internet().emailAddress()));
        Response responseUserData =  given()
                .header("Content-type", "application/json")

                .body(newUserData)
                .when()
                .patch(changeUserInfoApi);
        setResponse(responseUserData);
    }
    @Step("Обновление данных об имени")
    public void changeNewUserNameDataNotoken () {
        newUserData.setUser(new User("NewUserName",newUserData.getUser().getEmail()));
        Response responseUserData =  given()
                .header("Content-type", "application/json")

                .body(newUserData)
                .when()
                .patch(changeUserInfoApi);
        setResponse(responseUserData);
    }


}
