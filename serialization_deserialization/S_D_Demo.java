package serialization_deserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class S_D_Demo {

	@Test
	public void updateData() {
		CustomerPOJO obj = new CustomerPOJO();
		obj.setCity("India");
		Response res = given().pathParam("id", 5).baseUri("http://localhost:3000").body(obj).when()
				.patch("/Customers/{id}").then().statusCode(200).extract().response();

		CustomerPOJO_Response customer = res.as(CustomerPOJO_Response.class);

		System.out.println(customer.getCity());
		System.out.println(res.statusCode());
	}

	@Test(enabled = false)
	public void deleteData() {
		given().pathParam("id", 4).when().delete("http://localhost:3000/Customers/{id}").then().statusCode(200);
	}

}
