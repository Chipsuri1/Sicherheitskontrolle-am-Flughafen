package main.configuration;

import main.ScanResult;

public class BoyerMoore implements IStringMatching {

    public ScanResult search(String text, String pattern){

        String result = searchForPattern(text, pattern);

        switch (result){
            case "-1":
                System.out.println("no prohibited item found");
            case "K":
                return ScanResult.knife;
            case "W":
                return ScanResult.weapon;
            case "E":
                return ScanResult.explosive;
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