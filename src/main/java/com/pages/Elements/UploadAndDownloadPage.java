package com.pages.Elements;

import com.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class UploadAndDownloadPage extends PageBase {
    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="downloadButton")
    WebElement downloadButton;

    @FindBy(id="uploadFile")
    WebElement uploadFile;

    public boolean verifyDownload() {
        // Clicked -> files is download -> check file exists

        String home = System.getProperty("user.home");
        String path = home+ "/Downloads/sampleFile.jpeg";
        File f = new File(path);

        if (f.exists()) {
            f.delete();
        }

        click(downloadButton);
        wait(4000);

        if (f.exists()) {
            f.delete();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public UploadAndDownloadPage selectFile() throws IOException {
        String home = System.getProperty("user.home");
        String path = home+ "/Downloads/sampleFile.jpeg";
        File file = new File(path);
        try { file.createNewFile(); } catch (IOException e) {
            System.out.println("File already excited");
        }
        uploadFile.sendKeys(path);
        wait(2000);
        return this;
    }

    @FindBy(id="uploadedFilePath")
    WebElement uploadedFilePath;


    public boolean checkFileIsSelected() {
        return uploadedFilePath.isDisplayed();
    }
}
