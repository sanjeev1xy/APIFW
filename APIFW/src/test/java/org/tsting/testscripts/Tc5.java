package org.tsting.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HttpMethod;
import org.testing.utilities.Jsonvariable;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.json;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Tc5 
{
	@Test
public void Testcase5() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesfile("../APIFW/URI.properties");
	HttpMethod HTTP=new HttpMethod(pr);
	Response res=HTTP.delete("QA_Env_APIStudents_URIs",Tc1.responseidvalue);
	System.out.println("***********Tc5*************");
	System.out.println("Status Code is "+res.statusCode());
	System.out.println("Response is "+res.asString());
}
}