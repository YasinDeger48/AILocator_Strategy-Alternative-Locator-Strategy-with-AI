package qa.virgosol.test.AI;

import jdk.jfr.Name;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import qa.virgosol.test.AI.helper.ElementModel;
import qa.virgosol.test.AI.helper.ReadYAML;
import qa.virgosol.test.AI.model.YAMLModel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AILocators {




    WebDriver driver;
    List<String> locators = new ArrayList<>();
    Map<String, List<String>> anchorElements = new HashMap<>();

    ElementModel model = new ElementModel();

    List<WebElement> a;

    List<String> types = new ArrayList<>();


    String locatorType = ReadYAML.getElementType();


    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        if(ReadYAML.getHeadlessStatus()){
            options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
        driver.get(ReadYAML.getTestURL()); //ilk iki demo senaryo
        //driver.get("https://www.amazon.com/");
        //driver.get("https://virgosol.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Name("Sadece a tagine göre düzenlenmiştir")
    @Test
    public void mainTest(){
        a = driver.findElements(By.tagName(locatorType));
        System.out.println("a = " + a.size());
      //  System.out.println("a.get(1).getAttribute(\"class\") = " + a.get(1).getAttribute("class"));


        for (int i = 0; i < a.size(); i++) {
            model.setClassName(a.get(i).getAttribute("class"));
            model.setId(a.get(i).getAttribute("id"));
            model.setTextValue(a.get(i).getText());
            model.setName(a.get(i).getAttribute("name"));
            model.setStyle(a.get(i).getAttribute("style"));
            model.setTitle(a.get(i).getAttribute("title"));

            anchorElements.put(""+i+"",List.of(
                    model.getClassName(),
                    model.getId(),
                    model.getTextValue(),
                    model.getName(),
                    model.getStyle(),
                    model.getTitle()));
        }

/*        for (Map.Entry<String, List<String>> stringListEntry : anchorElements.entrySet()) {
            System.out.println("Class ve ID elementleri = " + stringListEntry.getKey() + " " + stringListEntry.getValue());
        }*/

        //String xpath = "//a[@class='btn btn-dark btn-lg toggle']";
        //String xpath = "//a[.='CURA Healthcare']";
        //String xpath = "//a[@id='to-top']";
        String xpath = "//a[@id='btn-make-appointment']"; //Deneme locatorumuz - 1
        //String xpath = "//a[@id='menu-toggle']"; //deneme locator - 2
        //String xpath = "//a[text()='Sell']"; //amazon
        //String xpath = "//li[@id='accordion-menu-item-2750']";

        showAlternativeLocators(anchorElements,xpath);
        System.out.println("locators = " + locators);
        System.out.println("Test is starting\n------------------------------------------");
        System.out.println("Senin girdiğin locator: "+xpath);
        denemeLocator1();

    }


    @Name("Deneme locator 1 senaryosu cura.healthcare")
    public void denemeLocator1(){
        System.out.println("Bu element için yakalanan locatorlar: " + locators.size() + "(Adet) = " + locators + "\n---------------------------------");
        for (int i = 0; i < locators.size(); i++) {
           // System.out.println("locators.get(i) = " + locators.get(i));
            List<WebElement> elements = driver.findElements(By.xpath(locators.get(i)));
            if(elements.size()>1){
                System.out.println(locators.get(i)+ "Elementinden birden fazla var");
            }else{
                System.out.println(locators.get(i) + " Elementi ile devam edildi");
                elements.get(0).click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                assertTrue(driver.findElement(By.xpath("//h2[.='Login']")).isDisplayed());
                driver.navigate().back();
            }

        }


    }

    @Name("Deneme locator 2 senaryosu cura.healthcare")
    public void denemeLocator2() {
        System.out.println("Bu element için yakalanan locatorlar: "+locators.size()+"(Adet) = " + locators+"\n---------------------------------");
        for (int i = 0; i < locators.size(); i++) {
          //  System.out.println("locators.get(i) = " + locators.get(i));
            List<WebElement> elements = driver.findElements(By.xpath(locators.get(i)));
            if (elements.size() > 1) {
                System.out.println(locators.get(i)+" Elementi birden fazla element içeriyor");
            } else {
                System.out.println(locators.get(i)+" Elementi ile devam edildi");
                elements.get(0).click();
                waitFor(3);
                assertTrue(driver.findElement(By.xpath("//a[.='Login']")).isDisplayed());
                driver.findElement(By.xpath("//a[.='Login']")).click();
                assertTrue(driver.findElement(By.xpath("//h2[.='Login']")).isDisplayed());
                driver.navigate().back();
            }

        }


    }

    @Name(("Deneme locator 3 senaryosu amazon.com"))
    public void denemeLocator3() {
        System.out.println("Bu element için yakalanan locatorlar: " + locators.size() + "(Adet) = " + locators + "\n---------------------------------");
        for (int i = 0; i < locators.size(); i++) {
            //  System.out.println("locators.get(i) = " + locators.get(i));
            List<WebElement> elements = driver.findElements(By.xpath(locators.get(i)));
            if (elements.size() > 1) {
                System.out.println(locators.get(i) + " Elementi birden fazla element içeriyor");
            } else {
                System.out.println(locators.get(i) + " Elementi ile devam edildi");
                elements.get(0).click();
                waitFor(3);
                assertTrue(driver.findElement(By.xpath("//h1[text()='Sell on Amazon']")).isDisplayed());
                waitFor(1);
                driver.navigate().back();
            }

        }
    }

    @Name(("Deneme locator 4  li senaryosu virgosol.com"))
    public void denemeLocator4() {
        System.out.println("Bu element için yakalanan locatorlar: " + locators.size() + "(Adet) = " + locators + "\n---------------------------------");
        for (int i = 0; i < locators.size(); i++) {
            //  System.out.println("locators.get(i) = " + locators.get(i));
            List<WebElement> elements = driver.findElements(By.xpath(locators.get(i)));
            if (elements.size() > 1) {
                System.out.println(locators.get(i) + " Elementi birden fazla element içeriyor");
            } else {
                System.out.println(locators.get(i) + " Elementi ile devam edildi");
                elements.get(0).click();
                waitFor(3);
                assertTrue(driver.findElement(By.xpath("//h1[@class='page-title']")).isDisplayed());
                waitFor(1);
                driver.navigate().back();
            }

        }
    }

    @Name("Elementin attribute tipini alıyorum class id")
    public String findTypeOfLocator(String xpath){
        WebElement sampleLocator = driver.findElement(By.xpath(xpath));
    //    System.out.println("xpath.indexOf(\"a\") = " + xpath.indexOf("@"));
    //    System.out.println("xpath.indexOf(\"=\") = " + xpath.indexOf("="));
        //System.out.println("xpath.substring(xpath.indexOf(\"@\")+1,xpath.indexOf(\"=\")) = " + xpath.substring(xpath.indexOf("@") + 1, xpath.indexOf("=")));
        return (xpath.substring(xpath.indexOf("@") + 1, xpath.indexOf("=")));

    }
    @Name("Elementin attribute değerini alıyorum class, id")
    public String findValueOfLocator(String xpath){
        WebElement sampleLocator = driver.findElement(By.xpath(xpath));
    //    System.out.println("xpath.indexOf(\"a\") = " + xpath.indexOf("'"));
    //    System.out.println("xpath.indexOf(\"=\") = " + xpath.lastIndexOf("'"));
        //System.out.println("xpath.substring(xpath.indexOf(\"@\")+1,xpath.indexOf(\"=\")) = " + xpath.substring(xpath.indexOf("'") + 1, xpath.lastIndexOf("'")));
        return (xpath.substring(xpath.indexOf("'") + 1, xpath.lastIndexOf("'")));
    }

    @Name("Elementlerin alternatif locatorlarını göstereceğim")
    public void showAlternativeLocators(Map<String, List<String>> anchorElements, String xpath){
        String index= "" ;
        //String typeOfLocator = findTypeOfLocator(xpath);
        String valueOfLocator = findValueOfLocator(xpath);
        for (Map.Entry<String, List<String>> eachElement : anchorElements.entrySet()) {
            index = eachElement.getKey();
            if(eachElement.getValue().contains(valueOfLocator)){
                break;
            }
        }

 //       System.out.println("index = " + index);
  //      System.out.println("anchorElements.get(\"\"+index+\"\") = " + anchorElements.get("" + index + ""));
        List<String> AllAttrbtValues = anchorElements.get("" + index + "");
/*        System.out.println("Alternatif Elements");
        System.out.println("\"-------------------\" = " + "-------------------");
        System.out.println("Your locator: "+xpath);
        System.out.println("Class locator: "+ "//a[@"+"class"+"('"+AllAttrbtValues.get(0)+"')]");
        System.out.println("Id locator: "+ "//a[@"+"id"+"('"+AllAttrbtValues.get(1)+"')]");
        System.out.println("Text Locator: = " + "Text Locator: "+ "//a[.='"+AllAttrbtValues.get(2)+"']");
        System.out.println("Name locator: "+ "//a[@"+"name"+"('"+AllAttrbtValues.get(3)+"')]");*/

        locators = new ArrayList<>();
        for (int i = 0; i < AllAttrbtValues.size(); i++) {
            if(!AllAttrbtValues.get(i).equals("")){
                switch (i){
                    case 0:
                        locators.add(setClassName(AllAttrbtValues.get(i)));
                        break;
                    case 1:
                        locators.add(setId(AllAttrbtValues.get(i)));
                        break;
                    case 2:
                        locators.add(setTextValue(AllAttrbtValues.get(i)));
                        break;
                    case 3:
                        locators.add(setName(AllAttrbtValues.get(i)));
                        break;
                    case 4:
                        locators.add(setStyle(AllAttrbtValues.get(i)));
                        break;
                    case 5:
                        locators.add(setTitle(AllAttrbtValues.get(i)));
                        break;

                }
            }
        }


    }

    private String setClassName(String className){
        return "//"+locatorType+"[@"+"class="+"('"+className+"')]";
    }

    private String setId(String Id){
        return "//"+locatorType+"[@"+"id="+"('"+Id+"')]";
    }

    private String setTextValue(String textValue){
        return "//"+locatorType+"[.='"+textValue+"']";
    }

    private String setName(String name){
        return "//"+locatorType+"[@"+"name="+"('"+name+"')]";
    }

    private String setStyle(String style){
        return "//"+locatorType+"[@"+"style="+"('"+style+"')]";
    }

    private String setTitle(String title){
        return "//"+locatorType+"[@"+"title="+"('"+title+"')]";
    }

    public void waitFor(long sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @After
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
