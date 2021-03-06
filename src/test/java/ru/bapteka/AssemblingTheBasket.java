package ru.bapteka;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AssemblingTheBasket {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\JetBrains\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testBasket() throws Exception {
        driver.get("https://b-apteka.ru/");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver.get("https://b-apteka.ru/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='anchor-header']/div/div/div[2]/div/div[3]/a[2]/p")).click();
        driver.findElement(By.xpath("//div[@id='anchor-header']/div/div/div[2]/div/div[2]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='anchor-header']/div/div/div[2]/div/div[2]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='anchor-header']/div/div/div[2]/div/div[2]/div/div/div/input")).sendKeys("анальгин");
        driver.findElement(By.xpath("//div[@id='anchor-header']/div/div/div[2]/div/div[2]/div/div/div/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//img[@alt='Анальгин']")).click();
        driver.findElement(By.xpath("//button[@onclick=\"(function(){ var buttonBuy = document.querySelector('.j-product-counter-button'); if (buttonBuy) { buttonBuy.dispatchEvent(new CustomEvent('j-button-buy-button-init')); } else { console.error('Кнопка не загрузилась') } })()\"]")).click();
        driver.findElement(By.xpath("//div[@id='anchor-header']/div/div/div[2]/div/div[3]/div/a/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Пополнить аптечку'])[1]/preceding::button[1]")).click();
        driver.findElement(By.linkText("Оформить заказ")).click();
        driver.findElement(By.linkText("Выбрать")).click();
        driver.findElement(By.xpath("//div[@id='pharm-select']/div/div/div[2]/div/div/div/div[2]/div/label[2]/div/h3")).click();
        driver.findElement(By.xpath("//div[@id='pharm-current']/div/div[2]/div[3]/div/div[2]/button")).click();
        driver.findElement(By.linkText("Вернуться в корзину")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Достигнуто максимальное количество доступного товара'])[1]/following::a[1]")).click();
        driver.findElement(By.xpath("//div[@id='modal-confirm-remove']/div/div[2]/div[3]/button")).click();
        driver.findElement(By.xpath("//div[@id='anchor-header']/div/div/div[2]/div/div/a[2]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
