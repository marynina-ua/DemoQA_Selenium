package com.pages.Forms;

import com.pages.data.StudentRegistrationFormData;
import com.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]")
    WebElement genderFemale;
    @FindBy(xpath = "//*[@id=\"userNumber\"]")
    WebElement mobile;
//    @FindBy(xpath = "//*[@id=\"dateOfBirthInput\"]")
//    WebElement dateOfBirthInput;
    @FindBy(xpath = "//*[@id=\"subjectsContainer\"]/div/div[1]")
    WebElement subjects;
    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]")
    WebElement hobbiesMusic;
    @FindBy(id="uploadPicture")
    WebElement uploadPicture;
    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    WebElement currentAddress;
    @FindBy(xpath="//*[@id=\"state\"]")
    WebElement state;
    @FindBy(xpath = "//*[@id=\"city\"]")
    WebElement city;
    @FindBy(xpath = "//*[@id=\"submit\"]")
    WebElement submit;
    @FindBy(id = "closeLargeModal")
    WebElement closeLargeModal;


    public PracticeFormPage typeName() throws IOException {
        hideAds();
        Actions actions = new Actions(driver);

        type(firstName, StudentRegistrationFormData.FIRST_NAME);

        type(lastName, StudentRegistrationFormData.LAST_NAME);

        type(userEmail, StudentRegistrationFormData.EMAIL);

        click(genderFemale);

        type(mobile, StudentRegistrationFormData.MOBILE_NUMBER);

        WebElement dateBox = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        Keys cmdCtrl = getCmdCtrl();
        actions.keyDown(dateBox, cmdCtrl).sendKeys("a").keyUp(cmdCtrl).perform();
        dateBox.sendKeys("9 25 2013" + Keys.ENTER);

        actions.sendKeys(subjects, "C").perform();
        WebElement dropDownListItem = driver.findElement(By.xpath("//*[text()='Computer Science']"));
        dropDownListItem.click();
        wait(2000);

        click(hobbiesMusic);

//        selectPicture();

        type(currentAddress, "Street 23, Kiev");

        widgetsClick();

        actions.sendKeys(state, "NCR" + Keys.ENTER).perform();
        wait(500);
        actions.sendKeys(city, "Delhi" + Keys.ENTER).perform();

        click(submit);

        return this;
    }

    @FindBy(xpath = "//*[@id=\"example-modal-sizes-title-lg\"]")
    WebElement modalWindow;
    public String  confirmText() {
        return modalWindow.getText();
    }

    public void selectPicture() throws IOException {
        String home = System.getProperty("user.home");
        String path = home+ "/Downloads/sampleFile.jpeg";
        File file = new File(path);
        try { file.createNewFile(); } catch (IOException e) {
            System.out.println("File already excited");
        }
        uploadPicture.sendKeys(path);
    }


    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]")
    WebElement widgets;
    public void widgetsClick(){
        clickWithJSExecutor(widgets, 0, 200);
        wait(500);
    }

    public String namePresent(){
        type(firstName, "");
        return firstName.getAttribute("value");
    }

    public PracticeFormPage submitEmptyForm(){
        widgetsClick();
        clickWithJSExecutor(submit, 0, 250);
        return this;
    }

    @FindBy(xpath = "/html/body/div[5]/div")
    WebElement modalForm;

    public boolean formIsDisplayed() {
        try{
            modalForm.isDisplayed();
            return true;
        } catch (Exception e) {
            System.out.println("return false");
            return false;
        }
//        modalForm.isDisplayed();
//        return false;
    }


    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]")
    WebElement male;

    public PracticeFormPage clickOnMale(){
        click(male);
        return this;
    }
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]")
    WebElement genderWrapper;

    public int getSelectedRadioButtonsCount(){
        return (int) genderWrapper.findElements(By.name("gender")).stream().filter(elem -> elem.isSelected()).count();
    }

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]")
    WebElement hobbiesWrapper;

    public PracticeFormPage chooseAllHobbies() {
        List<WebElement> allHobbies = hobbiesWrapper.findElements(By.tagName("input"));
        for (WebElement hobby: allHobbies) {
            new Actions(driver).click(hobby).perform();
            //click(hobby);
        }
        wait(1000);

        return this;
    }

    public boolean getSelectedCheckBoxCount(){
        return hobbiesWrapper.findElements(By.tagName("input")).stream().allMatch(elem -> elem.isSelected());
    }




//    public boolean isErrorMessagePresent(By by) { // Массивом проверяем что элементов больше чем 0. (LoginForm)
//        if (driver.findElements(by).size() == 1) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

}
