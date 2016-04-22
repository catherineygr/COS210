package edu.mccc.cos210.sp2016.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Color PINK_200 = new Color(250, 100, 200, 200);
	private static final Color RED_200 = new Color(230, 0, 50, 200);
	private static final Color DARK_BLUE = new Color(25, 0, 150);
	private static final Color CLEAR = new Color(0, 0, 0, 0);
	private static final Color BLACK_200 = new Color(0, 0, 0, 100);
	private static final Color BLUE_GREEN = new Color(0, 100, 250);
	private static final BasicStroke STROKE_5 = new BasicStroke(5.0f);
	private AffineTransform gat = new AffineTransform();
	private AffineTransform at = new AffineTransform();
	private Shape s = null;
	private double scale = 1.0;
	
	public MyJPanel() {
		setBackground(BLUE_GREEN);
		new Timer(
			1000 / 3,
			ae -> {
				scale = scale < 1.25 ? 1.25 : 1.0;
				repaint();
			}
		).start();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gat = AffineTransform.getTranslateInstance(
			getWidth() / 2.0, 
			getHeight() / 2.0
		);
		gat.scale(1.0, -1.0);
		g2d.transform(gat);

		
		Ellipse2D e2d = new Ellipse2D.Double(
			0.0, 
			0.0, 
			1200.00, 
			1200.00
		);
		at.setToIdentity();
		at.translate(-600.00, -600.00);
		s = at.createTransformedShape(e2d);
		float[] dist = {0.01f, 1.0f};
		Color[] colors = {DARK_BLUE, BLUE_GREEN };
		g2d.setPaint(
			new RadialGradientPaint(
				new Point2D.Float(0,0),
				500.0f,
				dist,
				colors
			)
		);
		g2d.fill(s);
				
		Line2D l2d1 = new Line2D.Double(
			0.0, 
			0.0, 
			150.0, 
			125.0
		);
		at.setToIdentity();
		at.translate(-40, -40);
		at.rotate(Math.toRadians(180));
		s = at.createTransformedShape(l2d1);
		g2d.setStroke(STROKE_5);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		Line2D l2d2 = new Line2D.Double(
			0.0, 
			0.0, 
			10.0, 
			-35.0
		);
		for (int i = 0; i < 21; i++) {
			at.setToIdentity();
			at.translate(-190.0 + 10.0 * (i%10), -165.0 + 8.0 * (i%10));
			if (i<11){	
				at.rotate(Math.toRadians(235));
			}
			s = at.createTransformedShape(l2d2);
			g2d.setStroke(STROKE_5);
			g2d.setPaint(Color.BLACK);
			g2d.draw(s);
		}
		
		Path2D p2d1 = new Path2D.Double();
		for (int s = -1; s <= 1; s += 2) {
			p2d1.moveTo(0.0, 0.0);
			p2d1.curveTo(50.0 * s, 50.0, 175.0 * s, 50.0, 150.0 * s, 150.0);
			p2d1.curveTo(125.0 * s, 230.0, 55.0 * s, 230.0, 0.0, 175.0);
		}
		at.setToIdentity();
		at.scale(scale, scale);
		at.translate(0.0, -100.0);
		s = at.createTransformedShape(p2d1);
		g2d.setPaint(
			new GradientPaint(
				-100, 
				100,
				RED_200,
				100, 
				0, 
				PINK_200	
			)
		);
		g2d.fill(s);
		g2d.setStroke(STROKE_5);
		g2d.setPaint(
			new GradientPaint(
				-100,
				100,
				BLACK_200,
				100,
				0,
				CLEAR	
			)
				
		);
		g2d.draw(s);
		
		at.setToIdentity();
		at.translate(50, 50);
		s = at.createTransformedShape(l2d1);
		g2d.setStroke(STROKE_5);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		Path2D p2d2 = new Path2D.Double();
		p2d2.moveTo(0.0, 0.0);
		p2d2.curveTo(0.0, 0.0, 0.0, -25.0, 10.0, -30.0);
		p2d2.curveTo(0.0, -25.0, 0.0, -25.0, -10.0, -30.0);
		p2d2.curveTo(0.0, -25.0, 0.0, 0.0, 0.0, 0.0);
		at.setToIdentity();
		at.translate(200.0, 175.0);
		at.rotate(Math.toRadians(-50));
		at.scale(2.0, 2.0);
		s = at.createTransformedShape(p2d2);
		g2d.setStroke(
			new BasicStroke(
				3.0f, 
				BasicStroke.CAP_BUTT, 
				BasicStroke.JOIN_MITER
			)
		);
		g2d.setPaint(Color.BLACK);
		g2d.fill(s);
		g2d.draw(s);
				
		g2d.dispose();
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1024, 768);
	}
}
