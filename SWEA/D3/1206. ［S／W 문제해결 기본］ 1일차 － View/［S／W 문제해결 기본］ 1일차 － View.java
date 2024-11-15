
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++) {
			int construct = Integer.parseInt(br.readLine());
			int[] arr = new int[construct+4];
			int total = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 2; i < construct; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 2; i < construct; i++) {
				int[] height = new int[4];
				height[0] = arr[i+1] - arr[i];  
				height[1] = arr[i+2] - arr[i];
				height[2] = arr[i-2] - arr[i];
				height[3] = arr[i-1] - arr[i];
				int max = Integer.MAX_VALUE;
				
				// 오른쪽 2칸 검증, 양수일 경우 0
				if(height[0] < 0 && height[1] < 0 && height[2] < 0 && height[3] < 0) {
					for(int k = 0; k < height.length; k++) {
						max = Math.min(max, Math.abs(height[k]));
					}
					total += max;
					max = 0;
				}
			}
		System.out.println("#" + test_case +" " +total);
		}

	}

}
