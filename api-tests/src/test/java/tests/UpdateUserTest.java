package tests;

import builder.UpdateUserRequest;
import client.ProductClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import validator.UserValidator;
import utils.TestContext;
import java.util.Map;

public class UpdateUserTest {

    @Test(dependsOnMethods = "tests.CreateUserTest.createUserTest")
    public void updateUserTest() {

        ProductClient client = new ProductClient();

        Map<String, String> body = UpdateUserRequest.build(
                TestContext.getEmail(),
                TestContext.getPassword());

        Response response = client.updateUser(body);

        System.out.println(response.asPrettyString());

        UserValidator.validateUpdateUser(response);
    }
}