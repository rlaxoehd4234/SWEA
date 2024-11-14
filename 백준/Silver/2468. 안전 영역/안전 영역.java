import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int N;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    
    public static void dfs(int x, int y, int depth) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY]) {
                if (arr[nextX][nextY] > depth) {
                    dfs(nextX, nextY, depth);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        visited = new boolean[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][k]); 
            }
        }
        
        int maxSafeArea = 0;

        for (int depth = 0; depth <= maxHeight; depth++) {
            visited = new boolean[N][N]; 
            int safeAreaCount = 0;

            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    if (arr[i][k] > depth && !visited[i][k]) {
                        dfs(i, k, depth);
                        safeAreaCount++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, safeAreaCount);
        }

        System.out.println(maxSafeArea);
    }
}

