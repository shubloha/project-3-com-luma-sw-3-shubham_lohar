package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {                   //Open browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        //Mouse Hover on Men Menu
        mouseHoverOnly(By.id("ui-id-5"));
        //Mouse Hover on Bottoms
        mouseHoverOnly(By.id("ui-id-18"));
        //Click on Pants
        clickOnElement(By.id("ui-id-23"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32
        mouseHoverOnly(By.xpath("//a[normalize-space()='Cronus Yoga Pant']/parent::strong/parent::div"));
        clickOnElement(By.id("option-label-size-143-item-175"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverOnly(By.xpath("//a[normalize-space()='Cronus Yoga Pant']/parent::strong/parent::div"));
        clickOnElement(By.id("option-label-color-93-item-49"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverOnly(By.xpath("//a[normalize-space()='Cronus Yoga Pant']/parent::strong/parent::div"));
        clickOnElement(By.xpath("//span[text()='Add to Cart']"));
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        Assert.assertEquals("You added Cronus Yoga Pant to your shopping cart.",getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.linkText("shopping cart"));
        //Verify the text ‘Shopping Cart.’
        Assert.assertEquals("Shopping Cart",getTextFromElement(By.xpath("//span[@class='base']")));
        //Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals("Cronus Yoga Pant",getTextFromElement(By.partialLinkText("Cronus Yoga")));
        //Verify the product size ‘32’
        Assert.assertEquals("32",getTextFromElement(By.xpath("//dd[contains(text(),'32')]")));
        //Verify the product colour ‘Black’
        Assert.assertEquals("Black",getTextFromElement(By.xpath("//dd[contains(text(),'Black')]")));
    }

    @After
    public void tearDown() {                //Close browser
        closeBrowser();
    }
}
