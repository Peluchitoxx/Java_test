package pages;

public class PaginaPrincipal extends BasePage {

    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String elegirUnPlanButton = "//a[normalize-space()='Elegir Plan']";

    public PaginaPrincipal() {
        super(driver);
    }

    // metodo de navegacion 
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com");
    }

    public void clickOnSectionNavigationbar(String section) {
        // reemplazar el marcador de posicion en sectionLink
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnElegirPlanButton(){
        clickElement(elegirUnPlanButton);
    }

}
