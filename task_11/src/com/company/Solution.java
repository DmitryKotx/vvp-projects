package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static List<String> sol (String str) {

        String[] months = new String[] {"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};
        List<String> allMatches = new ArrayList<>();
        Matcher date = Pattern.compile("\\d{1,2}[.]\\d{2}[.]\\d{4}").matcher(str);
        while (date.find()) {
            allMatches.add(date.group());
        }
        for (String month : months) {
            Matcher upCase = Pattern.compile("\\d{1,2}\\s" + month).matcher(str);
            while (upCase.find()) {
                if (str.length() - upCase.end() >= 5) {
                    Matcher upCaseY = Pattern.compile(upCase.group() + "\\s\\d{4}").matcher(str);
                    if (upCaseY.find()) {
                        allMatches.add(upCaseY.group());
                    } else {
                        allMatches.add(upCase.group());
                    }
                } else {
                    allMatches.add(upCase.group());
                }
            }
            Matcher lowCase = Pattern.compile("\\d{1,2}\\s" + month.toLowerCase(Locale.ROOT)).matcher(str);
            while (lowCase.find()) {
                if (str.length() - lowCase.end() >= 5) {
                    Matcher lowCaseY = Pattern.compile(lowCase.group() + "\\s\\d{4}").matcher(str);
                    if (lowCaseY.find()) {
                        allMatches.add(lowCaseY.group());
                    } else {
                        allMatches.add(lowCase.group());
                    }
                } else {
                    allMatches.add(lowCase.group());
                }
            }
        }
        return allMatches;
    }
}
