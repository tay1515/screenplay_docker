package starter.ui;

import org.openqa.selenium.By;

public class LoginUI {
    public static By BTN_SIGN_IN = By.xpath("//a[@id='LoginLink' and contains(., 'Sign In')]");

    public static By USER_NAME = By.id("uid");

    public static By USER_PASSWORD = By.id("passw");

    public static By BTN_LOGIN = By.name("btnSubmit");

}
