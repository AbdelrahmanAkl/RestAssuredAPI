package swagger.UI.Swagger.API.Tests;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class TestPostRequest {
	
	ValidatableResponse validatableResponse;
	@Test
	void AuthorsPostMethodTestvalidStatusCode200() {
		HashMap<String, String> postContent = new HashMap<String, String>();
		postContent.put("id","0");
		postContent.put("idBook","0");
		postContent.put("firstName","string");
		postContent.put("lastName","string");
        validatableResponse = given()
                .baseUri("https://fakerestapi.azurewebsites.net")
                .contentType(ContentType.JSON)
                .body(postContent)
                .when()
                     .post("/api/v1/Authors")
                .then()
                      .assertThat().statusCode(200);
        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
	}
	@Test
void AuthorsPostMethodTestvalidStatusCode20() {
		HashMap<String, String> postContent = new HashMap<String, String>();
		postContent.put("id","0");
		postContent.put("idBook","0");
		postContent.put("firstName","string");
		postContent.put("lastName","string");
    // GIVEN
    validatableResponse = given()
            .baseUri("http://dummy.restapiexample.com/api")
            .contentType(ContentType.JSON)
            .body(postContent)
            .when()
                 .post("/v1/create")
            .then()
                  .assertThat().statusCode(404);
    System.out.println("Response :" + validatableResponse.extract().asPrettyString());
	}

}
