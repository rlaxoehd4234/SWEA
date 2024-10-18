import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int number = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= number; i++) {
			st = new StringTokenizer(br.readLine());
			int firstTime = Integer.parseInt(st.nextToken());
			int firstMinute = Integer.parseInt(st.nextToken());
			int secondTime = Integer.parseInt(st.nextToken());
			int secondMinute = Integer.parseInt(st.nextToken());
			
			int totalTime = firstTime + secondTime;
			int totalMinute = firstMinute + secondMinute;
			if(totalMinute >= 60) {
				totalMinute -=60;
				totalTime+=1;
			}
			if(totalTime>=12 && totalTime <24) {
				totalTime-=12;
			}
			if(totalTime>12 && totalTime >=24) {
				totalTime-=12;
			}
			System.out.println("#"+i+" "+totalTime +" "+totalMinute);
		}
		
	}

}
