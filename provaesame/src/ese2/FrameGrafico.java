package ese2;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ese1.OutOfMarginException;

public class FrameGrafico extends JFrame {
	//è il frame che disegna le forme
	private static final long serialVersionUID = -5516021776227629423L;
	OutOfMarginException e;
	Plottable shape;
	PlottableComponent component;
	public FrameGrafico() {
		component = new PlottableComponent();
		e = null;
		this.setSize(500, 500);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.add(component);
	}
	
	
	public void drawPlottable(Plottable p) throws OutOfMarginException {
		shape = p;
		component.setShape(p);
		component.repaint();
		this.validate();
		if(e != null) {
			throw e;
		}
		e = null;
	}
	
	private class PlottableComponent extends JComponent {
		private static final long serialVersionUID = 5682112841197853700L;
		private Plottable shape;
		
		public PlottableComponent() {
			shape = null;

		}
		
		public void setShape(Plottable shape) {
			this.shape = shape;
		}
		
		@Override
		public void paintComponent(Graphics g) {
			System.out.println("aa");
			if(shape == null) return;
			try {
				shape.plot((Graphics2D) g, FrameGrafico.this.getWidth(), FrameGrafico.this.getHeight());
			} catch (OutOfMarginException e) {
				FrameGrafico.this.e = e;
			}
		}
	}
	

}
