package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathParameters {

	@Test
	public void getData() {
		given().baseUri("http://localhost:3000").pathParams("id", "1").when().get("/Customers/{id}").then()
				.statusCode(200).log().body();

		given().baseUri("http://localhost:3000").pathParams("id", "2").when().get("/Customers/{id}").then()
				.statusCode(200).log().body();
	}

}
