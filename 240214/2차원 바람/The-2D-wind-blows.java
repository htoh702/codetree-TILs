import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] list;
    static int n, m, q;
    static Deque<Integer> deque = new ArrayDeque<>();

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
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            wind(r1-1, c1-1, r2-1, c2-1);
            round(r1-1, c1-1, r2-1, c2-1);
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
    public static void wind(int r1, int c1, int r2, int c2){
        int sum = list[r1][c1];
        for(int i=r1;i<r2;i++){
            list[i][c1] = list[i+1][c1];
        }
        for(int i=c1;i<c2;i++){
            list[r2][i] = list[r2][i+1];
        }
        for(int i=r2;i>r1;i--){
            list[i][c2] = list[i-1][c2];
        }
        for(int i=c2;i>c1;i--){
            list[r1][i] = list[r1][i-1];
        }
        list[r1][c1+1] = sum;
    }

    public static void round(int r1, int c1, int r2, int c2){
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                deque.add(avg(i, j));
            }
        }

        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                if(deque.isEmpty()){
                    continue;
                }
                list[i][j] = deque.poll();
            }
        }
    }
    public static int avg(int y, int x){
        int total = list[y][x];
        int cnt = 1;
        if(x+1 < m){
            total += list[y][x+1];
            cnt++;
        }
        if(x-1 >= 0){
            total += list[y][x-1];
            cnt++;
        }
        if(y+1 < n){
            total += list[y+1][x];
            cnt++;
        }
        if(y-1 >= 0){
            total += list[y-1][x];
            cnt++;
        }
        return total/cnt;
    }
}