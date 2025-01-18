import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String num = st.nextToken();

        int[] intArr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            intArr[i] = Integer.parseInt(num.substring(i, i+1));
        }

        for (int i = 0; i < intArr.length-1; i++) {
            int maxIndex = i;
            for (int j = i+1; j < intArr.length; j++) {
                if (intArr[maxIndex] < intArr[j]){
                    maxIndex = j;
                }
            }
            int temp = intArr[i];
            intArr[i] = intArr[maxIndex];
            intArr[maxIndex] = temp;
        }

        for (int i = 0; i < intArr.length; i++) {
            bw.write(intArr[i]+"");
        }
        bw.flush();
        bw.close();
    }
}