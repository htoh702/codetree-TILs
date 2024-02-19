import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static char[][] maze;
    static int[] dir_x = {0, -1, 0, 1};
    static int[] dir_y = {1, 0, -1, 0};
    static int x,y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int start_x = Integer.parseInt(st.nextToken());
        int start_y = Integer.parseInt(st.nextToken());

        x = start_x;
        y = start_y;

        maze = new char[n+2][n+2];
        for(int i=0;i<=n+1;i++){
            maze[0][i] = '.';
        }
        for(int i=1;i<=n;i++){
            maze[i][0] = '.';
            String str = br.readLine();
            for(int j=1;j<=n;j++){
                maze[i][j] = str.charAt(j-1);
            }
            maze[i][n+1] = '.';
        }
        for(int i=0;i<=n+1;i++){
            maze[n+1][i] = '.';
        }

        int dir = 0;
        int cnt=0;
        boolean is_p=true;

        while(true){
            if(x<=0 || x>n || y<=0 || y>n){
                break;
            }
            dir = checked(dir);
            if(dir<0){
                is_p=false;
                break;
            }
            x += dir_x[dir];
            y += dir_y[dir];
            cnt++;
            if(x == start_x && y == start_y){
                is_p = false;
                break;
            }
        }

        

        if(is_p){
            System.out.print(cnt);
        }else{
            System.out.print(-1);
        }
        br.close();
    }

    public static int checked(int dir){
        if(maze[x+dir_x[(dir+3)%4]][y+dir_y[(dir+3)%4]] == '.'){
            return (dir+3)%4;
        }else if(maze[x+dir_x[dir]][y+dir_y[dir]] == '.'){
            return dir;
        }else if(maze[x+dir_x[(dir+1)%4]][y+dir_y[(dir+1)%4]] == '.'){
            return (dir+1)%4;
        }else if(maze[x+dir_x[(dir+2)%4]][y+dir_y[(dir+2)%4]] == '.'){
            return (dir+2)%4;
        }else{
            return -1;
        }
    }
}