package org.testing.teststeps;

import static io.restassured.RestAssured.*;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HttpMethod 
{
	Properties pr;
	public HttpMethod(Properties pr) 
	{
		this.pr=pr;
	}
public Response postmethod(String Bodydata,String uriKey)
{
	Response res=
     given()
     .contentType(ContentType.JSON)
     .body(Bodydata)
     .when()
     .post(pr.getProperty(uriKey));
	//System.out.println("Status code is "+res.statusCode());
	return res;
}
public Response getmethod(String uriKey, String id)
{
	String uri=pr.getProperty(uriKey)+"/"+id;
	Response res=
			given()
			.contentType(ContentType.JSON)
			.when()
			.get(uri);
	     return res;
			
}
public Response getAllRecords(String urikey)
{
	String uri=pr.getProperty(urikey);
	
	Response res=
	given()
	.contentType(ContentType.JSON)
	.when()
	.get(uri);
	
	return res;
}
public Response updateRecords(String Bodydata,String uriKey, String idValue)
{
	String uri=pr.getProperty(uriKey)+"/"+idValue;
	Response res=
	given()
	.contentType(ContentType.JSON)
	.body(Bodydata)
	.when()
	.put(uri);
	return res;
}
public Response delete (String uriKey, String id)
{
	String uri=pr.getProperty(uriKey)+"/"+id;
	Response res=
			given()
			.contentType(ContentType.JSON)
			.when()
			.delete(uri);
	     return res;
}
}