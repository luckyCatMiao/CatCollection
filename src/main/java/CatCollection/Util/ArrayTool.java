package CatCollection.Util;

import CatCollection.Debug.ObjectParser;

public class ArrayTool {

	public static String toString(Object[] data, int toIndex) {
		
		
		return ObjectParser.ParseArrayToString(data,toIndex,"[","]",",");
	}

	
	
	public static String toString(Object[] data) {
		
		
		return ObjectParser.ParseArrayToString(data,data.length,"[","]",",");
	}
}
