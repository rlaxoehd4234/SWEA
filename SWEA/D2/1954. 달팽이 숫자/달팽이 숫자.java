import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static int[][] arr;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int N;

	public static void draw(int x, int y, int start, int dir) {
		arr[x][y] = start;
		
		if(start == N * N) return;
		
		
		int nextX = x + dx[dir];
		int nextY = y + dy[dir];
		
		if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || arr[nextX][nextY] != 0) {
			dir = (dir + 1) % 4;
			nextX = x + dx[dir];
			nextY = y + dy[dir];
		}
		
		draw(nextX, nextY, start+1, dir);
}
						
		

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= number; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr= new int[N][N];
			
			draw(0,0,1,0);
			System.out.println("#"+test_case);
			for(int i = 0; i < N; i++){
				for(int k = 0; k < N; k++) {
					System.out.print(arr[i][k] +" ");
				}
				System.out.println();
			}
			
		}

	}

}
