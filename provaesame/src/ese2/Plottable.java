package ese2;

import java.awt.Graphics2D;

import ese1.OutOfMarginException;

public interface Plottable {
	public void plot(Graphics2D g, int amp, int alt) throws OutOfMarginException;
	public Boolean isInBounds(int wid, int alt);
}
