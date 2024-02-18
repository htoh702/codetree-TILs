import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main
{
    static int n, m, end;
    static int[] number;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        end = n;
        number = new int[n+1];

        for(int i=0;i<n;i++){
            number[i] = Integer.parseInt(br.readLine());
        }
        number[n] = 0;

        boom();

        StringBuilder sb = new StringBuilder();
        sb.append(end).append("\n");
        for(int i=0;i<end;i++){
            sb.append(number[i]).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    static void boom(){
        int cnt=0;
        int sum=-1;
        int check = 0;
        for(int i=0;i<=end;i++){
            if(sum == number[i]){
                cnt++;
            }else{
                if(cnt >= m){
                    for(int j=1;j<cnt+1;j++){
                        number[i-j] = 0;
                    }
                    check=1;
                }
                sum = number[i];
                cnt = 1;
            }
        }
        move();
        if(check!=0){
            boom();
        }
    }

    static void move(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<=end;i++){
            if(number[i] != 0){
                queue.add(number[i]);
            }
        }
        end = queue.size();
        for(int i=0;i<end;i++){
            number[i] = queue.poll();
        }
        number[end] = 0;
    }
}