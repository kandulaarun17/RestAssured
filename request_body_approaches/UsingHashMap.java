package request_body_approaches;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class UsingHashMap {
	String id;

	@Test(priority = 1)
	public void postData() {
		HashMap<String, Object> data = new HashMap<>();
		data.put("OrderId", 228);
		data.put("Name", "Anjali");
		data.put("Location", "Hyderabad");

		id = given().contentType("application/json").body(data).post("http://localhost:3000/Orders").then()
				.statusCode(201).body("OrderId", equalTo(228)).log().all().extract().path("id");
		System.out.println(id);

	}

	@Test(priority = 2)
	public void deleteData() {
		System.out.println(id);
		given().when().delete("http://localhost:3000/Orders/" + id).then().statusCode(200);
	}
}
