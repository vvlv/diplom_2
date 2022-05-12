import org.junit.Test;

/*Логин пользователя:
        логин под существующим пользователем,
        логин с неверным логином и паролем.*/
public class LoginUserTest {
@Test
    public void userLogin (){
    LoginUserBodyRequest login = new LoginUserBodyRequest();
    login.generateUniqueData();
    login.getResponse().then().statusCode(200);

}
    @Test
    public void userNoLoginName (){
        LoginUserBodyRequest login = new LoginUserBodyRequest();
        login.generateNoEmailData();
        login.getResponse().then().statusCode(401);

    }
    @Test
    public void userNoLoginPass (){
        LoginUserBodyRequest login = new LoginUserBodyRequest();
        login.generateNoPassData();
        login.getResponse().then().statusCode(401);

    }
    @Test
    public void userWrongLoginPass (){
        LoginUserBodyRequest login = new LoginUserBodyRequest();
        login.generateWrongPassData();
        login.getResponse().then().statusCode(401);

    }
    @Test
    public void userWrongLoginEmail (){
        LoginUserBodyRequest login = new LoginUserBodyRequest();
        login.generateWrongEmailData();
        login.getResponse().then().statusCode(401);

    }
}
