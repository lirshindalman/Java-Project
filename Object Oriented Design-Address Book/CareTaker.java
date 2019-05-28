import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	   public void add(Memento addres){
	      mementoList.add(addres);
	   }

	   public Memento getAddres(int index){
	      return mementoList.get(index);
	   }

}
