import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int[][] arr;
	public static boolean[][] visited;
	public static int N;
	public static int result = 0;
	public static int count = 0;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static void dfs(int x, int y) {
		arr[x][y] = 0;
		result +=1;
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if(arr[nextX][nextY] == 1 ) {
					dfs(nextX,nextY);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N; i++) {
			String data = br.readLine();
			for(int k = 0; k < N; k++) {
				arr[i][k] = data.charAt(k) - '0';
			}
		}
		
		
		
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int k = 0; k < N; k++) {
				result = 0;
				if(arr[i][k] == 1) {
					dfs(i,k);
					list.add(result);
					count++;
				}
			}
		}	
		
		Collections.sort(list);
		System.out.println(count);
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
