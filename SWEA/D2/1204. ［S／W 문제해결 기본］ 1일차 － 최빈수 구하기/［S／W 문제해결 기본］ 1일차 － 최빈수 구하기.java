import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < number; test_case++) {
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 1000; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[tmp]++;
			}
			int max = 0;
			int index = 0;
			for(int i = 0; i < arr.length; i++) {
				if(max <= arr[i]) {
					index = i;
					max = arr[i];
				}
			}
			
			System.out.println("#" + num + " " + index);
		}

	}

}
