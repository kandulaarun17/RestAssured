package authentication;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Types {

	@Test
	public void basicAuth() {

		Response res = given().when().get("https://webhook.site/#!/view/3beaa028-1904-452d-b75a-4492eac5b04f");
		String token = res.jsonPath().getString("token");
		System.out.println(token);
	}

}
