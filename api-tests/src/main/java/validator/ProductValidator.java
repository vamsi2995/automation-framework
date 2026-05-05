package validator;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.testng.Assert.*;

public class ProductValidator {

    public static void validateAllProducts(Response response) {

        assertEquals(response.getStatusCode(), 200);

        JsonPath json = new JsonPath(response.asString());

        assertNotNull(json.getList("products"));
        assertTrue(json.getList("products").size() > 0);
    }

    public static void validateSearchProduct(Response response) {

        assertEquals(response.getStatusCode(), 200);

        JsonPath json = new JsonPath(response.asString());

        assertNotNull(json.getList("products"));
        assertTrue(json.getList("products").size() > 0);
    }
}