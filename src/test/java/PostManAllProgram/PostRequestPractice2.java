package PostManAllProgram;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestPractice2 {
	@Test
	public void resisterUser() {
		RestAssured.baseURI= "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format
		requestParams.put("email", "eve.holt@reqres.in");  //put (key, value) pair--> Use Map concept
		requestParams.put("password", "pistol");

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.POST,"/register");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		System.out.println("Status Code : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		int id = response.jsonPath().get("id");
		System.out.println("ID = "+id);
		
		String token = response.jsonPath().get("token");
		System.out.println("Token = "+token);
		
		Assert.assertEquals(id, 4);
		Assert.assertEquals(token, "QpwL5tke4Pnpja7X4");
	}
//	@Test
	public void loginUser() {
		RestAssured.baseURI= "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload- // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format
		requestParams.put("email", "eve.holt@reqres.in");  //put (key, value) pair--> Use Map concept
		requestParams.put("password", "cityslicka");

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.POST,"/api/login");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		System.out.println("Status Code : "+response.getStatusCode());

		Assert.assertEquals(response.getStatusCode(), 200);
		
		String contentType = response.header("content-type");
		System.out.println("Content Type= "+contentType);
		
		String server = response.header("server");
		System.out.println("Server = "+server);
		
	}
//	@Test
	public void PrintAllHeader() {
		RestAssured.baseURI= "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload- // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format
		requestParams.put("name", "morpheus");  //put (key, value) pair--> Use Map concept
		requestParams.put("job", "leader");

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.POST,"/api/users");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		System.out.println("Status Code : "+response.getStatusCode());

		Assert.assertEquals(response.getStatusCode(), 201);
		
		//  print all headers
		
		Headers allHeader = response.headers(); //Headers class
		
		for (Header header : allHeader) {  // using for each loop
			System.out.println(header.getName() + " " + header.getValue());
		}	
	}
//	@Test
	public void loginSuccessful() {
		RestAssured.baseURI= "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload- // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format
		requestParams.put("email", "eve.holt@reqres.in");  //put (key, value) pair--> Use Map concept
		requestParams.put("password", "cityslicka");

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.POST,"/api/login");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		System.out.println("Status Code : "+response.getStatusCode());

		Assert.assertEquals(response.getStatusCode(), 200);
		
		//  print all headers
		
		Headers allHeader = response.headers(); //Headers class
		
		for (Header header : allHeader) {  // using for each loop
			System.out.println(header.getName() + " " + header.getValue());
		}	
} 
	@Test
	public void loginUnSuccessful() {
		RestAssured.baseURI= "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload- // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format
		requestParams.put("email", "peter@klaven");  //put (key, value) pair--> Use Map concept

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.POST,"/api/login");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		System.out.println("Status Code : "+response.getStatusCode());

		Assert.assertEquals(response.getStatusCode(), 400);
		
		//  print all headers
		
		Headers allHeader = response.headers(); //Headers class
		
		for (Header header : allHeader) {  // using for each loop
			System.out.println(header.getName() + " " + header.getValue());
		}	
} 
//	@Test
	public void createNewRecord() {
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload- // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format
		requestParams.put("name", "test");  //put (key, value) pair--> Use Map concept
		requestParams.put("salary", "123");
		requestParams.put("age", "23");

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.POST,"/api/v1/create");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		System.out.println("Status Code : "+response.getStatusCode());

		Assert.assertEquals(response.getStatusCode(), 200);
		
		//  print all headers
		
		Headers allHeader = response.headers(); //Headers class
		
		for (Header header : allHeader) {  // using for each loop
			System.out.println(header.getName() + " " + header.getValue());
		}
} 
}