package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableGradient extends DefaultTableCellRenderer{

	Color color1;
	Color color2;
	private int x;
	private int widthCell;
	private boolean isSelect;
	private int row;

	public JTableGradient() {
		this(Color.decode("#2b5876"), Color.decode("#4e4376"));
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.WHITE);
	}
	
	public JTableGradient(Color color1, Color color2) {
		super();
		this.color1 = color1;
		this.color2 = color2;
		setOpaque(false);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Rectangle cellRec = table.getCellRect(row, column, true);
		x =- cellRec.x;
		widthCell = table.getWidth()-cellRec.x;
		this.isSelect = isSelected;
		this.row = row;
		return com;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		int width = getWidth();
		int height = getHeight();
		GradientPaint gp;
		
		if(row % 2 == 0){
			color1 = Color.decode("#2b5876");
			color2 = Color.decode("#4e4376");
			
			if(isSelect) {
				color1 = new Color(52, 143, 80);
				color2 = new Color(86, 180, 211);
				gp = new GradientPaint(x, 0, color1, widthCell, 0, color2);			
			}else {
				gp = new GradientPaint(x, 0, color2, widthCell, 0, color1);		
			}
			
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, width, height);
			
		}else {
			
			color1 = Color.decode("#2b5876");
			color2 = Color.decode("#4e4376");
			
			if(isSelect) {
				color1 = new Color(52, 143, 80);
				color2 = new Color(86, 180, 211);
				gp = new GradientPaint(x, 0, color1, widthCell, 0, color2);			
			}else {
				gp = new GradientPaint(x, 0, color1, widthCell, 0, color2);		
			}
			
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, width, height);
					
		}
		
		g2d.dispose();
		super.paintComponent(g);
	}
	
}
