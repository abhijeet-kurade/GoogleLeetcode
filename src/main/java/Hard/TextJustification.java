package Hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        //
        String[] words = {"This", "is", "an", "example", "of", "text", "justification", "its", "written", "by", "Abhijeet."};
        int maxWidth = 17;

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
}
