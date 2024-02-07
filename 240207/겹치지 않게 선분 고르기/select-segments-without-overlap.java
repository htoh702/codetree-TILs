import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<line> line_list = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            line_list.add(new line(x1, x2));
        }
        HashSet<Integer> set = new HashSet<Integer>();

        Collections.sort(line_list, new Comparator<line>(){
            @Override
            public int compare(line o1, line o2){
                if(o1.x2 == o2.x2){
                    return o1.x1 - o2.x1;
                }
                return o1.x2 - o2.x2;
            }
        });
        int max_size = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(max_size < line_list.get(i).x1){
                cnt++;
                max_size = line_list.get(i).x2;
            }
        }
        System.out.print(cnt);

        br.close();
    }
}

class line{
    int x1,x2;
    public line(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
}