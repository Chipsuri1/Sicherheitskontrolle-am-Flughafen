package main.configuration;

import main.ResultScan;

public class KnuthMorrisPratt {

    public ResultScan search(String text, String pattern){

        String result = searchForPattern(text, pattern);

        switch (result){
            case "-1":
                System.out.println("no prohibited item found");
            case "K":
                return ResultScan.knife;
            case "W":
                return ResultScan.weapon;
            case "E":
                return ResultScan.explosive;
        }

        return null;
    }


    public String searchForPattern(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] fail = computeFail(pattern);
        int i = 0;
        int j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == m - 1) {
                    return pattern; // match
                }
                i++;
                j++;
            } else if (j > 0) {
                j = fail[j - 1];
            } else {
                i++;
            }
        }

        return "-1";
    }

    public int[] computeFail(String pattern) {
        int[] fail = new int[pattern.length()];
        fail[0] = 0;
        int m = pattern.length();
        int j = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                fail[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = fail[j - 1];
            } else {
                fail[i] = 0;
                i++;
            }
        }

        return fail;
    }
}