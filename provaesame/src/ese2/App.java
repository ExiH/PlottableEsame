package ese2;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String []args) {
		List<FiguraPiana> l = new ArrayList<FiguraPiana>();
		
		l.add(new RectanglePlottable(20, 20, 100, 100));
		l.add(new RectanglePlottable(0, 0, 150, 150));
		l.add(new RectanglePlottable(200, 120, 1000, 10000));
		
		ControlloreFrame cf = new ControlloreFrame(l);
		cf.run();

	}
}
