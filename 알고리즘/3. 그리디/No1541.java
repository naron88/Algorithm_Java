import java.io.*;
import java.util.*;

public class No1541 {
    // 최솟값을 만드는 괄호 배치 찾기
    // 1541
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        String quest = st.nextToken();

        // -를 기준으로 나눔
        // 100, 40+50+74, 30+29, 45+43+11
        String[] minusSplitList = quest.split("-");

        result = minusSplitAndSum(minusSplitList, result);

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static int minusSplitAndSum(String[] minusSplitList, int result) {
        for (int i = 0; i < minusSplitList.length; i++) {
            int sum = PlusSplitAndSum(minusSplitList[i]);
            if (i == 0){
                result += sum;
            } else{
                result -= sum;
            }
        }
        return result;
    }

    private static int PlusSplitAndSum(String minusSplitList) {
        String[] plusSplitList = minusSplitList.split("[+]");
        int sum = 0;

        for (int j = 0; j < plusSplitList.length; j++) {
            sum += Integer.parseInt(plusSplitList[j]);
        }
        return sum;
    }
}