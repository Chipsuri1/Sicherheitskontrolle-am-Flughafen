package main.configuration;

import main.ScanResult;

public class BoyerMoore implements IStringMatching {

    public String search(String text, String pattern){

        int position = searchForPattern(text, pattern);

        if (position == -1) {
            return "clean";
        } else {
            return String.valueOf(position);
        }


        switch (result){
            case "-1":
                return "clean";
            case "K":
                return "prohibited item | knife detected at position " + position;
            case "W":
                return "prohibited item | weapon -glock7 detected at position " + position;
            case "E":
                return "prohibited item | explosive detected at position " + position;
        }

        return null;
    }

    public int searchForPattern(String text, String pattern) {
        int[] last = buildLast(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = m - 1;

        if (i > n - 1) {
            return -1;
        }

        int j = m - 1;

        do {
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == 0) {
                    return i;
                } else {
                    i--;
                    j--;
                }
            } else {
                int lo = last[text.charAt(i)];
                i = i + m - Math.min(j, 1 + lo);
                j = m - 1;
            }
        } while (i <= n - 1);

        return -1;
    }

    public int[] buildLast(String pattern) {
        int[] last = new int[128];

        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        for (int i = 0; i < pattern.length(); i++) {
            last[pattern.charAt(i)] = i;
        }

        return last;
    }
}