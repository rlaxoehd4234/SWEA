import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	private final static String[] GRADE = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int number = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=number; i++) {
			st = new StringTokenizer(br.readLine());
			int total = Integer.parseInt(st.nextToken());
			int searchStudent = Integer.parseInt(st.nextToken());
			List<Student> list = new ArrayList<>();
			int count = 0;
			for(int k = 0; k < total; k++) {
				st = new StringTokenizer(br.readLine());
				Student student = new Student(k+1);
				list.add(student);
				for(int j = 0; j < 3; j++) {
					if(j == 0) {
						student.totalScore += (Double.parseDouble(st.nextToken())*0.35);
					}else if(j == 1) {
						student.totalScore += (Double.parseDouble(st.nextToken())*0.45);
					}else {
						student.totalScore += (Double.parseDouble(st.nextToken())*0.2);
					}
					
				}
			}
			
			Collections.sort(list);
			
			for(int m = 0; m < list.size(); m++) {
				if(m % (total/10) == 0 && m!= 0) {
					count++;
				}
				list.get(m).grade = GRADE[count%10];
			}
			
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j).number == searchStudent) {
					System.out.println("#"+ i + " " + list.get(j).grade);
					break;
				}
			}
		}	
	}
	
	static class Student implements Comparable<Student>{
		Student(int number){
			this.number = number;
		}
		int number;
		double totalScore;
		String grade;
		
		@Override
		public int compareTo(Student o) {
			if(this.totalScore < o.totalScore) {
				return 1;
			}else if (this.totalScore == o.totalScore) {
				return 0;
			}else
			return -1;
		}
	}

}
