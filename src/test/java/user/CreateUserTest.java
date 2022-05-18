package user;

import org.junit.Test;
import user.CreateUserBodyRequest;

/*Проверки

        Создание пользователя:
        создать уникального пользователя;
        создать пользователя, который уже зарегистрирован;
        создать пользователя и не заполнить одно из обязательных полей.*/
public class CreateUserTest {
    CreateUserBodyRequest createUserBodyRequest = new CreateUserBodyRequest();

    @Test
    public void createUniqueUser() {
        createUserBodyRequest.generateUniqueData();
        createUserBodyRequest.getResponse().then().statusCode(200);
    }

    @Test
    public void createNoUniqueUser() {
        createUserBodyRequest.requestBodyGenerateNoUnique();
        createUserBodyRequest.getResponse().then().statusCode(403);
    }

    @Test
    public void createNoFieldPasswordUser() {
        createUserBodyRequest.generateUniqueNoPasswordData();
        createUserBodyRequest.getResponse().then().statusCode(403);
    }

    @Test
    public void createNoFieldNameUser() {
        createUserBodyRequest.generateUniqueNoNameData();
        createUserBodyRequest.getResponse().then().statusCode(403);
    }

    @Test
    public void createNoFieldEmailUser() {
        createUserBodyRequest.generateUniqueNoEmailData();
        createUserBodyRequest.getResponse().then().statusCode(403);
    }

}
