import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int max_value, n;
    static int[][] list;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        list = new int[n][n];
        max_value = 0;
        set = new HashSet<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0,0);

        System.out.print(max_value);
        br.close();
    }
    public static void find(int y, int total){
        if(y >= n){
            if(total > max_value){
                max_value = total;
            }
            return;
        }

        for(int x=0;x<n;x++){
            if(!set.contains(x)){
                total += list[y][x];
                set.add(x);
                find(y+1, total);
                total -= list[y][x];
                set.remove(x);
            }

        }
    }
}