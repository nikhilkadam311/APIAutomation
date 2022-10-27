package RESTAPIGETPOST;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTesting {
	@Test(dataProvider ="UserDataExcel")
	public void createUser(String userName,String userJob) {
		RestAssured.baseURI= "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();

		//*post* how to add request payload- // use for post request
		JSONObject requestParams = new JSONObject();  // Request payload class in the json format
		requestParams.put("name", userName);  //put (key, value) pair--> Use Map concept
		requestParams.put("job", userJob);

		//*post* Specific request payload type of header // use for post request
		httpRequest.headers("Content-Type","application/json");    //map<String> header

		// adding payload to request
		httpRequest.body(requestParams.toJSONString());

		//Send the request
		Response response = httpRequest.request(Method.POST,"/users");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		System.out.println("Status Code : "+response.getStatusCode());

		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(responseBody.contains(userName), true);
		Assert.assertEquals(responseBody.contains(userJob), true);
	}
	
//	@DataProvider(name="UserData")
//	Object[][] getUserData(){
//			String[][] userData = {{"Vishal","QA"},{"Nikhil","SDET"},{"samir","TestEngineer"}};
//			return userData;
//	}
	@DataProvider(name="UserDataExcel")
	Object[][] getUserDataExcel() throws IOException{
//			String xlfile = "./src/test/java/RESTAPIGETPOST/TestData.csv"; 
//			("./src/test/resources/org/excelFiles/TestData.xlsx");	
//		System.getProperty("user.dir")+("\\src\\test\\resources\\fileUpload\\FileToUpload.txt"))
			String xlfile = System.getProperty("user.dir")+("./src/test/java/RESTAPIGETPOST/TestData.csv"); 
 
			int rowNum = ExcelUtility.getRowCount(xlfile, "UserData");
			int colNum = ExcelUtility.getCellCount(xlfile, "UserData", rowNum);

			String[][] userData = new String[rowNum][colNum];
			for(int i=1; i<= rowNum; i++) {
				for(int j=0; j< colNum; j++) {
					userData[i-1][j] = ExcelUtility.getCellData(xlfile, "UserData", i, j);
				}
			}
			return userData;
	}
}