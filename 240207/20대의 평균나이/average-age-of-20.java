import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        float total = 0;
        float cnt = 0;
        int sum = Integer.parseInt(br.readLine());
        while(sum  >=20 && sum <30){
            total += sum;
            cnt++;
            sum = Integer.parseInt(br.readLine());
        }

        System.out.print(String.format("%.2f", (total/cnt)));

        br.close();
    }
}