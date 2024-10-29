import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int[] mainArr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static HashSet<String> set = new HashSet<>();
	
	public static void dfs(int n, int m, int depth) {
		if(depth == m) {
			String result = "";
			for(int value : arr) {
				result += String.valueOf(value) + " ";
			}
			if(set.contains(result) == false) {
				sb.append(result);
				set.add(result);
				sb.append('\n');	
			}
			return;
		}
		
		for(int i = 0 ; i < mainArr.length; i++) {
			if(!visit[i]) {
					visit[i] = true;
					arr[depth] = mainArr[i];
					dfs(n,m,depth+1);
					visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		mainArr = new int[n];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i ++) {
			int value = Integer.parseInt(st.nextToken());
			mainArr[i] = value;
		} 
		Arrays.sort(mainArr);
		
		dfs(n,m,0);
		System.out.println(sb);
	}

}
