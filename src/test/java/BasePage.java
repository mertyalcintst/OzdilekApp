import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage extends BaseTest {

    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        logger.info(id + "elementine tıklandı");
    }

    @Step("<wait> saniye kadar bekle")
    public void waitForseconds(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    /*@Step("<id> li uygulamanın açıldığını kontrol et")
    public void checkOpen(String id) {
        String checkText = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA", checkText);
    }*/
    @Step({"id <id> li elementi bul ve <text> alanını kontrol et"})
    public void textIdAreacontrol(String id, String text) {
        Assert.assertTrue("Element text değerini içermiyor", ((MobileElement)appiumDriver.findElement(By.id(id))).getText().contains(text));
        this.logger.info("uygulama kontrolu  -> " + text + " yapildi  ve dogrulandi.");
    }

    @Step("Alişverişe basla butonuna tıkla")
    public void ClickButton() throws InterruptedException {
        Thread.sleep(2000);
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")).click();
    }

    @Step({"xpath <xpath> li elementi bul ve <text> alanını kontrol et"})
    public void textXpathAreacontrol(String xpath, String text) {
        Assert.assertTrue("Element text değerini içermiyor", (appiumDriver.findElement(By.xpath(xpath))).getText().contains(text));
        this.logger.info("Element bulundu -> " + text + " kontrol dogrulandi.");
    }

    @Step({"xpath <xpath> li elemente tıkla"})
    public void clickByXpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        this.logger.info("Elemana tiklandi.");
    }

    @Step("Pantolona kay")
    public void scroll1() {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.7);
        int start_y = (int) (dimension.height * 0.7);
        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.5);
        TouchAction touch = new TouchAction(appiumDriver);
        touch.press(point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(point(end_x, end_y)).release().perform();
    }

    @Step(" 1.Scrolldown yapılır")
    public void scrollDown1() {
        int startXone = 535;
        int startYone = 1498;
        int endXone = 548;
        int endYone = 359;
        TouchAction action = new TouchAction(appiumDriver);
        action.press(point(startXone, startYone))
                .moveTo(point(endXone,endYone))
                .release()
                .perform();}
    @Step("2.Scrolldown yapılır")
    public void scrollDown2() {
        int startXone = 548;
        int startYone = 1510;
        int endXone = 538;
        int endYone = 514;
        TouchAction action = new TouchAction(appiumDriver);
        action.press(point(startXone, startYone))
                .moveTo(point(endXone,endYone))
                .release()
                .perform();
    }
    @Step("id <id> li ementi bul ve <text> değerini yaz")
    public void sendkeysByid(String id, String text) {
        (appiumDriver.findElement(By.id(id))).sendKeys("text");
        this.logger.info("Ement bulundu  ve -> " + text + " değeri yazildi.");
    }

    @Step("Elementleri <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomXpath(String xpath) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        (products.get(index)).click();
        this.logger.info("Elementler arasindsan rastgele biri secildi tiklandi.");
    }

}