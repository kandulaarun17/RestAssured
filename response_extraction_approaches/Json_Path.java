package response_extraction_approaches;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Json_Path {
	@Test
	public void fullBody() {
		Response res = given().baseUri("http://localhost:3000").when().get("/Customers");
		String location = res.jsonPath().getString("[2].city");
		Assert.assertEquals(location, "Paris");

	}

	@Test
	public void singleResponse() {
		Response res = given().pathParams("id", 4).baseUri("http://localhost:3000").when().get("/Customers/{id}");
		int age = res.jsonPath().getInt("age");
		Assert.assertEquals(age, 28);

	}

	@Test
	public void multipleObjects() {
		Response res = given().baseUri("http://localhost:3000").when().get("/Customers");
		List<String> names = res.jsonPath().getList("name");
		Assert.assertTrue(names.contains("Charlie Davis"));

	}
}
