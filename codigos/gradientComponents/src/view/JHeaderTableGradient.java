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

public class JHeaderTableGradient extends DefaultTableCellRenderer{

	public JHeaderTableGradient() {
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.WHITE);
		setOpaque(false);
	}
	
	private Color color1 = new Color(52, 143, 80);
	private Color color2 = new Color(86, 180, 211);
	private int x;
	private int widthCell;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Rectangle celula = table.getCellRect(row, column, true);
		
		// Para que o gradiente seja criando em todo o header, e n�o apenas separado-o por coluna
		x =- celula.x;
		widthCell = table.getWidth() - celula.x;
		return componente;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		// Criando gradiente
		Graphics2D g2d = (Graphics2D) g.create();
		int width = getWidth();
		int height = getHeight();
		GradientPaint gp = new GradientPaint(x, 0, color2, widthCell, 0, color1);		
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, width, height);
		g2d.dispose();
		super.paintComponent(g);
	}
		
}
