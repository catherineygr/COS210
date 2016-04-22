package edu.mccc.cos210.sp2016.h;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Heart {
	public Heart() {
		JFrame jf= new JFrame("Heart");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(
			new MyJPanel(),
			BorderLayout.CENTER
		);
		jf.pack();
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
	}
	public static void main(String[] sa) {
		EventQueue.invokeLater(Heart::new);
	}
}
