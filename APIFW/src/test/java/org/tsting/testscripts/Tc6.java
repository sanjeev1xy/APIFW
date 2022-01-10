package org.tsting.testscripts;

import java.io.IOException;

import org.testing.utilities.Loadxmldata;
import org.testng.annotations.Test;

public class Tc6
{ 
	@Test
public void Testcase6() throws IOException 
{
  String response= Loadxmldata.readXml("../APIFW/src/test/java/org/testing/payoads/xmldata.xml");
  System.out.println("****************Tc6************");
  System.out.println(response);
 
}
}
