package org.tsting.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responsevalidation.Responsevalidation;
import org.testing.teststeps.HttpMethod;
import org.testing.utilities.Jsonparsing;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Tc9 
{
	@Test
	public void Testcase3() throws IOException
	{
		Properties pr=LoadPropertiesFile.propertiesfile("../APIFW/URI.properties");
		HttpMethod HTTP=new HttpMethod(pr);
		System.out.println("******Tc9********");
		for(int i=0;i<25;i++)
		{
		Response res=HTTP.getAllRecords("QA_Env_GetAllEmployeeData_URI");
		boolean statuscode=Responsevalidation.methodrunasperstatuscode(201, res);
		Jsonparsing.JsonparseAllkeys(res.asString(),"id");
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
	}
}
