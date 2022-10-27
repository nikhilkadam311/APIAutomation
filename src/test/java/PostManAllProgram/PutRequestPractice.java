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

public class PutRequestPractice {

	@Test
	public void PutRequest() {
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload- // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format
		requestParams.put("name", "test123");  //put (key, value) pair--> Use Map concept
		requestParams.put("salary", "1234");  //put (key, value) pair--> Use Map concept
		requestParams.put("age", "23");  //put (key, value) pair--> Use Map concept

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.POST,"/api/v1/update/21");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		System.out.println("Status Code : "+response.getStatusCode());

		Assert.assertEquals(response.getStatusCode(), 405);

		//  print all headers

		Headers allHeader = response.headers(); //Headers class

		for (Header header : allHeader) {  // using for each loop
			System.out.println(header.getName() + " " + header.getValue());
		}	
	}
}