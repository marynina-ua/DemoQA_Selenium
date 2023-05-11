package com.pages.data;

import com.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class LoginData extends PageBase {
    public LoginData(WebDriver driver) {
        super(driver);
    }

    public static final String USERNAME = "YevMar";
    public static final String PASSWORD = "Qwerty!123";

    //"imaksimov2";
    //"!m@ksimoV2"
}
