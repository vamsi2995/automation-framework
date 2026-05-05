package stepdefinitions;

import builder.CreateUserRequest;
import client.ProductClient;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import utils.ConfigReader;
import utils.TestContext;

import java.util.Map;

public class ApiSteps {

    @Given("User creates account using API")
    public void create_user_using_api() {

        ProductClient client = new ProductClient();

        // Generate dynamic email
        String email = "test" + System.currentTimeMillis() + "@mail.com";

        // Store in TestContext for UI usage
        TestContext.setEmail(email);
        TestContext.setPassword(ConfigReader.get("password"));

        // Build request
        Map<String, String> body = CreateUserRequest.build(email);

        // Call API
        Response response = client.createUser(body);

        System.out.println("API Response:");
        System.out.println(response.asPrettyString());
    }
}