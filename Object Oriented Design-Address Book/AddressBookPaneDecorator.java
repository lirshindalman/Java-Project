import javafx.scene.layout.Pane;

public abstract class AddressBookPaneDecorator implements AddressBP {
	
	 protected AddressBP decoratorPane;
	 
	 public AddressBookPaneDecorator (AddressBP adressBP) {
		 this.decoratorPane=adressBP;
	 }

	@Override
	public void addButtons(CommandButton... buttons) {
		decoratorPane.addButtons(buttons);
		
	}
	@Override
	public Pane getPane() {	
		return decoratorPane.getPane();
	}

	
}
