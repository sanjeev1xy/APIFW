package org.tsting.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responsevalidation.Responsevalidation;
import org.testing.teststeps.HttpMethod;
import org.testing.utilities.Jsonvariable;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.json;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Tc10 
{
	@Test
	public void Testcase4() throws IOException
	{
		Properties pr=LoadPropertiesFile.propertiesfile("../APIFW/URI.properties");
		String Bodydata=json.loadjsonfile("../APIFW/src/test/java/org/testing/payoads/bodyaDataforUpdate.json");
		Bodydata=Jsonvariable.jsonvariablereplacement(Bodydata, "id", Tc1.responseidvalue);
		HttpMethod HTTP=new HttpMethod(pr);
		System.out.println("****Tc9*****");
		for(int i=0;i<15;i++)
		{
		Response res=HTTP.updateRecords(Bodydata, "QA_Env_APIStudents_URIs", Tc1.responseidvalue);
		boolean statuscode=Responsevalidation.methodrunasperstatuscode(201, res);
		if(statuscode)
		{
		System.out.println("Status Code is "+res.statusCode());
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