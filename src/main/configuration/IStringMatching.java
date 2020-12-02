package main.configuration;

import main.ResultScan;

public interface IStringMatching {
    ResultScan search(String text, String pattern);
}