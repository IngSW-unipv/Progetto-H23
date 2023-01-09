package menu;
import java.util.ArrayList;
import alimenti.*;

public abstract class Menu implements Ordinabile{
	protected double costo;
	protected ArrayList<Piatto> alimenti;
	
	public Menu() {
		super();
		this.alimenti = new ArrayList<>();
	}
	
}
