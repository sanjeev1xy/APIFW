package org.tsting.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responsevalidation.Responsevalidation;
import org.testing.teststeps.HttpMethod;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Tc8 
{
	@Test
	public void testcase2() throws IOException
	{
		Properties pr=LoadPropertiesFile.propertiesfile("../APIFW/URI.properties");
		HttpMethod HTTP= new HttpMethod(pr);
		System.out.println("*************Tc8**************");
		for(int i=0;i<15;i++)
		{
		Response res=HTTP.getmethod("QA_Env_GetSingleEmployeeData_URI", Tc7.responseidvalue);
		boolean statuscode =Responsevalidation.methodrunasperstatuscode(201, res);
		if(statuscode)
		{
			System.out.println("Status code is "+res.statusCode());
			System.out.println("Response is "+res.asString());
			break;
		}
		else 
		{
			System.out.println("status code is "+res.statusCode()+"try again..");
		}
		}
		
		//Responsevalidation.dataValidation("Lokesh", res, "Firstname");
	}
}
