package ese2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InfoFrame extends JFrame {
	//è il frame che mostra le statistiche
	
	private static final long serialVersionUID = 3734949005833980479L;
	private JLabel countLabel;
	private JTextArea infoArea;
	private JLabel biggestShapeLabel;
	private JPanel exceptionPanel;
	private JPanel statPanel;
	private int count;
	public InfoFrame() {
		count = 0;
		this.setSize(500, 500);
		exceptionPanel = makeExceptionPanel();
		statPanel = makeStatPanel();
		countLabel.setText(""+count);
		this.add(exceptionPanel, BorderLayout.CENTER);
		this.add(statPanel, BorderLayout.SOUTH);
	}
	
	public void addException(Exception e) {
		infoArea.append(""+e.getMessage()+"\n");
		updateCount();
	}
	
	public void updateBiggestShape(String s) {
		biggestShapeLabel.setText(s);
		validate();
	}
	
	public void updateCount() {
		count++;
		countLabel.setText(""+count);
		validate();
	}
	
	private JPanel makeExceptionPanel() {
		JPanel jp = new JPanel();
		infoArea = new JTextArea();
		infoArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(infoArea);
		jp.add(scrollPane);
		return jp;
	}
	
	private JPanel makeStatPanel() {
		JPanel jp = new JPanel();
		countLabel = new JLabel();
		biggestShapeLabel = new JLabel();
		JLabel countLabelDesc = new JLabel("Figure non disegnate: ");
		JLabel biggestShapeLabelDesc = new JLabel("Figura più grande: ");
		jp.add(countLabelDesc);
		jp.add(countLabel);
		jp.add(biggestShapeLabelDesc);
		jp.add(biggestShapeLabel);
		return jp;
	}
	
}
