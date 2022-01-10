package org.testing.utilities;

import java.util.regex.Pattern;

public class Jsonvariable 
{
public static String jsonvariablereplacement(String data,String KeyName, String KeyValue)
{
	data=data.replaceAll(Pattern.quote("{{"+KeyName+"}}"),KeyValue);
	return data;
}
}
