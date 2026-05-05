package tests;

import client.ProductClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import validator.ProductValidator;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProductTests {

    @Test
    public void getAllProductsTest() {

        ProductClient client = new ProductClient();

        Response response = client.getAllProducts();

        System.out.println(response.asPrettyString());

        // schema validation
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema/products-schema.json"));

        // strong validation
        ProductValidator.validateAllProducts(response);
    }
}