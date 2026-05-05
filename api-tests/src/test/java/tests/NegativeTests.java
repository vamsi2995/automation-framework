package tests;

import builder.CreateUserRequest;
import client.ProductClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeTests {
    @Test
    public void createUserWithExistingEmail() {

        ProductClient client = new ProductClient();

        // First create user
        String email = "test" + System.currentTimeMillis() + "@mail.com";
        Map<String, String> body = CreateUserRequest.build(email);
        client.createUser(body);

        // Try creating again with same email
        Response response = client.createUser(body);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getString("responseCode"), "400");
        Assert.assertTrue(json.getString("message").contains("exists"));
    }

    @Test
    public void loginWithWrongPassword() {

        ProductClient client = new ProductClient();

        String email = "random@test.com"; // any email
        String wrongPassword = "wrong123";

        Response response = client.loginUser(email, wrongPassword);

        System.out.println(response.asPrettyString());

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getString("responseCode"), "404");
    }

    @Test
    public void deleteUserWrongPassword() {

        ProductClient client = new ProductClient();

        String email = "random@test.com"; // any email
        String wrongPassword = "wrong123";

        Response response = client.deleteUser(email, wrongPassword);

        System.out.println(response.asPrettyString());

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getString("responseCode"), "404");
    }

}