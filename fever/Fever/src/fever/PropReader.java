package fever;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader extends Properties
{

    private static final long serialVersionUID = 1L;

    
	public PropReader() throws IOException
	{

		super();
		
		String file = "resources/settings.properties";
		InputStream i = getClass().getClassLoader().getResourceAsStream(file);
		if( i != null )
		{
			this.load(i);
		}
	}
	

	
}
