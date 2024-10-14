import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= number; i++) {
			int putValue = Integer.parseInt(br.readLine());
			int totalScore = 0;
			for(int k = 1; k<= putValue; k ++) {
				if(k%2 == 0) {
					totalScore -=k;
				}else {
					totalScore +=k;
				}
			}
			System.out.println("#" + i +" "+totalScore);
		}

	}

}
