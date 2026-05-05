package tests;

import builder.SearchProductRequest;
import client.ProductClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import validator.ProductValidator;

import java.util.Map;

public class SearchProductTest {

    @Test
    public void searchProductTest() {

        ProductClient client = new ProductClient();

        Map<String, String> body = SearchProductRequest.build("top");

        Response response = client.searchProduct(body);

        System.out.println(response.asPrettyString());

        ProductValidator.validateSearchProduct(response);
    }
}