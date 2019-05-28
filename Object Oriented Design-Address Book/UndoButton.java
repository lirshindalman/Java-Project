import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Stack;

public class UndoButton extends CommandButton {
	private Stack<Memento> stack;

	public UndoButton(String text, Stack<Memento> stack, AddressBookPane pane, RandomAccessFile r) {
		super(text, pane, r);
		this.stack = stack;
	}

	@Override
	public void Execute() {
		try {
			long lastPos = raf.length();
			if (lastPos > 0) {
				Address address = makeAdressObject(lastPos - 2 * RECORD_SIZE);
				stack.push(new Memento(address));
				
				  raf.setLength(lastPos - 2*RECORD_SIZE); 
				  if(raf.length()>0)
				  readAddress(0); 
				  
				 
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
