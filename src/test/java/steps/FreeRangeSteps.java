package steps;
 
import java.util.List;
import java.util.Arrays;

import org.testng.Assert;
//import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;
 
public class FreeRangeSteps {
 
    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();
 
    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }
 
    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationbar(section);
    }

    @When("I select Elegir Plan")
    public void selectElegirPlan(){
        landingPage.clickOnElegirPlanButton();
    }
    
    @And("select introduccion al Testing")
        public void navigateToIntro(){
            cursosPage.clickFundamentosTestingLink();
            fundamentosPage.clickIntroduccionTestingLink();
        }

    @Then("I can validate the options in the checkout page")
        public void validateCheckoutPlans() {
            List<String> lista = registro.returnPlanDropdownValues();
            List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 12 productos",
                    "Academia: $176 / año • 12 productos", "Free: Gratis • 3 productos");
     
            Assert.assertNotEquals(listaEsperada, lista);
        }

    }
    