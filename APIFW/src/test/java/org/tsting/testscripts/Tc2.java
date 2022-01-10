package org.tsting.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responsevalidation.Responsevalidation;
import org.testing.teststeps.HttpMethod;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Tc2 
{
	@Test
public void testcase2() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesfile("../APIFW/URI.properties");
	HttpMethod HTTP= new HttpMethod(pr);
	Response res=HTTP.getmethod("QA_Env_APIStudents_URIs", Tc1.responseidvalue);
	System.out.println("******************Tc2*****************");
	System.out.println("Status code is "+res.statusCode());
	System.out.println("respnse is "+res.asString());
	Responsevalidation.statusCodevalidation(201, res);
	Responsevalidation.dataValidation("Lokesh", res, "Firstname");
}
}
 