package request_body_approaches;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class Using_POJO {
	String id;

	@Test(priority = 1)
	public void postData() {
		Orders data = new Orders();
		data.setOrderId(546);
		data.setName("Arun");
		data.setLocation("Chennai");

		id = given().contentType("application/json").body(data).post("http://localhost:3000/Orders").then()
				.statusCode(201).body("orderId", equalTo(546)).log().all().extract().path("id");
		System.out.println(id);

	}

	@Test(priority = 2)
	public void deleteData() {
		System.out.println(id);
		given().pathParam("id", id).when().delete("http://localhost:3000/Orders/{id}").then().statusCode(200);
	}
}
