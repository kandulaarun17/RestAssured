package files;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import java.io.File;

import org.testng.annotations.Test;

public class UploadDemo {

	@Test
	public void upload() {
		given().contentType("multipart/form-data").baseUri("https://the-internet.herokuapp.com/")
				.multiPart("file", new File("D:\\ARUN\\Resume.pdf")).when().post("/upload").then().statusCode(200)
				.body(containsString("Resume.pdf"));
	}

}
