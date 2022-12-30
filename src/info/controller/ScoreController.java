package info.controller;

import java.util.ArrayList;
import java.util.Scanner;

import info.view.ScoreView;
import info.vo.ScoreDAO;
import info.vo.ScoreVO;

public class ScoreController {
	
	public final int CONTINUE = 1;
	public final int BREAK = 2;
	
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Integer> grades = new ArrayList<Integer>();
	ArrayList<Integer> classrooms = new ArrayList<Integer>();
	ArrayList<Integer> stulds = new ArrayList<Integer>();
	ArrayList<Integer> koreas = new ArrayList<Integer>();
	ArrayList<Integer> maths = new ArrayList<Integer>();
	ArrayList<Integer> englishes = new ArrayList<Integer>();
	ArrayList<Integer> sciences = new ArrayList<Integer>();
	ArrayList<Integer> totals = new ArrayList<Integer>();
	ArrayList<Integer> avgs = new ArrayList<Integer>();
	
	public void ConsoleToList() {
		
		Scanner s1 = new Scanner(System.in);		//String
		Scanner s2 = new Scanner(System.in);		//integer
		
		int flag = CONTINUE;
		
		while (true) {
			if (flag == CONTINUE) {
				
				System.out.println("[학생 성적 정보 입력]");
				System.out.println(" ");
				
				System.out.print("이름 : ");
				names.add(s1.next());
				System.out.println(" ");
				
				System.out.print("학년 : ");
				grades.add(s2.nextInt());
				System.out.println(" ");
				
				System.out.print("반 : ");
				classrooms.add(s2.nextInt());
				System.out.println(" ");
				
				System.out.print("학번 : ");
				stulds.add(s2.nextInt());
				System.out.println(" ");
				
				System.out.print("국어 : ");
				koreas.add(s2.nextInt());
				System.out.println(" ");
				
				System.out.print("수학 : ");
				maths.add(s2.nextInt());
				System.out.println(" ");
				
				System.out.print("영어 : ");
				englishes.add(s2.nextInt());
				System.out.println(" ");
				
				System.out.print("과학 : ");
				sciences.add(s2.nextInt());
				System.out.println(" ");
				
			} else if (flag == BREAK) {
				break;
			}
			System.out.println(" ");
			System.out.println("[더 많은 성적 정보를 입력하시겠습니까?]");
			System.out.println("입력 : 1 | 종료 : 2");
			System.out.print("입력 : ");
			flag = s2.nextInt();
		}
		
		s1.close();
		s2.close();
		
	}
	
	public void voToDAO (ScoreDAO dao) {
		
		for (int i=0; i<names.size(); i++) {
			ScoreVO scorelist = new ScoreVO(names.get(i), grades.get(i), classrooms.get(i), stulds.get(i), koreas.get(i), maths.get(i), englishes.get(i), sciences.get(i), totals.get(i), avgs.get(i));
			dao.insert(scorelist);
		}
		
	}
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		ScoreController controller = new ScoreController();
		
		controller.ConsoleToList();
		
		ScoreDAO dao = new ScoreDAO();
		controller.voToDAO(dao);
		
		ScoreView sview = new ScoreView();
		sview.view(dao.select());
		
	}
	
	

}
