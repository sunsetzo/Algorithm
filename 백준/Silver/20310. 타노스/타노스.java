import java.io.*;
import java.util.ArrayList;

public class Main {
    static String s;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int z = 0; int o = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='0') z++;
            else o++;
        }
        o/=2; z/=2;

        ArrayList<Integer> idx = new ArrayList<>();
        //ArrayList<Integer> zIdx = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            if (o<1) break;
            if (s.charAt(i) == '1'){
                //System.out.println(i);
                idx.add(i);
                o--;
            }
        }
        for (int i=s.length()-1; i>-1; i--){
            if (z<1) break;
            if (s.charAt(i) == '0'){
                //System.out.println(i);
                idx.add(i);
                z--;
            }

        }
        String ans = "";
        for (int i=0; i<s.length(); i++){
            if (idx.contains(i)) continue;
            else ans+=s.charAt(i);
        }
        System.out.println(ans);
    }
}