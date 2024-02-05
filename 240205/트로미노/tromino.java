import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] list = new int[n][m];
        int max_count = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total, a=0, b=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                total = list[i][j] + list[i+1][j] + list[i][j+1] + list[i+1][j+1];
                int min_list = Math.min(list[i][j], Math.min(list[i+1][j], Math.min(list[i][j+1], list[i+1][j+1])));
                if(max_count < total - min_list){
                    max_count = total - min_list;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i+2 < n){
                    a = list[i][j] + list[i+1][j] + list[i+2][j];
                }
                if(j+2 < m){
                    b = list[i][j] + list[i][j+1] + list[i][j+2];
                }
                total = Math.max(a,b);
                if(max_count < total){
                    max_count = total;
                }
            }
        }
        System.out.print(max_count);
    }
}