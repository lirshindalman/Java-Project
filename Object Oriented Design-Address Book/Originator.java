
public class Originator {
	private Address addres;

	   public void setState(Address addres){
	      this.addres = addres;
	   }

	   public Address getAddres(){
	      return addres;
	   }

	   public Memento saveAddresToMemento(){
	      return new Memento(addres);
	   }

	   public void getAddresFromMemento(Memento memento){
		   addres = memento.getAddsres();
	   }
}
