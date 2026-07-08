package headers;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestHeadersImpl {

	@Test
	public void validateHeaderReq() {
		HashMap<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("Accept", "application/json");

		Response res = given().headers(requestHeaders).baseUri("http://localhost:3000").when().get("/Customers").then()
				.log().all().extract().response();

		String type = res.getHeader("Content-type");
		String time = res.getHeader("Connection");
		String len = res.getHeader("Content-Length");
		System.out.println(type + "->" + time + "->" + len);

	}

}
