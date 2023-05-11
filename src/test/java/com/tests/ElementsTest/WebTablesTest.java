package com.tests.ElementsTest;

import com.pages.Elements.WebTablesPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class WebTablesTest extends TestBase {
    List<Map<String, String>> rows;

    @BeforeMethod
    public void preconditionds() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openWebTables();
    }

    @Test
    public void tableTest() {
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        rows = webTablesPage.getWebTablesData();
        String email = rows.get(2).get("Email");
        System.out.println(email + "123456");
    }
}
