package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        Set<Integer> digits = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
               digits.add(Character.getNumericValue(c));
            }
        }
        return digits.size();
    }
}
