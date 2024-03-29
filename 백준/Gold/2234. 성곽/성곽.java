import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    // 북, 동, 남, 서
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int room = 0;
        int max = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!visit[i][j]){
                    max = Math.max(max, bfs(i, j));
                    room++;
                }
            }
        }
        System.out.println(room);
        System.out.println(max);
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                for (int bit=1; bit<=8; bit<<=1){
                    if ((arr[i][j] & bit)!=0){
                        visit = new boolean[n][m];
                        arr[i][j] -= bit;
                        max = Math.max(max, bfs(i, j));
                        arr[i][j] += bit;
                    }
                }
            }
        }
        System.out.println(max);
    }
    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        int cnt = 1;
        visit[x][y] = true;
        while (!q.isEmpty()){
            Node node = q.poll();
            int bit = 1;
            for (int w=0; w<4; w++){
                if ((arr[node.x][node.y]&bit)==0){
                    int nx = node.x+dx[w];
                    int ny = node.y+dy[w];
                    if (0<=nx && nx<n && 0<=ny && ny<m){
                        if (!visit[nx][ny]){
                            cnt ++;
                            visit[nx][ny] = true;
                            q.add(new Node(nx, ny));
                        }
                    }
                }
                bit <<= 1;
            }
        }
        return cnt;
    }
}