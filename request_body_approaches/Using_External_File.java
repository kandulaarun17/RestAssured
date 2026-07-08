package request_body_approaches;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class Using_External_File {
	String id;

	@Test(priority = 1)
	public void postData() throws FileNotFoundException {
		File f = new File("./External_JSON.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);

		id = given().contentType("application/json").body(data.toString()).post("http://localhost:3000/Orders").then()
				.log().all().statusCode(201).body("orderId", equalTo(721)).extract().path("id");
		System.out.println(id);

	}

	@Test(priority = 2)
	public void deleteData() {
		System.out.println(id);
		given().when().delete("http://localhost:3000/Orders/" + id).then().statusCode(200);
	}
}
