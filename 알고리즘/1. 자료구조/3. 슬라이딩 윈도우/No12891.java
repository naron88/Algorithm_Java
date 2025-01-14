import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stringSize = sc.nextInt();
        int slideSize = sc.nextInt();
        int count = 0;

        String dna = sc.next();
        char[] dnaChars = dna.toCharArray(); // 문자열을 하나씩 나눔

        int[] includeDNA = new int[4]; // A C G T의 최소 개수
        for (int i = 0; i < includeDNA.length; i++) {
            includeDNA[i] = sc.nextInt();
        }

        // 첫 슬라이딩 윈도우
        int[] validDNA = new int[4];
        for (int i = 0; i < slideSize; i++) {
            addValid(dnaChars, i, validDNA);
        }
        count = getCount(validDNA, includeDNA, count);
        
        // 슬라이딩 윈도우가 문자열 끝에 도착할 때까지 반복
        for (int i = slideSize; i < stringSize; i++) {
            addValid(dnaChars, i, validDNA);
            removeValid(dnaChars, i, slideSize, validDNA);
            count = getCount(validDNA, includeDNA, count);
        }
        System.out.println(count);
    }

    private static int getCount(int[] validDNA, int[] includeDNA, int count) {
        if (validDNA[0] >= includeDNA[0] && validDNA[1] >= includeDNA[1] && validDNA[2] >= includeDNA[2] && validDNA[3] >= includeDNA[3]){
            count++;
        }
        return count;
    }

    private static void removeValid(char[] dnaChars, int i, int slideSize, int[] validDNA) {
        if (dnaChars[i - slideSize] == 'A'){
            validDNA[0]--;
        } else if (dnaChars[i - slideSize] == 'C') {
            validDNA[1]--;
        }else if (dnaChars[i - slideSize] == 'G') {
            validDNA[2]--;
        } else if (dnaChars[i - slideSize] == 'T') {
            validDNA[3]--;
        }
    }

    private static void addValid(char[] dnaChars, int i, int[] validDNA) {
        if (dnaChars[i] == 'A'){
            validDNA[0]++;
        } else if (dnaChars[i] == 'C') {
            validDNA[1]++;
        }else if (dnaChars[i] == 'G') {
            validDNA[2]++;
        } else if (dnaChars[i] == 'T') {
            validDNA[3]++;
        }
    }
}
