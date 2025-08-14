package test1;


import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;


public class SoapXmlRequest {
	
	@Test
	
	public void ValidateSoapXml() throws IOException {
		
			
		File file = new File("./SoapRequests/add.xml");
		if(file.exists())
			System.out.println("  >> file Exists");
		
		FileInputStream fileinputstream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileinputstream,"UTF-8");
		
		baseURI = "http://www.dneonline.com";
		
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/calculator.asmx").
		then(). 
			statusCode(200).log().all(). 
		and().
		    body("//*:AddResult.text()", equalTo("5"));
		
		
	}
}
