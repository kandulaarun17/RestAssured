package spec_builder;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

public class Req_Res_Spec {

	RequestSpecification req;
	ResponseSpecification res;

	@BeforeClass
	public void request() {
		req = new RequestSpecBuilder().setBaseUri("http://localhost:3000").setContentType("application/json")
				.log(LogDetail.ALL).build();

	}

	@BeforeClass
	public void response() {
		res = new ResponseSpecBuilder().expectContentType("application/json").expectStatusCode(200)
				.expectResponseTime(lessThan(2000L)).build();
	}

	@Test
	public void getData() {
		given().pathParam("id", "qPF0G0DCAqE").spec(req).when().get("/Orders/{id}").then().spec(res).log().all();
	}

}
