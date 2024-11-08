import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int number = Integer.parseInt(br.readLine());
		
		
		for(int testCase = 1; testCase <= number; testCase++) {
			st = new StringTokenizer(br.readLine());
			int totalDay = 0;
			int baseMonth = Integer.parseInt(st.nextToken());
			int baseDay = Integer.parseInt(st.nextToken());
			int targetMonth = Integer.parseInt(st.nextToken());
			int targetDay = Integer.parseInt(st.nextToken());
			
			if(baseMonth == targetMonth) {
				totalDay = DAYS[targetMonth] + 1 - baseDay;
			}else {
				for(int i = baseMonth; i < targetMonth; i++) {
					totalDay += DAYS[i];
				}
				totalDay = totalDay - baseDay + targetDay + 1;
			}
			System.out.println("#" + testCase + " " + totalDay);
		}

	}

}
