import java.io.IOException;
import java.io.RandomAccessFile;

public class NextButton extends CommandButton {
	public NextButton(String text,AddressBookPane pane, RandomAccessFile r) {
		super(text, pane, r);
	}

	@Override
	public void Execute() {
		try {
			long currentPosition = raf.getFilePointer();
			if (currentPosition < raf.length())
				readAddress(currentPosition);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}