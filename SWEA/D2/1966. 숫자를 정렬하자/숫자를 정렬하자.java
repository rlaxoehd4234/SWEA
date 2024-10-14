import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i <= number; i++) {
			int putValue = Integer.parseInt(br.readLine());
			int[] arr = new int[putValue];
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k< putValue; k++) {
				arr[k] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			System.out.print("#" + i + " ");
			for(int j = 0; j< arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
			
		}

	}

}
