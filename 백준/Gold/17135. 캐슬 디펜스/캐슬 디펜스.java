import java.io.*;
import java.util.*;

public class Main {
    static int n, m, d, res;
    static int[][] board, copyBoard;
    static int[] archer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        archer = new int[3];
        board = new int[n][m];
        copyBoard = new int[n][m];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                copyBoard[i][j] = board[i][j];
            }
        }
        combi(0,0);
        System.out.println(res);
    }
    // 궁수 위치 구하기(조합)
    static void combi(int idx, int start){
        if (idx == 3){
            init();
            attack();
            return;
        }
        for (int i=start; i<m; i++){
            archer[idx] = i;
            combi(idx+1, i+1);
        }
    }
    static void attack() {
        int cnt = 0;
        for (int game=0; game<n; game++){
            int[][] killed = new int[3][2];
            for (int k=0; k<3; k++){
                int arc = archer[k];
                int minD = Integer.MAX_VALUE;
                killed[k][0] = killed[k][1] = -1;
                for (int i=0; i<n; i++){
                    for (int j=0; j<m; j++){
                        if (board[i][j] == 1){
                            int dis = getDistance(n, arc, i, j);
                            if (dis <= d && dis < minD){
                                minD = dis;
                                killed[k][0] = i;
                                killed[k][1] = j;
                            } else if (dis == minD && j < killed[k][1]) {
                                killed[k][0] = i;
                                killed[k][1] = j;
                            }
                        }
                    }
                }
            }
            for (int k=0; k<3; k++) {
                int i = killed[k][0];
                int j = killed[k][1];
                if (i != -1 && board[i][j] == 1) {
                    cnt++;
                    board[i][j] = 0;
                }
            }
            moveEnemy();
        }
        res = Math.max(res, cnt);
    }

    static void init(){
        // 새로운 궁수의 조합일때마다 기존의 배열을 사용해줘야함
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                board[i][j] = copyBoard[i][j];
            }
        }
    }
    static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1)+Math.abs(y2-y1);
    }
    static void moveEnemy(){
        for (int i=n-1; i>0; i--){
            for (int j=0; j<m; j++){
                board[i][j] = board[i-1][j];
            }
        }
        Arrays.fill(board[0], 0);
    }
    static void print(){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}