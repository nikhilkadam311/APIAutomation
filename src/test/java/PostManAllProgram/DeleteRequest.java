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

public class DeleteRequest {

	@Test
	public void PutRequest() {
		RestAssured.baseURI= "http://dummy.restapiexample.com";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload- // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.DELETE,"/api/v1/delete/2");
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