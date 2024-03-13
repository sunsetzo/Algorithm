import java.io.*;
import java.util.*;

public class Main {
    static int p, m, lv;
    static String name;
    static class Player implements Comparable<Player>{
        int level; String name; boolean chk;
        Player(int level, String name){
            this.level = level;
            this.name = name;
        }
        @Override
        public int compareTo(Player player){
            return name.compareTo(player.name);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Player[] players = new Player[p];
        for (int i=0; i<p; i++){
            String[] input = br.readLine().split(" ");
            lv = Integer.parseInt(input[0]);
            name = input[1];
            players[i] = new Player(lv, name);
        }

        for (int i=0; i<p; i++){
            ArrayList<Player> room = new ArrayList<>();
            if (!players[i].chk){
                for (int j=i; j<p; j++){
                    if (room.size()==m){
                        break;
                    }
                    int level = players[j].level;
                    String name = players[j].name;
                    if (!players[j].chk && players[i].level-10<=level && players[i].level+10>=level){
                        players[j].chk = true;
                        room.add(new Player(level, name));
                    }
                }
                Collections.sort(room);
                if (room.size()==m){
                    sb.append("Started!").append("\n");
                }else{
                    sb.append("Waiting!").append("\n");
                }
                for (Player player:room){
                    sb.append(player.level+ " ").append(player.name+"\n");
                }

            }
        }
        System.out.println(sb);
    }
}