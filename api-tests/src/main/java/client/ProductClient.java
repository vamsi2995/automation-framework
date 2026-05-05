package client;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ProductClient extends BaseClient {

    private static final Logger logger = LogManager.getLogger(ProductClient.class);

    public Response getAllProducts() {

        logger.info("Calling GET /api/productsList");

        Response response = request()
                .when()
                .get("/api/productsList")
                .then()
                .extract()
                .response();

        logger.info("Response: " + response.asString());

        return response;
    }

    public Response searchProduct(Map<String, String> body) {

        logger.info("Calling POST /api/searchProduct with body: " + body);

        Response response = request()
                .formParams(body)
                .when()
                .post("/api/searchProduct")
                .then()
                .extract()
                .response();

        logger.info("Response: " + response.asString());

        return response;
    }

    public Response createUser(Map<String, String> body) {

        logger.info("Calling POST /api/createAccount with body: " + body);

        Response response = request()
                .formParams(body)
                .when()
                .post("/api/createAccount")
                .then()
                .extract()
                .response();

        logger.info("Response: " + response.asString());

        return response;
    }

    public Response deleteUser(String email, String password) {

        logger.info("Calling DELETE /api/deleteAccount for email: " + email);

        Response response = request()
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete("/api/deleteAccount")
                .then()
                .extract()
                .response();

        logger.info("Response: " + response.asString());

        return response;
    }

    public Response updateUser(Map<String, String> body) {

        logger.info("Calling PUT /api/updateAccount with body: " + body);

        Response response = request()
                .formParams(body)
                .when()
                .put("/api/updateAccount")
                .then()
                .extract()
                .response();

        logger.info("Response: " + response.asString());

        return response;
    }

    public Response loginUser(String email, String password) {

        logger.info("Calling POST /api/verifyLogin for email: " + email);

        Response response = request()
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract()
                .response();

        logger.info("Response: " + response.asString());

        return response;
    }
}