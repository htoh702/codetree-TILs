import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<node> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int del_no = -1;

        for(int i=0;i<n;i++){
            int sum = Integer.parseInt(br.readLine());

            if(del_no == sum){
                continue;
            }

            if(deque.isEmpty()){
                node no = new node(sum, 1);
                deque.add(no);
            }else{
                node sum_no = deque.pollLast();
                if(sum_no.value == sum){
                    sum_no.count=sum_no.count+1;
                    if(sum_no.count >= m){
                        del_no = sum;
                    }
                }else{
                    node new_no = new node(sum, 1);
                    deque.add(sum_no);
                    deque.add(new_no);
                }
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        while(!deque.isEmpty()){
            node n1 = deque.pollFirst();
            for(int i=0;i<n1.count;i++){
                sb.append(n1.value).append("\n");
            }
            cnt += n1.count;
        }

        System.out.println(cnt);
        System.out.print(sb);



        br.close();
    }
}

class node{
    int value;
    int count;
    public node(int value, int count){
        this.value = value;
        this.count = count;
    }
}