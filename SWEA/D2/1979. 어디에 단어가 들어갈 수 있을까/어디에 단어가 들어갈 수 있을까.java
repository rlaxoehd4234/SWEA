import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static int[] dx = {0, 1};
	public static int[] dy = {1, 0};
	public static int[][] arr;
	public static int N, length;
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	} 
	public static int searchWidth(Point point) {
		int result = 0;
		for(int i = 0; i < N; i++) {
			int nextX = point.x ;
			int nextY = point.y + i;
			if(nextY > 0 && nextY <= N) {
				if(arr[nextX][nextY] == 0) {
					break;
				}else {
					result++;
				}
			}
		}
		
		return result;
	}
	public static int searchHeight(Point point) {
		int result = 0;
		for(int i = 0; i < N; i++) {
			int nextX = point.x + i;
			int nextY = point.y;
			if(nextX > 0 && nextX <= N) {
				if(arr[nextX][nextY] == 0) {
					break;
				}else {
					result++;
				}
			}
		}
		return result;
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for(int i = 1; i <= test_case; i++) {
			int total = 0;
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			length = Integer.parseInt(st.nextToken());
			arr = new int[N+1][N+1];
			
			for(int k = 1; k<=N; k++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <=N; j++) {
					arr[k][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k = 1 ; k < arr.length; k++) {
				for(int j = 1; j < arr.length; j++) {
					if(arr[k][j-1] != 1 && arr[k][j] == 1) {
						int resultWidth = searchWidth(new Point(k,j));
						if(resultWidth == length) {
							total++;
						}
					}
					if(arr[k-1][j] != 1 && arr[k][j] == 1) {
						int resultHeight = searchHeight(new Point(k,j));
						if(resultHeight == length) {
							total++;
						}
					}
				}
			}
//			
			System.out.println("#" + i + " " + total);
			}		
	}	
}