package Telephony;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Callable, Browsable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String call() {
        return numbers.stream()
                      .map(number -> {
                          if (number.matches(".*[a-zA-Z]+.*")) {
                              return "Invalid number!";
                          }
                          return String.format("Calling... %s", number);
                      })
                      .collect(Collectors.joining("\n"));
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

       urls.forEach(url -> {
            if (url.matches(".*\\d.*")) {
                sb.append("Invalid URL!\n");
            } else {
                sb.append(String.format("Browsing: %s!\n", url));
            }
        });

       if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }


}
