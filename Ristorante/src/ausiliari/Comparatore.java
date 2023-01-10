package ausiliari;

import java.util.Comparator;

import ordine.Ordine;

public class Comparatore implements Comparator<Ordine> {
	@Override
    public int compare(Ordine o1, Ordine o2) {
        return (int) (o1.getTempo() - o2.getTempo());
    }
}

