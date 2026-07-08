package parameters;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class MultipleParameters {
	@Test
	public void getData() {
		given().pathParams("id", "1").queryParams("city", "New York").baseUri("http://localhost:3000").when()
				.get("/Customers/{id}").then().log().all();
	}

}
