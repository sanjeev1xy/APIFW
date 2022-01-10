package org.tsting.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HttpMethod;
import org.testing.utilities.Jsonvariable;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.json;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Tc4
{
	@Test
public void Testcase4() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesfile("../APIFW/URI.properties");
	String Bodydata=json.loadjsonfile("../APIFW/src/test/java/org/testing/payoads/bodyaDataforUpdate.json");
	Bodydata=Jsonvariable.jsonvariablereplacement(Bodydata, "id", Tc1.responseidvalue);
	HttpMethod HTTP=new HttpMethod(pr);
	Response res=HTTP.updateRecords(Bodydata, "QA_Env_APIStudents_URIs", Tc1.responseidvalue);
	System.out.println("***********Tc4*************");
	System.out.println("Status Code is "+res.statusCode());
	System.out.println("Response is "+res.asString());
}
}
