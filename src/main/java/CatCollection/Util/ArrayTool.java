package CatCollection.Util;

import CatCollection.Debug.ObjectParser;

public class ArrayTool {

	public static String toString(Object[] data, int index) {
		
		
		return ObjectParser.ParseArrayToString(data,index,"[","]",",");
	}

}
