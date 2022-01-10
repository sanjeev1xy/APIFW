package org.testing.responsevalidation;

import org.testing.utilities.Jsonparsing;
import org.testng.Assert;

import io.restassured.response.Response;

public class Responsevalidation 
{
public static void statusCodevalidation(int expectedResponsecode,Response res)
{
	Assert.assertEquals(res.statusCode(), expectedResponsecode,"Status code is not matching");
	/*if(res.statusCode()==expectedResponsecode)
	{
		System.out.println("Status code is correct "+res.statusCode());
	}
	else
	{
		System.out.println("Status code is not matching "+res.statusCode());
	}*/
}
public static void dataValidation(String expectedData,Response res,String jsonPath)
{
	String actualData=Jsonparsing.jsonParseUsingJsonpath(res, jsonPath);
	if(actualData.equals(expectedData))
	{
		System.out.println("Data is matching");
	}
	else
	{
		System.out.println("Data is not matching");
	}
}
public static boolean methodrunasperstatuscode(int expectedResponsecode, Response res) 
{
	if(res.statusCode()==expectedResponsecode) {
		
		return true;
	}else {
		
		return false;
	}
}
} 
