package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class JPainelGradient  extends JPanel{

	private int width;
	private int height;
	private Color color1;
	private Color color2;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		width = getWidth();
		height = getHeight();
		color1 = Color.decode("#2b5876");
		color2 = Color.decode("#4e4376");
		
		// Criando o gradiente
		GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, width, height);
	}
}
