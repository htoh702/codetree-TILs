import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n > 1){
            if(n%2==0){
                n = n/2;
            }else{
                n = n*3+1;
            }
            count++;
        }
        System.out.println(count);
    }
}