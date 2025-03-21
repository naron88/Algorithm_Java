
import java.io.*;
import java.util.*;

public class Main {
    // 최솟값을 만드는 괄호 배치 찾기
    // 1541
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int result = 0;


        // -를 기준으로 나눔
        // 100, 40+50+74, 30+29, 45+43+11
        String[] minusSplitList = sc.nextLine().split("-");

        result = minusSplitAndSum(minusSplitList, result);

        System.out.println(result);
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
