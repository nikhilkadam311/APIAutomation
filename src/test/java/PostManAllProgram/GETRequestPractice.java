package PostManAllProgram;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequestPractice {
	@Test
	public void getListOfEmployees() { 
		// Base URI
		RestAssured.baseURI= "https://reqres.in/api/users";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given(); //httpRequest will be used to send the request
		Response response = httpRequest.request(Method.GET,"?page=2");     //Query parameter

		String responseBody = response.getBody().asPrettyString(); // OR Another method as.String();
		System.out.println("Response Body : "+responseBody);

		//how to read and print status code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code = "+statusCode);		

		//how to read and print status Line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line = "+statusLine);

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}
//	@Test
	public void GETUsersDetails() {
		// Base URI
		RestAssured.baseURI= "https://reqres.in/api/users";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given(); //httpRequest will be used to send the request
		Response response = httpRequest.request(Method.GET,"/2");    //path parameter

		String responseBody = response.getBody().asPrettyString(); // OR Another method as.String();
		System.out.println("Response Body : "+responseBody);

		//how to read and print status code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code = "+statusCode);		

		//how to read and print status Line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line = "+statusLine);

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);

	}
//	@Test
	public void ReturnListOfUser() {
		// Base URI
		RestAssured.baseURI= "http://dummy.restapiexample.com";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given(); //httpRequest will be used to send the request
		Response response = httpRequest.request(Method.GET,"/api/v1/employees");    //path parameter

		String responseBody = response.getBody().asPrettyString(); // OR Another method as.String();
		System.out.println("Response Body : "+responseBody);

		//how to read and print status code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code = "+statusCode);		

		//how to read and print status Line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line = "+statusLine);

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}
//	@Test
	public void returnSingleUser() {
		// Base URI
		RestAssured.baseURI= "http://dummy.restapiexample.com";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given(); //httpRequest will be used to send the request
		Response response = httpRequest.request(Method.GET,"/api/v1/employee/1");    //path parameter

		String responseBody = response.getBody().asPrettyString(); // OR Another method as.String();
		System.out.println("Response Body : "+responseBody);

		//how to read and print status code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code = "+statusCode);		

		//how to read and print status Line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line = "+statusLine);

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}
//	@Test
	public void SingleEmpoyeeData() {
		// Base URI
		RestAssured.baseURI= "http://dummy.restapiexample.com";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given(); //httpRequest will be used to send the request
		Response response = httpRequest.request(Method.GET,"/api/v1/employee/1");    //path parameter

		String responseBody = response.getBody().asPrettyString(); // OR Another method as.String();
		System.out.println("Response Body : "+responseBody);

		//how to read and print status code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code = "+statusCode);		

		//how to read and print status Line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line = "+statusLine);

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}
}