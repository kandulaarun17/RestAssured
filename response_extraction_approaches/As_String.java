package response_extraction_approaches;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class As_String {
	@Test
	public void getData() {
		Response res = given().baseUri("http://localhost:3000").when().get("/Customers");
		String body = res.asString();
		System.out.println(body);
		Assert.assertTrue(body.contains("London"));
	}

}
