import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
		
	public static int N,M,firstN,secondN;
	public static int[][] arr;
	public static int[] dist;
	
	
	public static void bfs(int start, int goal) {
		Queue<Integer> qu = new LinkedList<>();
		qu.offer(start);
		
		while(!qu.isEmpty()) {
			int temp = qu.poll();
			if(temp == goal) {
				break;
			}
			for(int i = 1; i <= N; i++) {
				if(arr[temp][i] == 1 && dist[i] == 0) {
					qu.offer(i);
					dist[i] = dist[temp] +1;
				}
			}
			
		}
		
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		firstN = Integer.parseInt(st.nextToken());
		secondN = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		dist = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		bfs(firstN, secondN);
		System.out.println(dist[secondN] == 0 ? -1 : dist[secondN]);
		
		
	}

}
