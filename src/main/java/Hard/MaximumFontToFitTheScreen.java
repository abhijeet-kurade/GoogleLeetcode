package Hard;

import java.util.*;

public class MaximumFontToFitTheScreen {
    public static void main(String[] args) {

    }


// you can also use imports, for example:
// import java.util.*;
public class Solution {

    public static void main(String[] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
    }

    // enqueue / add = O(1)
    // dequeue /poll = O(n)

    public class Queue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public Queue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }


        // O(1)
        public void enqueue(int val) {
            this.stack1.add(val);
        }

        // O(n)
        public int dequeue() {
            if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            if (this.stack2.isEmpty()) {
                while (!this.stack1.isEmpty()) {
                    this.stack2.add(this.stack1.pop());
                }
            }
            return this.stack2.pop();
        }

        public int dequeueUsingRec() {
            if (this.stack1.isEmpty()) {
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }

            int val = getFirstItem(this.stack1);
            return val;
        }
    }

    public int getFirstItem(Stack<Integer> stack) {
        if (stack.size() == 1) return stack.pop();
        int temp = stack.pop();
        int val = getFirstItem(stack);
        stack.add(temp);
        return val;
    }

}



    interface FontInfo {
        // Returns the width of character ch on the screen using font size fontSize.
        // O(1) per call
        public int getWidth(int fontSize, char ch);

        // Returns the height of any character on the screen using font size fontSize.
        // O(1) per call
        public int getHeight(int fontSize);
    }

    // Time O(n log m) where n is the size of the text and m is the length of the fonts array.
    public static int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0;
        int right = fonts.length -1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getWidth(text, fonts[mid],fontInfo) <= w && fontInfo.getHeight(fonts[mid]) <= h) {
                result = fonts[mid]; //found a valid font candidate
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Time O(n) where n is the size of the text
    private static int getWidth(String text,int font, FontInfo fontInfo){
        int length = 0;
        for(char c: text.toCharArray())
            length += fontInfo.getWidth(font, c);
        return length;
    }
}
