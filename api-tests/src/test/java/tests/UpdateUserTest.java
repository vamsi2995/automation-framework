package tests;

import builder.UpdateUserRequest;
import client.ProductClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class UpdateUserTest {

    @Test(dependsOnMethods = "tests.CreateUserTest.createUserTest")
    public void updateUserTest() {

        ProductClient client = new ProductClient();

        Map<String, String> body = UpdateUserRequest.build();

        Response response = client.updateUser(body);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getString("responseCode"), "200");
        Assert.assertTrue(json.getString("message").contains("User updated"));
    }
}