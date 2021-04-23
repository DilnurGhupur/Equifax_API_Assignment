package API_testing;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE_request {
    @Test
    public void deleteTest() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/delete/123";
        Response response =
                given()
                        .when()
                        .delete()
                        .then()
                        .statusCode(200)
                        .statusLine("HTTP/1.1 200 OK")
                        .log().all()
                        .extract().response();

        String jsonAsString = response.asString();
        Assert.assertEquals(jsonAsString.contains("Successfully! Record has been deleted"), true);
    }
}

