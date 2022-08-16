package swagger.UI.Swagger.API.Tests;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.*;



public class TestGetRequest {
	@Test
	void authorsGetMethodTestStatusCode200() {
		  given().
	        when().
	            get(
	  "https://fakerestapi.azurewebsites.net/api/v1/Authors").
	            then().
	            assertThat().statusCode(200);
	        
	}
	@Test
	void authorsGetMethodTestNonValidStatusCode404() {
		  given().
	        when().
	            get(
	  "https://fakerestapi.azurewebsites.net/api/v1/Authors").
	            then().
	            assertThat().statusCode(404);
}
	@Test
	void authorsGetMethodTestWithGivenIdBookValue() {
	      RestAssured.baseURI = "https://fakerestapi.azurewebsites.net";
	      given() .when().get("/api/v1/Authors/1").
	      then().log().all()    
	      .assertThat().statusCode(200)
	      .body("firstName", Matchers.equalTo("First Name 1"));
	}
}
