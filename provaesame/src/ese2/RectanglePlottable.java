package ese2;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import ese1.OutOfMarginException;

public class RectanglePlottable extends FiguraPiana implements Plottable {

	Rectangle r;
	
	public RectanglePlottable(Rectangle r) {
		super();
		this.r = r;
	}
	
	public RectanglePlottable(int x, int y, int wid, int heigth) {
		this.r = new Rectangle(x, y, wid, heigth);
	}


	public void plot(Graphics2D g, int amp, int alt) throws OutOfMarginException {
		if(!isInBounds(amp, alt)) throw new OutOfMarginException();
		g.draw(r);
	}
	
	public Boolean isInBounds(int amp, int alt) {
		if(r.x + r.width > amp || r.y + r.height > alt) {
			return false;
		}
		System.out.println("amp: "+ amp +" alt: "+ alt);
		return true;
	}

	public float getArea() {
		return r.width * r.height;
	}

	
	public int compareTo(FiguraPiana o) {
		if(this.getArea() > o.getArea())
			return 1;
		else if(this.getArea() < o.getArea())
			return -1;
		else return 0;
	}
	
	@Override
	public String toString() {
		return "Rettangolo di altezza "+ r.height + " e larghezza "+r.width; 
	}

}
