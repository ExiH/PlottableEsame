package ese2;

import java.util.List;

import ese1.NotPlottableException;
import ese1.OutOfMarginException;

public class ControlloreFrame {
	//è un bridge fra il frame che disegna e quello che mostra le statistiche
	List <FiguraPiana> list;
	FrameGrafico frameGrafico;
	InfoFrame infoFrame;
	FiguraPiana figuraMax;
	public ControlloreFrame(List <FiguraPiana> l) {
		list = l;
		frameGrafico = new FrameGrafico();
		infoFrame = new InfoFrame();
		figuraMax = new RectanglePlottable(0, 0, 0 ,0);
	}
	
	public void run() {
		infoFrame.setVisible(true);
		frameGrafico.setVisible(true);
		for(FiguraPiana fp : list) {
			System.out.println("Analisi figura "+fp.toString());
			if(!(fp instanceof Plottable)) {
				infoFrame.addException(new NotPlottableException());
			}
			else {
				try {
					frameGrafico.drawPlottable((Plottable)fp);
					System.out.println("Disegnato");
					if(fp.compareTo(figuraMax) == 1) {
						figuraMax = fp;
						infoFrame.updateBiggestShape(fp.toString());
					}
				} catch (OutOfMarginException e) {
					infoFrame.addException(e);
				}
			}
		}
	}
}