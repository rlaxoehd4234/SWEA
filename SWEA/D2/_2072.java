package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2072 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < testCase+1; i++) {
			int totalScore = 0;
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j ++) {
				int score = Integer.parseInt(st.nextToken());
				if(score%2 != 0) {
					totalScore += score;
				}
			}
			System.out.println("#" + i + " " + totalScore);
		}

	}

}
