package lhs.gpa.calculator.backend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.vaadin.flow.component.Html;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class WebScraper {
    public static void main(String[] args) {
        String searchQuery = "iPhone 6s";

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = "https://newyork.craigslist.org/search/sss?sort=rel&query=" + URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
            HtmlPage page = client.getPage(searchUrl);

            List<HtmlElement> items = page.getByXPath("//li[@class='result-row']");
            if (items.isEmpty()) {
                System.out.println("No Items Found!");
            }
            else {
                for (HtmlElement item : items) {
                    HtmlAnchor itemAnchor = item.getFirstByXPath(".//p[@class='result-info']/a");
                    HtmlElement spanPrice = item.getFirstByXPath(".//a/span[@class='result-price']");

                    String itemName = itemAnchor.asText();
                    String itemUrl = itemAnchor.getHrefAttribute();

                    String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText();

                    System.out.println(String.format("Name: %s Url: %s Price: %s", itemName, itemUrl, itemPrice));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
