import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int i = 0; i < commands.length; i++){
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int[] temp = new int[end - start];
            for (int j = start; j < end; j++){
                temp[j-start] = array[j];
            }
            Arrays.sort(temp);
            result[i] = temp[commands[i][2]-1];
        }
        return result;
    }
}
