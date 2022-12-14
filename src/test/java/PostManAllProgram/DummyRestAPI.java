package PostManAllProgram;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DummyRestAPI {
	@Test
	public void getListOfEmployee() {
		// Base URI
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1"; 

		//Request Object
		RequestSpecification httpRequest = RestAssured.given(); //httpRequest will be used to send the request
		Response response = httpRequest.request(Method.GET,"/employees");    //path parameter

		String responseBody = response.getBody().asPrettyString(); // OR Another method as.String();
		//	validating string in the response
		Assert.assertEquals(true, responseBody.contains("Tiger Nixon"));
		
		JsonPath jPath = response.jsonPath();
		//	validating string at JSON Node
		System.out.println(jPath.getString("data[15].employee_name"));
		
		Assert.assertEquals("Michael Silva", jPath.getString("data[15].employee_name"));
	
	}
}
