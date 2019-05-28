import java.io.IOException;
import java.io.RandomAccessFile;

public class FirstButton extends CommandButton {
	public FirstButton(String text ,AddressBookPane pane, RandomAccessFile r) {
		super(text,pane, r);
	}

	@Override
	public void Execute() {
		try {
			if (raf.length() > 0)
				readAddress(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
