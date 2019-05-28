import java.io.RandomAccessFile;

public class AddButton extends CommandButton {
	public AddButton(String text,AddressBookPane pane, RandomAccessFile r) {
		super(text,pane, r);
		this.setText("Add");
	}

	@Override
	public void Execute() {
		writeAddress();
	}
}

