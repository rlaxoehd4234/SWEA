import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int number = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i <= number; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			double total = 0;
			for(int k = 0; k < 10; k++) {
				arr[k] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			for(int j = 1; j <= 8; j++) {
				total += arr[j];
			}
			System.out.println("#"+i+" "+ Math.round(total/8));
		}

	}

}
