package validator;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.testng.Assert.*;

public class UserValidator {

    public static void validateCreateUser(Response response) {

        assertEquals(response.getStatusCode(), 200);

        JsonPath json = new JsonPath(response.asString());

        assertEquals(json.getInt("responseCode"), 201);
        assertTrue(json.getString("message").contains("User created"));
    }

    public static void validateDeleteUser(Response response) {

        assertEquals(response.getStatusCode(), 200);

        JsonPath json = new JsonPath(response.asString());

        assertEquals(json.getInt("responseCode"), 200);
        assertTrue(json.getString("message").contains("Account deleted!"));
    }

    public static void validateUpdateUser(Response response) {

        assertEquals(response.getStatusCode(), 200);

        JsonPath json = new JsonPath(response.asString());

        assertEquals(json.getInt("responseCode"), 200);
        assertTrue(json.getString("message").contains("User updated!"));
    }
}