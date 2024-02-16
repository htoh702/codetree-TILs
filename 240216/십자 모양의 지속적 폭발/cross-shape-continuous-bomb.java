import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] list;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++){
            int num = Integer.parseInt(br.readLine());
            boom(num-1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(list[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
    public static void boom(int x){
        int sum = 0;
        while(list[sum][x] == 0){
            sum ++;
            if(sum >= n){
                return;
            }
        }
        int dump = list[sum][x];
        for(int i=x;i>x-dump;i--){
            if (i<0){
                break;
            }
            list[sum][i] = 0;
        }
        for(int i=x;i<x+dump;i++){
            if(i>=n){
                break;
            }
            list[sum][i] = 0;
        }
        for(int i=sum;i<sum+dump;i++){
            if(i>=n){
                break;
            }
            list[i][x] = 0;
        }

        gravity();
    }

    public static void gravity(){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int j=0;j<n;j++){
            deque.clear();
            for(int i=n-1;i>=0;i--){
                if(list[i][j] !=0){
                    deque.add(list[i][j]);
                    list[i][j]=0;
                }
            }
            for(int i=n-1;i>=0;i--){
                if(deque.isEmpty()){
                    break;
                }
                list[i][j] = deque.poll();
            }
        }
    }
}