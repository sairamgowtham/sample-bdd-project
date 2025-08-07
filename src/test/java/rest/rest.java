package rest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class rest {
    @Test
    public void testGetUsersWithLogsAndAssert() {
        given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .queryParam("page", 2)
                .log().all() // ✅ Logs request details
                .when()
                .get()
                .then()
                .log().all() // ✅ Logs response details
                .assertThat() // ✅ Optional, used to chain assertions
                .statusCode(200)
                .body("data[0].first_name", equalTo("Michael"));
    }

}
