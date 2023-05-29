
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

import com.beust.jcommander.Parameter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

public class MegaTests {

    public static final ChromeDriver driver = new ChromeDriver();
    static String url = "https://skillfactory.ru/";

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aleks\\IdeaProjects\\untitled5\\src\\test\\resources\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



    @Test
    public void form() {
        driver.get(url);

        WebElement inputName = driver.findElement(By.xpath("//input[@aria-label='name']"));
        inputName.sendKeys("Алёша");

        WebElement inputMail = driver.findElement(By.xpath("//input[@aria-label='email']"));
        inputMail.sendKeys("12@1.ru");

        WebElement inputPhone = driver.findElement(By.xpath("//input[@type='tel']"));
        inputPhone.sendKeys("9999999998");

        WebElement otpravit = driver.findElement(By.xpath("//button[@type='submit']"));
        otpravit.click();

        WebElement spasibo = driver.findElement(By.xpath("//div[@id='tildaformsuccesspopuptext']"));
        spasibo.click();
    };

    @Test
    public void form2() {
        driver.get(url);
        WebElement inputName = driver.findElement(By.xpath("(//input[@aria-label='name'])[2]"));
        inputName.sendKeys("12");

        WebElement inputMail = driver.findElement(By.xpath("(//input[@aria-label='email'])[2]"));
        inputMail.sendKeys("12");

        WebElement inputPhone = driver.findElement(By.xpath("(//input[@type='tel'])[2]"));
        inputPhone.sendKeys("9999");

        WebElement otpravit = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        otpravit.click();

        WebElement error = driver.findElement(By.id("tilda-popup-for-error"));


    };

    @Test
    public void formErorr() {
        driver.get(url);
        WebElement inputName = driver.findElement(By.xpath("//input[@aria-label='name']"));
        inputName.sendKeys("12");
        WebElement inputMail = driver.findElement(By.xpath("//input[@aria-label='email']"));
        inputMail.sendKeys("12");
        WebElement inputPhone = driver.findElement(By.xpath("//input[@type='tel']"));
        inputPhone.sendKeys("9999");
        WebElement otpravit = driver.findElement(By.xpath("//button[@type='submit']"));
        otpravit.click();
        WebElement podskazkaName = driver.findElement(By.xpath("//div[text()='Укажите, пожалуйста, имя']"));
        WebElement podskazkaEmail = driver.findElement(By.xpath("//div[text()='Укажите, пожалуйста, корректный email']"));
        WebElement podskazkaTel = driver.findElement(By.xpath("//div[text()='Слишком короткое значение']"));

    };





    @Test
    public void testirovanie() {
        driver.get(url);
        String windows1 = driver.getWindowHandle();
        WebElement progr = driver.findElement(By.xpath("//*[@id=\"rec566444333\"]/div/div/div[87]/a"));
        progr.click();
        Set<String> currentWindows = driver.getWindowHandles();
        String windows2 = null;
        for (String window : currentWindows) {
            if (!window.equals(windows1)) {
                windows2 = window;
                break;
            }
        };

        driver.switchTo().window(windows2);

        WebElement inputName = driver.findElement(By.xpath("//input[@aria-label='name']"));
        inputName.sendKeys("Анатолий");

        WebElement inputMail = driver.findElement(By.xpath("//input[@aria-label='email']"));
        inputMail.sendKeys("12@1.ru");

        WebElement inputPhone = driver.findElement(By.xpath("//input[@type='tel']"));
        inputPhone.sendKeys("9999999998");

        WebElement otpravit = driver.findElement(By.xpath("//button[@type='submit']"));
        otpravit.click();

        WebElement spasibo = driver.findElement(By.xpath("//span[text()='Спасибо, мы получили вашу заявку! ']"));
         String ad = spasibo.getText();
        System.out.println(ad);

    };


    @Test
    public void bot() throws InterruptedException {

        driver.get(url);
        WebElement envelope = driver.findElement(By.xpath("//div[@id='chat-container']"));
        envelope.click();
        Thread.sleep(2000);
        WebElement input3 = driver.findElement(By.id("carrot-messenger-frame"));


    };

    @Test
    public void youtube() {
        driver.get(url);
        String windows1 = driver.getWindowHandle();
        WebElement clickLink = driver.findElement(By.xpath("//*[@id='rec596444548']/div/div/div[6]/a"));
        clickLink.click();
        Set<String> currentWindows = driver.getWindowHandles();
        String windows2 = null;
        for (String window : currentWindows) {
            if (!window.equals(windows1)) {
                windows2 = window;
                break;
            }
        };

        driver.switchTo().window(windows2);
        WebElement channelName = driver.findElement(By.xpath("//*[@id='text']"));
        String name = channelName.getText();
        Assert.assertEquals("Skillfactory", name);
    };


    @Test
    public void allKurs() {
        driver.get("https://skillfactory.ru/courses");
        List<WebElement> ellements = driver.findElements(By.xpath(" //*[text()=' ₽/мес']"));
        System.out.println(ellements.size());

    };

    @Test
    public void onlineKursi() throws InterruptedException {
        driver.get(url);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='онлайн-курсы']"))).build().perform();
        WebElement vseOnlineKursi = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Все онлайн-курсы']"))));
        WebElement testirovanie = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Тестирование']"))));
        WebElement analitika = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Аналитика данных']"))));
        WebElement profgramirovanie = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Программирование']"))));
        WebElement intensivnie = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Интенсивные курсы']"))));
        WebElement webRazrab = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Веб-разработка']"))));
        WebElement bezopasnost = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Безопасность']"))));
        WebElement marketing = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Маркетинг']"))));
        WebElement dizain = (new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Дизайн']"))));

    };

    @Test
    public void form3() throws InterruptedException {
        driver.get(url);
        WebElement inputName = driver.findElement(By.xpath("(//input[@placeholder='Почта'])[3]"));
        inputName.sendKeys("2@2.ru");

        WebElement otpravit = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
        otpravit.click();

        Thread.sleep(2000);

        WebElement spasibo = driver.findElement(By.xpath("(//div[text()='Спасибо! Данные успешно отправлены.'])[2]"));

    };

    @Test
    public void kontakti() {
        driver.get(url);

        String windows1 = driver.getWindowHandle();
        WebElement contacts = driver.findElement(By.xpath("(//a[@href='https://skillfactory.ru/contacts'])[3]"));
        contacts.click();

        Set<String> currentWindows = driver.getWindowHandles();
        String windows2 = null;
        for (String window : currentWindows) {
            if (!window.equals(windows1)) {
                windows2 = window;
                break;
            }
        };

        driver.switchTo().window(windows2);

        WebElement contInf = driver.findElement(By.xpath("//h1[text()='Контактная информация']"));
        String text = contInf.getText();
        Assert.assertEquals("Контактная информация", text);


    };



};