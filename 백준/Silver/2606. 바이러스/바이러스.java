import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N,M;
	public static int[][] arr;
	public static boolean[] visited;
	public static int result = 0;
	
	public static void dfs(int index) {
		visited[index] = true;
		result +=1;
		
		for(int i = 1; i <= N; i++) {
			if(arr[index][i] == 1 && !visited[i])
			dfs(i);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());		
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(1);
		System.out.println(result-1);

	}

}
