import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static final int[] MONEY = {50000,10000,5000,1000,500,100,50,10};
	
	public static int change(int totalMoney, int unit ) {
		return totalMoney%unit;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= number; i ++) {
			int[] result = new int[MONEY.length];
			int totalMoney = Integer.parseInt(br.readLine());
			result[0] = totalMoney/MONEY[0];
			totalMoney = change(totalMoney, MONEY[0]);
			result[1] = totalMoney/MONEY[1];
			totalMoney = change(totalMoney, MONEY[1]);
			result[2] = totalMoney/MONEY[2];
			totalMoney = change(totalMoney, MONEY[2]);
			result[3] = totalMoney/MONEY[3];
			totalMoney = change(totalMoney, MONEY[3]);
			result[4] = totalMoney/MONEY[4];
			totalMoney = change(totalMoney, MONEY[4]);
			result[5] = totalMoney/MONEY[5];
			totalMoney = change(totalMoney, MONEY[5]);
			result[6] = totalMoney/MONEY[6];
			totalMoney = change(totalMoney, MONEY[6]);
			result[7] = totalMoney/MONEY[7];
			
			System.out.println("#"+i+" ");
			for(int k = 0; k< MONEY.length; k++) {
				System.out.print(result[k] +" ");
			}
            System.out.println();
		}

	}

}
