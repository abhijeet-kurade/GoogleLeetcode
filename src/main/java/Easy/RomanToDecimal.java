package Easy;

import java.util.HashMap;

public class RomanToDecimal {
    public static void main(String[] args) {
        System.out.println();

    }

    public int romanToDecimal(String number){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum  = 0;
        int idx = 0;
        int n = number.length();
        while(idx < n){
            int curr = map.get(number.charAt(idx));
            int next = 0;
            if(idx+1 < n){
                next = map.get(number.charAt(idx+1));
            }
            if(curr < next){
                sum += next - curr;
                idx += 2;
            }
            else{
                sum += curr;
                idx += 1;
            }
        }
        return sum;
    }
}
