package CatCollection.Debug;

public class ObjectParser {

	public static String ParseArrayToString(Object[] data, int index, String prefix, String suffix, String link) {
		
		StringBuffer stringBuffer=new StringBuffer(prefix);
		for(int i=0;i<=index;i++)
		{
			if(i==index)
			{
				stringBuffer.append(data[i]);
			}
			else
			{
				stringBuffer.append(data[i]).append(link);
			}
			
		}
		stringBuffer.append(suffix);
			
		return stringBuffer.toString();
	}

}
