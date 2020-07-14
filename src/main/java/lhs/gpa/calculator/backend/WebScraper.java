package lhs.gpa.calculator.backend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.List;

public class WebScraper {
    public static void main(String[] args) {
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setUseInsecureSSL(true);
            //Gets the Login Page
            final HtmlPage loginPage = webClient.getPage("https://students.livingston.org/livingston/sis/view?gohome=true");

            //find the form that needs to be filled
            final HtmlForm loginForm = loginPage.getFormByName("logon");

            final HtmlSubmitInput button = loginForm.getFirstByXPath("//input[@class='saveButton']");
            final HtmlEmailInput userName = loginForm.getInputByName("j_username");
            final HtmlPasswordInput password = loginForm.getInputByName("j_password");

            userName.type("shourya.bansal@lps-students.org");
            password.type("Dished43");

            final HtmlPage genesis = button.click();
            for (int i = 0; i < 10; i++) {
                System.out.println("Finally: " + genesis.getTitleText());
            }

            HtmlTable generalGradeTable = (HtmlTable) genesis.getByXPath("/html/body//table[@role='main']").get(0);
            assert generalGradeTable.getRowCount() == 2;

            HtmlTable gradeTable = (HtmlTable) generalGradeTable.getRows().get(2).getByXPath("/table[@class='list']");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
