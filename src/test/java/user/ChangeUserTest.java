package user;/*Изменение данных пользователя:
        с авторизацией,
        без авторизации,
        Для обеих ситуаций нужно проверить, что любое поле можно изменить. Для неавторизованного пользователя — ещё и то, что система вернёт ошибку.*/

import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import models.UserModel;
import org.junit.Test;
import user.ChangeUserRequest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ChangeUserTest {
    @Test
    public void changeUserEmailTest() {
        ChangeUserRequest ahangeUserData = new ChangeUserRequest();
        ahangeUserData.generateUniqueUser();
        ahangeUserData.requestDataAboutNewUser();
        ahangeUserData.changeNewUserEmailAndNameData();
        ahangeUserData.getResponse().then().statusCode(200);
    }

    @Test
    public void changeUserNameTest() {
        ChangeUserRequest ahangeUserData = new ChangeUserRequest();
        ahangeUserData.generateUniqueUser();
        ahangeUserData.requestDataAboutNewUser();
        ahangeUserData.changeNewUserEmailAndNameData();
        ahangeUserData.getResponse().then().statusCode(200);
    }

    @Test
    public void changeUserNameNoTokenTest() {
        ChangeUserRequest ahangeUserData = new ChangeUserRequest();
        ahangeUserData.generateUniqueUser();
        ahangeUserData.requestDataAboutNewUser();
        ahangeUserData.changeNewUserNameDataNotoken();
        ahangeUserData.getResponse().then().statusCode(401);
    }

    @Test
    public void changeUserEmailNoTokenTest() {
        ChangeUserRequest ahangeUserData = new ChangeUserRequest();
        ahangeUserData.generateUniqueUser();
        ahangeUserData.requestDataAboutNewUser();
        ahangeUserData.changeNewUserEmailDataNoToken();
        ahangeUserData.getResponse().then().statusCode(401);
    }

    @Test
    public void changeUserEmailAndNameResponseTest() {
        ChangeUserRequest ahangeUserData = new ChangeUserRequest();
        ahangeUserData.generateUniqueUser();
        ahangeUserData.requestDataAboutNewUser();
        Response response = ahangeUserData.changeNewUserEmailAndNameData();
        response
                .then()
                .body("user.name", equalTo(ahangeUserData.getNewUserData().getUser().getName()))

                .body("user.email", equalTo(ahangeUserData.getNewUserData().getUser().getEmail()));
    }

}
