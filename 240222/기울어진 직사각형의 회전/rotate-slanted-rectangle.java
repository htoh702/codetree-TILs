import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main
{
    public static final int CW = 1;
    public static final int CCW = 0;
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] temp = new int[MAX_N][MAX_N];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x, y, m1, m2, m3, m4, d;
        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        m3 = Integer.parseInt(st.nextToken());
        m4 = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        shift(x-1, y-1, m1, m2, d);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }



        br.close();
    }
    public static void shift(int x, int y, int k, int l, int moveDir) {
        int[] dx;
        int[] dy;
        int[] moveNums;

        if(moveDir == CCW) {
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{1, -1, -1, 1};
            moveNums = new int[]{k, l, k, l};
        }
        else {
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{-1, 1, 1, -1};
            moveNums = new int[]{l, k, l, k};
        }


        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                temp[i][j] = grid[i][j];


        for(int d = 0; d < DIR_NUM; d++)
            for(int q = 0; q < moveNums[d]; q++) {
                int nx = x + dx[d], ny = y + dy[d];
                temp[nx][ny] = grid[x][y];
                x = nx; y = ny;
            }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = temp[i][j];
    }


}