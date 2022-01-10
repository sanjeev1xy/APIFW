package org.tsting.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpVersion;
import org.testing.teststeps.HttpMethod;
import org.testing.utilities.Jsonparsing;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Tc3 
{
	@Test
public void Testcase3() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesfile("../APIFW/URI.properties");
	HttpMethod HTTP=new HttpMethod(pr);
	Response res=HTTP.getAllRecords("QA_Env_APIStudents_URIs");
	System.out.println("*************Tc3**************");
	Jsonparsing.JsonparseAllkeys(res.asString(),"id");
	System.out.println("Status code is "+res.statusCode());
	System.out.println("Response is "+res.asString());
}
}
