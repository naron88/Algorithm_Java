class Solution {
    public int largestAltitude(int[] gain) {
        int[] prefix = new int[gain.length + 1];

        prefix[0] = 0;
        int highestAltitude = 0;
        for (int i  = 1; i < gain.length + 1; i++) {
            prefix[i] = prefix[i - 1] + gain[i - 1];
            highestAltitude = Math.max(highestAltitude, prefix[i]);
        }

        return highestAltitude;
    }
}
