import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] list;
    static int n, m, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        list = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            wind(r, d);
            move(r-1, d, -1);
            move(r+1, d, 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(list[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    public static void move(int r, char d, int mov){
        if(r-1<0 || r-1>=n || move_check(r, mov)){
            return;
        }
        char mov_s = 'L';
        if(d == 'L'){
            mov_s = 'R';
        }
        wind(r, mov_s);
        move(r+mov, mov_s, mov);
    }

    public static boolean move_check(int r, int mov){
        if(r-1 < 0 || r-1 >= n){
            return true;
        }
        for(int i=0;i<m;i++){
            if(list[r-1][i] == list[r-1-mov][i]){
                return false;
            }
        }
        return true;
    }

    public static void wind(int r, char d){
        int sum;
        if(d == 'L'){
            sum = list[r-1][m-1];
            for(int i=m-1;i>0;i--){
                list[r-1][i] = list[r-1][i-1];
            }
            list[r-1][0] = sum;
        }else if(d == 'R'){
            sum = list[r-1][0];
            for(int i=0;i<m-1;i++){
                list[r-1][i] = list[r-1][i+1];
            }
            list[r-1][m-1] = sum;
        }
    }
}