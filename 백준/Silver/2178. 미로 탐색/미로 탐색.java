import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	public static int N,M;
	
	
	public static void bfs(int x, int y) {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(x,y));
		
		while(!qu.isEmpty()) {
			Point point = qu.poll();
			for(int i = 0; i <4; i++) {
				int nextX = point.x + dx[i];
				int nextY = point.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				if(visited[nextX][nextY] || arr[nextX][nextY] == 0) {
					continue;
				}
				
				qu.add(new Point(nextX, nextY));
				arr[nextX][nextY] = arr[point.x][point.y] + 1;
				visited[nextX][nextY] = true;
				
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int k = 0; k < M; k++) {
				arr[i][k] = Integer.parseInt(String.valueOf(data.charAt(k)));
			}
		}
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}		
}

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}