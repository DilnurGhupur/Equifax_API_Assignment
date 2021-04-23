package API_testing;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class GET_request {

    @Test
    public void getTest() {
        Response response =
                given()
                        .when()
                        .get("http://dummy.restapiexample.com/api/v1/employee/3")
                        .then()
                        .statusCode(200)
                        .statusLine("HTTP/1.1 200 OK")
//	   .assertThat().body("employee_name", equalTo("Ashton Cox"))
//     .body("employee_salary", equalTo("86000"))
                        .header("Connection", "keep-alive")
                        .header("Content-Type", "application/json")
                        .log().all()
                        .extract().response();

        String jsonToString = response.asString();
        Assert.assertEquals(jsonToString.contains("Ashton Cox"), true);
        Assert.assertEquals(jsonToString.contains("86000"), true);
        Assert.assertEquals(jsonToString.contains("Successfully! Record has been fetched."), true);

    }
}

