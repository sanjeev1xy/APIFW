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

public class Tc1 
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
	Response res=HTTP.postmethod(Bodydata, "QA_Env_APIStudents_URIs");
	responseidvalue=Jsonparsing.Jsonparse(res.asString(), "id");
	Responsevalidation.statusCodevalidation(201, res);
}
}
 