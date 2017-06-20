package CatCollection.Debug;

public class ObjectParser {

	public static String ParseArrayToString(Object[] data, int toIndex, String prefix, String suffix, String link) {
		
		StringBuffer stringBuffer=new StringBuffer(prefix);
		for(int i=0;i<toIndex;i++)
		{
			if(i==toIndex-1)
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
