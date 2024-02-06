import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static final int MAX_NUM = 20;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];

    public static int getArea(int k) {
        return k * k + (k+1) * (k+1);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static int getNumOfGoldInBorder(int row, int col, int k) {
        int numOfGold = 0;
        int[] dx = new int[]{1, 1, -1, -1};
        int[] dy = new int[]{-1, 1, 1, -1};

        if(k == 0)
            return grid[row][col];

        int currX = row - k, currY = col;

        for(int currDir = 0; currDir < 4; currDir++) {
            for(int step = 0; step < k; step++) {
                if(inRange(currX, currY)) {
                    numOfGold += grid[currX][currY];
                }
                currX = currX + dx[currDir];
                currY = currY + dy[currDir];
            }
        }

        return numOfGold;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int gold_cnt=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                int numOfGold = 0;
                for(int k = 0; k <= 2 * (n-1); k++) {
                    numOfGold += getNumOfGoldInBorder(row, col, k);
                    if(numOfGold * m >= getArea(k))
                        gold_cnt = Math.max(gold_cnt, numOfGold);
                }
            }
        }

        System.out.print(gold_cnt);
        br.close();
    }
}