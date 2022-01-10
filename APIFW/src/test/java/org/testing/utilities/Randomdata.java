package org.testing.utilities;

import java.util.Random;

public class Randomdata 
{
public static String random()
{
	Random r=new Random();
	Integer i=r.nextInt();
	return i.toString();
}
}
