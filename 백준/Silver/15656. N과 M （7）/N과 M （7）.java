import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] mainArr;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int n, int m, int depth) {
		if(depth == m) {
			for(int value : arr) {
				sb.append(value).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < mainArr.length; i ++) {
			arr[depth] = mainArr[i];
			dfs(n,m,depth+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		mainArr = new int[n];
		arr = new int[m];
		for(int i = 0; i < n; i++) {
			mainArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(mainArr);
		dfs(n,m,0);
		System.out.println(sb);

	}

}
