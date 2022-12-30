package info.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import info.vo.ScoreDAO;
import info.vo.ScoreVO;

public class ScoreView2 extends JPanel {
	
	JTable table;
	DefaultTableModel model;
	ArrayList<ScoreVO> scoreVOList;
	ScoreDAO dao;
	String[] header = {"이름", "학년", "반", "학번", "국어 점수", "수학 점수", "영어 점수", "과학 점수", "점수 총합", "점수 평균"};
	
	JPanel panS;
	JComboBox<String> categoryCombo;
	JLabel[] lb1s = new JLabel[header.length-2];
	JTextField[] tf = new JTextField[header.length-2];
	JButton btnAdd = new JButton("성적 추가");
	
	public ScoreView2() {
		
		setLayout(new BorderLayout());
		
		panS = new JPanel(new GridLayout(5, 4));
		
		for (int i=0; i<lb1s.length; i++) {
			lb1s[i] = new JLabel(header[i]);
			panS.add(lb1s[i]);
			
			
			if (i<header.length - 1) {
				tf[i] = new JTextField();
				panS.add(tf[i]);
			} else {
				panS.add(categoryCombo);
			}
			
		}
		
		for (int i=0; i<3; i++) {
			panS.add(new JLabel("   "));
		}
		panS.add(btnAdd);
	}
	
	public void initView() {
		model = new DefaultTableModel(header, scoreVOList.size()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		JScrollPane scroll = new JScrollPane(table);
		
		putResult();
		
		add("Center", scroll);
		add("South", panS);
	}
	
	public void putResult() {
		model.setRowCount(scoreVOList.size());
		ScoreVO vo = null;
		
		for (int i=0; i<scoreVOList.size(); i++) {
			vo = scoreVOList.get(i);
			
			model.setValueAt(vo.getName(), i, 0);
			model.setValueAt(vo.getGrade(), i, 1);
			model.setValueAt(vo.getClassroom(), i, 2);
			model.setValueAt(vo.getStuld(), i, 3);
			model.setValueAt(vo.getKorea(), i, 4);
			model.setValueAt(vo.getMath(), i, 5);
			model.setValueAt(vo.getEnglish(), i, 6);
			model.setValueAt(vo.getScience(), i, 7);
			model.setValueAt(vo.getTotal(), i, 8);
			model.setValueAt(vo.getAvg(), i, 9);
		}
	}
	
	public void setScoreVOList(ArrayList<ScoreVO> scoreVOList) {
		this.scoreVOList = scoreVOList;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public ScoreVO neededInsertData() {
		ScoreVO vo = new ScoreVO();
		
		vo.setName(tf[0].getText());
		vo.setGrade(Integer.parseInt(tf[1].getText()));
		vo.setClassroom(Integer.parseInt(tf[2].getText()));
		vo.setStuld(Integer.parseInt(tf[3].getText()));
		vo.setKorea(Integer.parseInt(tf[4].getText()));
		vo.setMath(Integer.parseInt(tf[5].getText()));
		vo.setEnglish(Integer.parseInt(tf[6].getText()));
		vo.setScience(Integer.parseInt(tf[7].getText()));
		vo.setTotal();
		vo.setAvg();
		
		return vo;
		
	}
	
	public void initInsertData() {
		for (int i=0; i<tf.length; i++) {
			tf[i].setText(" ");
		}
	}
	
	public JTable getTable() {
		return table;
	}

}
