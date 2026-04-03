package tests;

import builder.CreateUserRequest;
import client.ProductClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class CreateUserTest {

    @Test(priority = 1)
    public void createUserTest() {

        ProductClient client = new ProductClient();

        Map<String, String> body = CreateUserRequest.build();

        Response response = client.createUser(body);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getString("responseCode"), "201");
        Assert.assertTrue(json.getString("message").contains("User created"));
    }
}