package org.tsting.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responsevalidation.Responsevalidation;
import org.testing.teststeps.HttpMethod;
import org.testing.utilities.Jsonparsing;
import org.testing.utilities.Jsonvariable;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.Randomdata;
import org.testing.utilities.json;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Tc7 
{
	static String responseidvalue;
	@Test
public void testcase1() throws IOException 
{
	String Bodydata =json.loadjsonfile("../APIFW/src/test/java/org/testing/payoads/bodydata.json");
	String randomid=Randomdata.random();
	Bodydata=Jsonvariable.jsonvariablereplacement(Bodydata,"id", randomid);
	
	Properties pr=LoadPropertiesFile.propertiesfile("../APIFW/URI.properties");
	HttpMethod HTTP=new HttpMethod(pr);
		
	
	System.out.println("***************TC7****************");
	for(int i=0;i<20;i++)	
	{
		Response res = HTTP.postmethod(Bodydata, "QA_Env_CreateNewRecordInDatabase_URI");
		boolean statuscode = Responsevalidation.methodrunasperstatuscode(200, res);
		if(statuscode) 
		{
			System.out.println("Status code is "+res.statusCode());
			System.out.println("response data is "+res.asString());
			break;
		}
		else 
		{
			
			System.out.println("Status code is "+res.statusCode() + ", try again...");
		}
}
}}
