package Hard;

public class MaximumFontToFitTheScreen {
    public static void main(String[] args) {

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
