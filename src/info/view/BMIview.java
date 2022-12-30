package info.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import info.vo.BMIVO;

public class BMIview extends JFrame {
	
	JTextField tfWeight, tfHeight;
	double weight, height, bmi;
	String bmiResult;
	JLabel lblIcon;
	JLabel lblResult;
	
	public BMIview() {
		add(new PanelAbove(), "North");
		add(new PanelBelow(), "Center");
		
		setTitle("BMI(Body Measure Index)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(50, 50);
		setSize(400, 600);
		setVisible(true);
	}
	
	class PanelAbove extends JPanel {
		public PanelAbove() {
			setBackground(new Color(204, 204, 255));
			setLayout(new BorderLayout());
			JLabel lblTitle = new JLabel("체질량지수(BMI)",JLabel.CENTER);
			JLabel lblWeight = new JLabel("체중 : ");
			JLabel lblHeight = new JLabel("신장 : ");
			JLabel lblkg = new JLabel("kg : ");
			JLabel lblcm = new JLabel("cm : ");
			JButton btnResult = new JButton("결과 확인");
			tfWeight = new JTextField(15);
			tfHeight = new JTextField(15);
			add(lblTitle, "North");
			JPanel panCenter = new JPanel(new BorderLayout());
			
			JPanel[] pans = new JPanel[3];
			
			for (int i=0; i<pans.length; i++) {
				pans[i] = new JPanel();
			}
			
			panCenter.add(pans[0], "North");
			panCenter.add(pans[1], "Center");
			pans[0].add(lblWeight); pans[0].add(tfWeight); pans[0].add(lblkg);
			pans[1].add(lblHeight); pans[1].add(tfHeight); pans[1].add(lblcm);
			pans[2].add(btnResult);
			
			add(panCenter, "Center");
			add(pans[2], "South");
		}
	}
	
	class PanelBelow extends JPanel {
		public PanelBelow() {
			setBackground(new Color(255, 204, 229));
			setLayout(new BorderLayout());
			
			JLabel lblResult = new JLabel("<html> 당신의 체중은 __kg, 키는 __cm이므로 <br> BMI 지수는 __kg/m 이며, __체중입니다. <html>", JLabel.CENTER);
			Font font = new Font("맑은고딕", Font.BOLD, 20);
			lblResult.setFont(font);
			ImageIcon icon = new ImageIcon("");
			
			lblIcon = new JLabel(icon, JLabel.CENTER);
			add(lblResult, "North");
			add(lblIcon, "Center");
		}
	}
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			BMIVO vo = new BMIVO();
			double weight = Double.parseDouble(tfWeight.getText());
			double height = Double.parseDouble(tfHeight.getText());
			vo.setWeight(weight);
			vo.setHeight(height);
			vo.setBmi();
			String bmiResult = " ";
			ImageIcon icon = null;
			
			if (vo.getBmi() < 18.5) {
				bmiResult = "저";
			}
			else if (vo.getBmi() < 24.9) {
				bmiResult = "정상";
			}
			else if (vo.getBmi() < 29.9) {
				bmiResult = "과";
			}
			else if (vo.getBmi() < 34.9) {
				bmiResult = "비만";
			}
			else {
				bmiResult = "고도";
			}
			lblResult.setText("<html> 당신의 체중은 " + vo.getWeight() + "kg, 키는 " + vo.getHeight() + "cm 이므로, <br> BMI 지수는 " + String.format("%.1f", vo.getBmi()) + "kg / m 이며, " + bmiResult + "체중 입니다");
			lblIcon.setIcon(icon);
		}
	};

}
