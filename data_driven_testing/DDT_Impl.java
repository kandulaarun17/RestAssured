package data_driven_testing;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class DDT_Impl {
	@Test(dataProvider = "emp", dataProviderClass = Employee.class)
	public void sendData(String name, String job) {
		JSONObject data = new JSONObject();
		data.put("name", name);
		data.put("job", job);

		Response res = given().baseUri("http://localhost:3000").body(data.toString()).when().post("/Employees");

		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 201);

		Assert.assertEquals(res.jsonPath().getString("name"), name);
		Assert.assertEquals(res.jsonPath().getString("job"), job);

	}
}
