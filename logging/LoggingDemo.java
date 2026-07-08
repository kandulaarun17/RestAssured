package logging;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class LoggingDemo {

	@BeforeClass
	public void setUpLogging() throws IOException {
		RestAssured.reset();
		File f = new File("logs");
		if (!f.exists()) {
			f.mkdirs();
		}
		String fn = "logging";
		PrintStream log = new PrintStream(new FileOutputStream("logs/" + fn + ".log"));
		RestAssured.filters(new RequestLoggingFilter(log), new ResponseLoggingFilter(log));

	}

	@Test
	public void getData() {
		given().baseUri("http://localhost:3000").when().get("/Customers").then().log().ifStatusCodeIsEqualTo(200);
	}

}
