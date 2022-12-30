package info.vo;

public class ScoreVO {
	
	private String name;
	private int grade;
	private int classroom;
	private int stuld;
	private int korea;
	private int math;
	private int english;
	private int science;
	private double total;
	private double avg;
	
	public ScoreVO() {}

	public ScoreVO(String name, int grade, int classroom, int stuld, int korea, int math, int english, int science,
			double total, double avg) {
		super();
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.stuld = stuld;
		this.korea = korea;
		this.math = math;
		this.english = english;
		this.science = science;
		this.total = total;
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public int getStuld() {
		return stuld;
	}

	public void setStuld(int stuld) {
		this.stuld = stuld;
	}

	public int getKorea() {
		return korea;
	}

	public void setKorea(int korea) {
		this.korea = korea;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = korea + math + english + science;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = total / 4.0;
	}

	@Override
	public String toString() {
		return "ScoreVO [name=" + name + ", grade=" + grade + ", classroom=" + classroom + ", stuld=" + stuld
				+ ", korea=" + korea + ", math=" + math + ", english=" + english + ", science=" + science + ", total="
				+ total + ", avg=" + avg + "]";
	}	

}
