import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] list;
    static int max_count, m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n][m];
        max_count = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                find(j, i, 1, 0);
            }
        }
        System.out.print(max_count);
    }
    public static void find(int x, int y, int index, int sum){
        sum += list[y][x];
        if(index >= 3){
            if(max_count < sum){
                max_count = sum;
            }
            return;
        }

        if(x+1 < m){
            find(x+1, y, index+1, sum);
        }
        if(x-1 >= 0){
            find(x-1, y, index+1, sum);
        }
        if(y+1 < n){
            find(x, y+1, index+1, sum);
        }

    }
}