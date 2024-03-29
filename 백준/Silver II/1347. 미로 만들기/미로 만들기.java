import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String move;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        move = br.readLine();

        int[][] maze = new int[101][101];

        int dir = 2;
        int x = 50;
        int y = 50;
        int maxX = 50;
        int maxY = 50;
        int minX = 50;
        int minY = 50;

        maze[x][y] = 1;

        for (int i=0; i<n; i++){
            char m = move.charAt(i);
            if (m == 'L'){
                dir -= 1;
                if (dir == -1) dir = 3;
            } else if (m == 'R') {
                dir = (dir+1) % 4;
            } else if (m == 'F') {
                x += dx[dir];
                y += dy[dir];

                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);

                maze[x][y] = 1;
            }
        }

        for (int i=minX; i<=maxX; i++){
            for (int j=minY; j<=maxY; j++){
                if (maze[i][j] == 1){
                    sb.append(".");
                }else {
                    sb.append('#');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}