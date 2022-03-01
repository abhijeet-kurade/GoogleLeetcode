package Hard;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "agbdba";
        System.out.println(longestPalindromicSubsequence(str));

    }

    public static int longestPalindromicSubsequence(String word){
        int n= word.length();
        int[][] dp = new int[n][n];

        for(int len=0; len<n; len++){
            for(int i=0; i<n; i++){
                int j = i + len;
                if(j>=n) continue;
                if(i==j){
                    dp[i][j] = 1;
                    continue;
                }
                if(word.charAt(i) == word.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }
}
