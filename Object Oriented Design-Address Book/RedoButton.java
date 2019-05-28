
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Stack;

public class RedoButton extends CommandButton {
	private Stack<Memento> stack;

	public RedoButton(String text, Stack<Memento> stack, AddressBookPane pane, RandomAccessFile r) {
		super(text, pane, r);
		this.stack = stack;
	}

	@Override
	public void Execute() {
		try 
		{
			if(!stack.isEmpty()) 
			{
				raf.seek(raf.length());
				writeAddress(stack.pop().getAddsres());
				long lastPos = raf.length();
				readAddress(lastPos -2*RECORD_SIZE);
			}	
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	
	}

	
}
