package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    /**
     * this method will click on element
     */
    //Clicking on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //Store multiple elements
    public List<WebElement> getMultipleElements(By by) {
        return driver.findElements(by);
    }

    //Get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //Send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    //************************* Alert Methods *****************************************************
    //Total 5 alert method
    //1.switchTOAlert
    public void switchTOAlert() {
        Alert alert = driver.switchTo().alert();            //Creating alert object reference and switch to alert

    }

    //2.acceptAlert
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();//Creating alert object reference and switch to alert
        alert.accept();
    }

    //3.dismissAlert
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();//Creating alert object reference and switch to alert
        alert.dismiss();
    }

    //4.sendTextToAlert
    public void sendTextToAlert(String value) {
        Alert alert = driver.switchTo().alert();//Creating alert object reference and switch to alert
        alert.sendKeys(value);
        alert.accept();

    }

    //5.getTextFromAlert
    public String getTextFromAlert(String value) {
        Alert alert = driver.switchTo().alert();//Creating alert object reference and switch to alert
        return alert.getText();
    }

    //*************************** Select Class Methods ***************************************//
    //1.SelectByValueFromDropDown(By by,String value)
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    //2.selectByIndexFromDropDown(By by,int index)
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    //3.selectByVisibleTextFromDropDown(By by,String text)
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //*****************************Action method***********************************************//
    //mouse hover and click
    public void mouseHoverOnElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    //mouse hover only
    public void mouseHoverOnly(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    //*****************************Select Day date and month***********************************************//
    public void selectDayMonthAndYear(By by, String year, String month, String date, By byMonthYear, By byNextYear, By byDate) {
        clickOnElement(by); // Open the calendar
        while (true) {
            String monthAndYear = getTextFromElement(byMonthYear);
            System.out.println(monthAndYear);
            String[] a = monthAndYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equals(month) && yer.equals(year)) {
                break;
            } else {
                clickOnElement(byNextYear);
            }
        }
        // Select the Date
        List<WebElement> allDates = driver.findElements(byDate);
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }
    }
}
