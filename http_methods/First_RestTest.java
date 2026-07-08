package http_methods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class First_RestTest {
	@Test
	public void getData() {
		given().baseUri("http://localhost:3000/").when().head().then().statusCode(200).log().headers();
	}

}
