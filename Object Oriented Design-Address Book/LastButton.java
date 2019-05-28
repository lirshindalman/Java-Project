import java.io.IOException;
import java.io.RandomAccessFile;

public class LastButton extends CommandButton
{ public LastButton(String text, AddressBookPane pane, RandomAccessFile r)
{	
	super(text, pane, r);
}
@Override
public void Execute()
{	try
  { long lastPosition = raf.length();
	  if (lastPosition > 0)
		readAddress(lastPosition - 2 * RECORD_SIZE);
	} 
  catch (IOException ex)
  { ex.printStackTrace();
	}
 }
}