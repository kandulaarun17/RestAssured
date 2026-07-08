package response_validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseValidation_Ways {

	@Test
	public void validateStatusCode() {
		Response res = given().baseUri("http://localhost:3000").when().get("/Customers").then().statusCode(200)
				.extract().response();

		int sc = res.getStatusCode();
		Assert.assertEquals(sc, 200);

	}

	@Test
	public void validateFieldValue() {
		Response res = given().baseUri("http://localhost:3000").when().get("/Customers");

		String city = res.jsonPath().getString("city");
		Assert.assertTrue(city.contains("New York"));
	}

	@Test
	public void validateHeader() {
		Response res = given().baseUri("http://localhost:3000").when().get("/Customers");
		String ct = res.getContentType();
		Assert.assertEquals(ct, "application/json");
	}

}
