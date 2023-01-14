package menu;
import java.util.ArrayList;
import alimenti.*;

//Sistemare menu

public abstract class Menu implements Ordinabile{
	protected double costo;
	//protected ArrayList<Piatto> alimenti;
	
	public Menu() {
		super();
		//this.alimenti = new ArrayList<>();
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
}
