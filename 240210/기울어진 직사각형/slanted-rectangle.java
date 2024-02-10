import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main
{
    static int dir = 4;
    static int max_num = 20;
    static int n;
    static int[][] list = new int[max_num][max_num];
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=1;k<n;k++){
                    for(int l=1;l<n;l++){
                        ans = Math.max(ans, getScore(i,j,k,l));
                    }
                }
            }
        }

        System.out.print(ans);
        br.close();
    }
    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    static int getScore(int x, int y, int k, int l){
        int[] dx = new int[]{-1, -1, 1, 1};
        int[] dy = new int[]{1, -1, -1, 1};
        int[] moveNum = new int[]{k, l, k, l};

        int sumOfNums = 0;

        for(int d = 0; d < dir; d++)
            for(int q = 0; q < moveNum[d]; q++) {
                x += dx[d]; y += dy[d];
                if(!inRange(x, y))
                    return 0;
                sumOfNums += list[x][y];
            }
        return sumOfNums;
    }
}