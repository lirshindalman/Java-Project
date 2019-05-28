import java.io.RandomAccessFile;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PaneWithUpdateButtons extends AddressBookPaneDecorator {
	private Stack<Memento> stack= new Stack<Memento>();
	public PaneWithUpdateButtons(AddressBP adressBP,RandomAccessFile raf) {
		super(adressBP);
		AddButton jbtAdd = new AddButton("Add",(AddressBookPane)adressBP,raf);
		UndoButton jbtUndo = new UndoButton("Undo",stack,(AddressBookPane)adressBP,raf);
		RedoButton jbtRedo = new RedoButton("Redo",stack,(AddressBookPane)adressBP,raf);
		addButtons(jbtAdd,jbtUndo, jbtRedo);
	}
	
	public EventHandler<ActionEvent> ae = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent arg0) {
			((Command) arg0.getSource()).Execute();
		}
	};

}
