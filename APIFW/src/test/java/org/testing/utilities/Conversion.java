package org.testing.utilities;

import org.json.JSONObject;
import org.json.XML;

public class Conversion 
{
public static String xmltojson(String xmldata)
{
	JSONObject js=XML.toJSONObject(xmldata);
	return js.toString();
}
public static String jsontoxml(String jsondata)
{
	JSONObject obj=new JSONObject(jsondata);
	String  xml_data=XML.toString(obj);
	return xml_data;
}
}
