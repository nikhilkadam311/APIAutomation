package RESTAPIGETPOST;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAutherization {
  @Test
  public void getListOfEmployees() {
	  // Base URI
	  RestAssured.baseURI= "https://postman-echo.com/";
	  // Basic Autherization 
	  PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
	  basicAuth.setUserName("postman");
	  basicAuth.setPassword("password");
	  RestAssured.authentication = basicAuth;
	  
	  //Request Object
		RequestSpecification httpRequest = RestAssured.given(); //httpRequest will be used to send the request
		Response response = httpRequest.request(Method.GET, "basic-auth");     //Query parameter
		
		String responseBody = response.getBody().asPrettyString(); // OR Another method as.String();
		System.out.println("Response Body : "+responseBody);
		
		Assert.assertEquals(response.getStatusCode(), 200);		

//		//how to read and print status Line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line = "+statusLine);
		
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);  
}
}