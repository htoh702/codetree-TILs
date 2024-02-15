import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] list = new int[4][4];
    static Deque<Integer> qu = new ArrayDeque<>();
    static int check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String dir = br.readLine();

        if(dir.equals("L")){
            move_l();
        }else if(dir.equals("R")){
            move_r();
        }else if(dir.equals("U")){
            move_u();
        }else if(dir.equals("D")){
            move_d();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                sb.append(list[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
    public static void move_l(){
        for(int i=0;i<4;i++){
            qu.clear();
            check = 0;
            for(int j=0;j<4;j++){
                if(list[i][j]==0){
                    continue;
                }
                if(qu.isEmpty()){
                    qu.add(list[i][j]);
                    continue;
                }
                int sum = qu.pollLast();
                if(sum == list[i][j] && check != 1){
                    qu.add(list[i][j]*2);
                    check = 1;
                }else{
                    qu.add(sum);
                    qu.add(list[i][j]);
                    check = 0;
                }
            }

            for(int j=0;j<4;j++){
                if(qu.isEmpty()){
                    list[i][j]=0;
                }else{
                    list[i][j]= qu.poll();
                }
            }
        }
    }
    public static void move_r(){
        for(int i=0;i<4;i++){
            qu.clear();
            check = 0;
            for(int j=3;j>=0;j--){
                if(list[i][j]==0){
                    continue;
                }
                if(qu.isEmpty()){
                    qu.add(list[i][j]);
                    continue;
                }
                int sum = qu.pollLast();
                if(sum == list[i][j] && check != 1){
                    qu.add(list[i][j]*2);
                    check = 1;
                }else{
                    qu.add(sum);
                    qu.add(list[i][j]);
                    check = 0;
                }
            }

            for(int j=3;j>=0;j--){
                if(qu.isEmpty()){
                    list[i][j]=0;
                }else{
                    list[i][j]= qu.poll();
                }
            }
        }
    }
    public static void move_u(){
        for(int j=0;j<4;j++){
            qu.clear();
            check = 0;
            for(int i=0;i<4;i++){
                if(list[i][j]==0){
                    continue;
                }
                if(qu.isEmpty()){
                    qu.add(list[i][j]);
                    continue;
                }
                int sum = qu.pollLast();
                if(sum == list[i][j] && check != 1){
                    qu.add(list[i][j]*2);
                    check = 1;
                }else{
                    qu.add(sum);
                    qu.add(list[i][j]);
                    check = 0;
                }
            }

            for(int i=0;i<4;i++){
                if(qu.isEmpty()){
                    list[i][j]=0;
                }else{
                    list[i][j]= qu.poll();
                }
            }
        }
    }
    public static void move_d(){
        for(int j=0;j<4;j++){
            qu.clear();
            check = 0;
            for(int i=3;i>=0;i--){
                if(list[i][j]==0){
                    continue;
                }
                if(qu.isEmpty()){
                    qu.add(list[i][j]);
                    continue;
                }
                int sum = qu.pollLast();
                if(sum == list[i][j] && check != 1){
                    qu.add(list[i][j]*2);
                    check = 1;
                }else{
                    qu.add(sum);
                    qu.add(list[i][j]);
                    check = 0;
                }
            }

            for(int i=3;i>=0;i--){
                if(qu.isEmpty()){
                    list[i][j]=0;
                }else{
                    list[i][j]= qu.poll();
                }
            }
        }
    }
}