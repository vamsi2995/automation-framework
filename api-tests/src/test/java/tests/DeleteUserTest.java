package tests;

import client.ProductClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestContext;

public class DeleteUserTest {

    @Test(dependsOnMethods = "tests.UpdateUserTest.updateUserTest")
    public void deleteUserTest() {

        ProductClient client = new ProductClient();

        String email = TestContext.getEmail();
        String password = TestContext.getPassword();

        Response response = client.deleteUser(email, password);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getString("responseCode"), "200");
        Assert.assertTrue(json.getString("message").contains("Account deleted"));
    }
}