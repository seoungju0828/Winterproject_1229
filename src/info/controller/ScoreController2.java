package info.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import info.view.ScoreView2;
import info.vo.ScoreDAO;
import info.vo.ScoreVO;

public class ScoreController2 extends JFrame {
	
	ScoreDAO dao;
	ArrayList<ScoreVO> scoreVOList;
	ScoreView2 view2;
	JTable table;
	
	public ScoreController2() {
		
		dao = new ScoreDAO();
		view2 = new ScoreView2();
		scoreVOList = dao.select();
		view2.setScoreVOList(scoreVOList);
		view2.initView();
		
		JButton btnAdd = view2.getBtnAdd();
		btnAdd.addActionListener(btnAddL);
		
		table = view2.getTable();
		table.addMouseListener(tableL);
		
		add(view2, "Center");
		
		setTitle("[학생 성적 처리 시스템]");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(600, 500);
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		new ScoreController2();
		
	}
	
	ActionListener btnAddL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ScoreVO vo = view2.neededInsertData();
			dao.insert(vo);
			scoreVOList = dao.select();
			
			view2.setScoreVOList(scoreVOList);
			view2.putResult();
			view2.initInsertData();
		}
		
	};
	
	MouseAdapter tableL = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int state = 1;
			
			if (e.getClickCount() == 2) {
				state = JOptionPane.showConfirmDialog(ScoreController2.this, "정말 삭제하시겠습니까?", "삭제여부", JOptionPane.YES_NO_OPTION);
				if (state == JOptionPane.YES_OPTION) {
					dao.delete(table.getSelectedRow());
					scoreVOList = dao.select();
					view2.setScoreVOList(scoreVOList);
					view2.putResult();
				}
			}
		}
	};

}
