package appiumfirst;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumFirstProject {


    static AppiumDriver appiumDriver;
    public static void main(String args[]) throws MalformedURLException {
        getCalculator();


    }

    public static void getCalculator() throws MalformedURLException {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("deviceName","Redmi");
        cap.setCapability("udid","c0d1efaa7d03");
        cap.setCapability("platformName","Android");

        cap.setCapability("platformVersion","6.01");
        cap.setCapability("appPackage","org.edx.mobile");
        cap.setCapability("appActivity","org.edx.mobile.view.SplashActivity");

        URL url =new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver=new AppiumDriver(url,cap);
        System.out.println("APplication started//....");
        verifyUserNameAndPasswordFields();
        loginThroughGoogleButton();
        logOutFromApplication();
    /*
        MobileElement onebutton= (MobileElement) appiumDriver.findElement(By.id("com.oneplus.calculator:id/digit_1"));
        MobileElement fiveButton= (MobileElement) appiumDriver.findElement(By.id("com.oneplus.calculator:id/digit_5"));
        MobileElement zeroButton= (MobileElement) appiumDriver.findElement(By.id("com.oneplus.calculator:id/digit_0"));
        MobileElement twoButton= (MobileElement) appiumDriver.findElement(By.id("com.oneplus.calculator:id/digit_2"));

        MobileElement multiplyButton= (MobileElement) appiumDriver.findElement(By.id("com.oneplus.calculator:id/op_mul"));
        MobileElement addButton= (MobileElement) appiumDriver.findElement(By.id("com.oneplus.calculator:id/op_add"));
        MobileElement equalsButton= (MobileElement) appiumDriver.findElement(By.id("com.oneplus.calculator:id/eq"));

        MobileElement resultText= (MobileElement) appiumDriver.findElement(By.id("com.oneplus.calculator:id/result"));

        onebutton.click();
        fiveButton.click();
        multiplyButton.click();
        twoButton.click();
        zeroButton.click();
        equalsButton.click();
        String result=resultText.getText();

        System.out.println("result "+result);
            */



        appiumDriver.quit();



    }

    public static void verifyUserNameAndPasswordFields(){

        MobileElement loginButton=(MobileElement) appiumDriver.findElement(By.id("org.edx.mobile:id/log_in"));
        MobileElement createAccountButton=(MobileElement) appiumDriver.findElement(By.id("org.edx.mobile:id/sign_up"));

        loginButton.click();
        WebDriverWait wait=new WebDriverWait(appiumDriver,10) ;

        MobileElement userNameField=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/email_et")));
        MobileElement passwordField=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/password_et")));
        MobileElement forgotPasswordButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/forgot_password_tv")));
        MobileElement gooogleButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/google_tv")));
        MobileElement facebookButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/fb_tv")));
        MobileElement signINButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/login_button_layout")));

        String disclmrTxt="By signing in to this app, you agree to the edX End User License Agreement and edX Terms of Service and Honor Code and you acknowledge that edX and each Member process your personal data in accordance with the Privacy Policy";
        String xp="//android.widget.TextView[@text='"+disclmrTxt+"']";
        MobileElement disclaimerText=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
        signINButton.click();

        xp=".//android.widget.TextView[contains(@text,'Please enter your user name or e-mail address and try again.')]";
        MobileElement signErrorMsg=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));

        xp="//android.widget.Button[contains(@text,'OK')]";
        MobileElement okButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
        okButton.click();

        ///user name verification
        userNameField.sendKeys("randomUserName");
        signINButton.click();
        xp=".//android.widget.TextView[contains(@text,'Please enter your password and try again.')]";
        MobileElement signErrorMsgOnlyUserName=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
        xp="//android.widget.Button[contains(@text,'OK')]";
        okButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
        okButton.click();
        userNameField.clear();

        ////Password field verification
        passwordField.sendKeys("randdomPassword");
        signINButton.click();
        xp=".//android.widget.TextView[contains(@text,'Please enter your user name or e-mail address and try again.')]";
        MobileElement signErrorMsgOnlyPassword=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
        xp="//android.widget.Button[contains(@text,'OK')]";
        okButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
        okButton.click();

        //both Password and user name
        userNameField.sendKeys("randomUserName");
        signINButton.click();
        xp=".//android.widget.TextView[contains(@text,'Please make sure that your user name or e-mail address and password are correct and try again.')]";
        MobileElement signErrorMsgBothUserNameAndPassword=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
        xp="//android.widget.Button[contains(@text,'OK')]";
        okButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
        okButton.click();
    }

    public static void loginThroughGoogleButton(){
    try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10);

            String xp = null;

            MobileElement gooogleButton = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/google_tv")));
            gooogleButton.click();
            xp = "//android.widget.CheckedTextView[contains(@text,'ryryyrirerire@gmail.com')]";
            MobileElement googleCorrectID = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
            googleCorrectID.click();
            xp = "//android.widget.Button[contains(@text,'OK')]";
            MobileElement okButton = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
            okButton.click();

            xp = "//android.widget.Button[contains(@text,'Done')]";
            MobileElement doneButton = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
            doneButton.click();

            xp = "//android.view.ViewGroup//android.widget.TextView[contains(@text,'Courses')]";
            MobileElement CourseHeader = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));

            xp = "//android.widget.LinearLayout//android.widget.TextView[contains(@text,'Courses')]";
            MobileElement courseTab = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));

            xp = "//android.widget.LinearLayout//android.widget.TextView[contains(@text,'Programs')]";
            MobileElement programTab = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));

            xp = "//android.widget.LinearLayout//android.widget.TextView[contains(@text,'Discovery')]";
            MobileElement discoveryTab = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));

            programTab.click();

            xp = "//android.view.ViewGroup//android.widget.TextView[contains(@text,'Programs')]";
            MobileElement programHeader = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));

            discoveryTab.click();
            xp = "//android.view.ViewGroup//android.widget.TextView[contains(@text,'Discovery')]";
            MobileElement discoveryHeader = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
            Thread.sleep(5000);
        }catch ( java.lang.InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void logOutFromApplication()  {
        try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10);

            String xp = null;
            MobileElement gearButton = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/menu_item_account")));
            gearButton.click();

            MobileElement logOutButton = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.edx.mobile:id/logout_btn")));
            logOutButton.click();

            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
