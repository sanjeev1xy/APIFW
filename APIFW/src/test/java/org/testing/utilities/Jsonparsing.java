package org.testing.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;

public class Jsonparsing 
{
public static String Jsonparse(String response, String Keyname)
{
	JSONObject ob=new JSONObject(response);
	return ob.get(Keyname).toString();
	
}
public static void JsonparseAllkeys(String response, String Keyname)
{
	JSONArray js=new JSONArray(response);
	int L=js.length();
	for(int i=0;i<L;i++)
	{
		JSONObject ob=js.getJSONObject(i);
		System.out.println(ob.get(Keyname));
	}
}
public static String jsonParseUsingJsonpath(Response res, String jsonPath)
{
	return res.jsonPath().get(jsonPath);
}
}
