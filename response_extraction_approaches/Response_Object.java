package response_extraction_approaches;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Response_Object {

	@Test
	public void StatusCode() {

		Response response = given().baseUri("http://localhost:3000").when().get("/Customers");
		Assert.assertEquals(response.getStatusCode(), 200);
		String contentType = response.getContentType();
		Assert.assertEquals(contentType, "application/json");
	
	}

}
