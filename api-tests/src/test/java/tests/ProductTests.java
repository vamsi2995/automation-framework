package tests;

import client.ProductClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProductTests {

    @Test
    public void getAllProductsTest() {

        ProductClient client = new ProductClient();

        Response response = client.getAllProducts();

        System.out.println(response.asPrettyString());

        // status validation
        Assert.assertEquals(response.getStatusCode(), 200);

        // schema validation
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema/products-schema.json"));

        // strong validation
        JsonPath json = response.jsonPath();
        Assert.assertTrue(json.getList("products").size() > 0);
    }
}