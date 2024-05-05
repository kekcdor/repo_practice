package com.example.demo.Pr4;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.example.demo.Pr4.Numbers.baseNumbers;
import static com.example.demo.Pr4.Numbers.bigNumbers;

public class Converter {

    public static String replaceNumbers(String text) {
        String collect = baseNumbers.keySet().stream().sorted((o1, o2) -> Integer.compare(o2.length(), o1.length())).collect(Collectors.joining("|"))
                + "|"
                + bigNumbers.keySet().stream().sorted((o1, o2) -> Integer.compare(o2.length(), o1.length())).collect(Collectors.joining("|"));

        Pattern pattern = Pattern.compile("("+ collect + ")" + "(\s*(" + collect + "))*");
        Matcher matcher = pattern.matcher(text);

        String result = text;

        while (matcher.find()) {
            String findingTextNumber = text.substring(matcher.start(), matcher.end());
            String numericNumber = convertToNumeric(findingTextNumber);
            result = result.replaceAll(findingTextNumber, numericNumber);
        }
        return result;
    }

    private static String convertToNumeric(String textNumber) {
        List<String> words = Arrays.stream(textNumber.split(" "))
                .filter(Strings::isNotEmpty)
                .toList();

        long result;

        if (bigNumbers.containsKey(words.get(0)))
            result = bigNumbers.get(words.get(0));
        else result = baseNumbers.get(words.get(0));

        for (int i = 1; i < words.size(); i++) {
            if (bigNumbers.containsKey(words.get(i)))
                result = result * bigNumbers.get(words.get(i));
            else
                result = result + baseNumbers.get(words.get(i));
        }

        return String.valueOf(result);
    }
}
