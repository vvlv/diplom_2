/*Изменение данных пользователя:
        с авторизацией,
        без авторизации,
        Для обеих ситуаций нужно проверить, что любое поле можно изменить. Для неавторизованного пользователя — ещё и то, что система вернёт ошибку.*/

import org.junit.Test;

public class ChangeUserTest {
@Test
    public void changeUserEmailTest () {
    ChangeUserRequest ahangeUserData =new ChangeUserRequest();
    ahangeUserData.generateUniqueUser();
    ahangeUserData.requestDataAboutNewUser();
    ahangeUserData.changeNewUserEmailData();
    ahangeUserData.getResponse().then().statusCode(200);
}
    @Test
    public void changeUserNameTest () {
        ChangeUserRequest ahangeUserData =new ChangeUserRequest();
        ahangeUserData.generateUniqueUser();
        ahangeUserData.requestDataAboutNewUser();
        ahangeUserData.changeNewUserNameData();
        ahangeUserData.getResponse().then().statusCode(200);
    }
    @Test
    public void changeUserNameNoTokenTest () {
        ChangeUserRequest ahangeUserData =new ChangeUserRequest();
        ahangeUserData.generateUniqueUser();
        ahangeUserData.requestDataAboutNewUser();
        ahangeUserData.changeNewUserNameDataNotoken();
        ahangeUserData.getResponse().then().statusCode(401);
    }
    @Test
    public void changeUserEmailNoTokenTest () {
        ChangeUserRequest ahangeUserData =new ChangeUserRequest();
        ahangeUserData.generateUniqueUser();
        ahangeUserData.requestDataAboutNewUser();
        ahangeUserData.changeNewUserEmailDataNoToken();
        ahangeUserData.getResponse().then().statusCode(401);
    }

}
