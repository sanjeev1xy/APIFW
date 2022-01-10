package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class json 
{
public static String loadjsonfile(String Path) throws FileNotFoundException
{
	File f=new File(Path);
	FileInputStream fi=new FileInputStream(f);
	JSONTokener js=new JSONTokener(fi);
	JSONObject body=new JSONObject(js);
	return body.toString();
	}
}
