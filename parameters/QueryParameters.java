package parameters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class QueryParameters {
	@Test
	public void getData() {
		given().baseUri("http://localhost:3000").queryParams("city", "London").when().get("/Customers").then()
				.statusCode(200).body("[0].name", equalTo("Jane Smith")).log().all();

		given().baseUri("http://localhost:3000").queryParams("city", "Paris").when().get("/Customers").then()
				.statusCode(200).body("[0].age", equalTo(35)).log().all();

	}
}
