package main.configuration;

import main.ScanResult;

public interface IStringMatching {
    ScanResult search(String text, String pattern);
}