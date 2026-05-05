package tests;

import client.ProductClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.TestContext;
import validator.UserValidator;

public class DeleteUserTest {

    @Test(dependsOnMethods = "tests.UpdateUserTest.updateUserTest")
    public void deleteUserTest() {

        ProductClient client = new ProductClient();

        String email = TestContext.getEmail();
        String password = TestContext.getPassword();

        Response response = client.deleteUser(email, password);

        System.out.println(response.asPrettyString());

        UserValidator.validateDeleteUser(response);
    }
}