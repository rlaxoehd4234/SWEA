import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= number; i++) {
			String putValue = br.readLine();
			char[] arr = putValue.toCharArray();
			char[] inspectionArr = Arrays.copyOf(arr, arr.length);
			char temp = ' ';
			for(int k = 0; k < arr.length/2; k++) {
				temp = inspectionArr[k];
				inspectionArr[k] = inspectionArr[inspectionArr.length-1-k];
				inspectionArr[inspectionArr.length-1-k] = temp; 
			}
			if(Arrays.equals(arr, inspectionArr)) {
				System.out.println("#"+ i +" 1" );
			}else {
				System.out.println("#"+ i +" 0" );
			}
		}

	}

}
