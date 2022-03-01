package Hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        //
        String[] words = {"This", "isis", "an", "example", "of", "text", "justification", "its", "written", "hiby", "Abhijeet", "and", "Akansha."};
        int maxWidth = 17;

        fullJustifyDP(words, maxWidth);
//        String[] words ={"tushar","roy","likes","to","code"};
//        fullJustifyDP(words, 10);
        for(String line : fullJustify(words, maxWidth)){
            System.out.println(line);
        }


    }
    // https://leetcode.com/problems/text-justification/
    public static List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<StringBuilder> current = new ArrayList<>();
        int numOfLetters = 0;

        for(String w : words){
            StringBuilder word = new StringBuilder(w);

            // total no. of chars in current_list + total no. of chars in current word
            // + total no. of words previously (i.e. min. number of spaces between words)
            if(numOfLetters + w.length() + current.size() > maxWidth){
                // run the loop equal to number of spaces that needs to be added
                for(int i=0; i<(maxWidth-numOfLetters); i++){
                    // if there is only one element then add all spaces after it
                    if(current.size()==1) current.get(0).append(" ");
                    // else add space in round-robin way
                    else current.get(i % (current.size()-1)).append(" ");
                }
                //add to the result
                result.add(String.join("",current));

                // reset for the next line
                current = new ArrayList<>();
                numOfLetters = 0;
            }

            // current word goes in the current line
            current.add(word);
            numOfLetters += word.length();

        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", current));
        int spaces = maxWidth - lastLine.length();
        while(spaces-->0) lastLine.append(" ");

        result.add(lastLine.toString());

        return result;
    }

    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }


    public static List<String> fullJustifyDP(String[] words, int maxWidth){
        int n = words.length;
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            int curr = 0;
            for(int j=i; j<n; j++){
                curr += words[j].length() + (j-i);
                if(curr <= maxWidth) dp[i][j] = (maxWidth-curr)*(maxWidth-curr);
                else dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] ar : dp) printArr(ar);
        int[] idx = new int[n];
        int[] sqr = new int[n];

        for(int i=n-1; i>=0; i--){
            int index = -1;
            int val = Integer.MAX_VALUE;
            for(int j=n-1; j>=i; j--){
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                int curr = dp[i][j] + ((j>=n-1)?0:sqr[j+1]);
                if(val>=curr){
                    val = curr;
                    index = j+1;
                }
            }
            idx[i] = index;
            sqr[i] = val;
        }


        System.out.println();
        printArr(idx);
        printArr(sqr);

        ArrayList<ArrayList<StringBuilder>> justified = new ArrayList<>();
        int idex = 0;

        while (idex<n){
            ArrayList<StringBuilder> curr = new ArrayList<>();
            for(int i=idex; i<idx[idex]; i++) curr.add(new StringBuilder(words[i]));
            justified.add(curr);
            idex = idx[idex];
        }


        System.out.println(justified);

        return null;
    }
}
