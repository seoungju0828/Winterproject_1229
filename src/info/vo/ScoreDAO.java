package info.vo;

import java.util.*;

public class ScoreDAO {
	
	ArrayList<ScoreVO> scorelist = new ArrayList<ScoreVO>();
	
	public void insert(ScoreVO dao) {
		scorelist.add(dao);
	}
	
	public void delete(int row) {
		scorelist.remove(row);
	}
	
	public ArrayList<ScoreVO> select() {
		return scorelist;
	}

}
