import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, H;
	public static int[][][] arr;
	public static Queue<Point> qu;
	
	
	public static int[] dh = {-1, 1, 0, 0, 0, 0};
	public static int[] dx = {0, 0, 0, 0, 1, -1};
	public static int[] dy = {0, 0, -1, 1, 0, 0};
	
	
	public static void bfs() {
		while(!qu.isEmpty()) {
			Point temp = qu.poll();
			for(int i = 0; i < 6; i++) {
				int nextH = temp.h + dh[i];
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];
				
				if(nextH >= 0 && nextX >= 0 && nextY >= 0 && nextH < H && nextX < M && nextY < N ) {
					if(arr[nextH][nextX][nextY] == 0) {
						qu.offer(new Point(nextH, nextX, nextY));
						arr[nextH][nextX][nextY] = arr[temp.h][temp.x][temp.y] + 1;
					}
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][M][N];
		qu = new LinkedList<Point>();
		
		
		for(int h = 0; h < H; h++) {
			for(int x = 0; x < M; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y = 0; y < N; y++) {
					arr[h][x][y] = Integer.parseInt(st.nextToken());
					if(arr[h][x][y] == 1) {
						qu.offer(new Point(h,x,y));
						}
				}
			}
		}
		bfs();
		int result = Integer.MIN_VALUE;
		loop:
		for(int h = 0; h < H; h++) {
			for(int x = 0; x < M; x ++) {
				for(int y = 0; y < N; y++) {
					if(arr[h][x][y] == 0) {
						result = -1;
						break loop;
					}else {
						result = Math.max(result, arr[h][x][y]);
					}
					
				}
			}
		}
		if(result == -1) {
			System.out.println(result);
		}else{
			System.out.println(result-1);
		}
		
	}
	
	static class Point{
		int h;
		int x;
		int y;
		
		Point(int h, int x, int y){
			this.h = h;
			this.x = x;
			this.y = y;
		}
	}
}
