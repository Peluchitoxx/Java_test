package pages;
   
  import java.time.Duration;
  import java.util.List;
  import java.util.ArrayList;
   
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.support.ui.ExpectedConditions;
  import org.openqa.selenium.support.ui.Select;
  import org.openqa.selenium.support.ui.WebDriverWait;
   
  import io.github.bonigarcia.wdm.WebDriverManager;
   
  public class BasePage {
      
      protected static WebDriver driver;
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
   
      static {
          WebDriverManager.chromedriver().setup();
   
          // Inicializa la variable estática 'driver' con una instancia de ChromeDriver
          driver = new ChromeDriver();
      }
   
      
      public BasePage(WebDriver driver) {
          BasePage.driver = driver;
      }
   
      // Método estático para navegar a una URL.
      public static void navigateTo(String url) {
          driver.get(url);
      }
   
      //Método estático para cerrar la instancia del driver.
      public static void closeBrowser() {
          driver.quit();
      }
   
      // Encuentra y devuelve un WebElement en la página utilizando un locator XPath esperando que se presente en el dom
      private WebElement Find(String locator) {
          return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
      }
   
      public void clickElement(String locator) {
          Find(locator).click();
      }
   
      public void write(String locator, String keysToSend){
          Find(locator).clear();
          Find(locator).sendKeys(keysToSend);
      }

      // ELEGIR POR VALOR
      public void selectFromDropdownByValue(String locator, String value){
          Select dropdown = new Select(Find(locator));
   
          dropdown.selectByValue(value);
      }
      
      // ELEGIR POR INDICE
      public void selectFromDropdownByIndex(String locator, Integer index){
          Select dropdown = new Select(Find(locator));
   
          dropdown.selectByIndex(index);
      }
   
      // ELEGIR POR TAMAÑO
      public int dropdownSize(String locator){
          Select dropdown = new Select(Find(locator));
   
          List<WebElement> dropdownOptions = dropdown.getOptions();
   
          return dropdownOptions.size();
      }

      public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator));
 
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
        return values;
      }
   
  }