package info.view;

import java.util.*;
import info.vo.ScoreVO;

public class ScoreView {
	
	public void view(ArrayList<ScoreVO> scorelist) {
		
		for (ScoreVO scoreVO : scorelist) {
			
			System.out.println("[학생 성적 정보 출력]");
			System.out.println(" ");
			
			System.out.println("이름 : " + scoreVO.getName());
			System.out.println(" ");
			
			System.out.println("학년 : " + scoreVO.getGrade());
			System.out.println(" ");
			
			System.out.println("반 : " + scoreVO.getClassroom());
			System.out.println(" ");
			
			System.out.println("학번 : " + scoreVO.getStuld());
			System.out.println(" ");
			
			System.out.println("국어 점수 : " + scoreVO.getKorea());
			System.out.println(" ");
			
			System.out.println("수학 점수 : " + scoreVO.getMath());
			System.out.println(" ");
			
			System.out.println("영어 점수 : " + scoreVO.getEnglish());
			System.out.println(" ");
			
			System.out.println("과학 점수 : " + scoreVO.getScience());
			System.out.println(" ");
			
			System.out.println("점수 총합 : " + scoreVO.getTotal());
			System.out.println(" ");
			
			System.out.println("점수 평균 : " + scoreVO.getAvg());
			System.out.println(" ");
			
		}
		
	}

}
