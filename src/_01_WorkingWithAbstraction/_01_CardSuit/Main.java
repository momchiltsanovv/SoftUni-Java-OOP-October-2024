package _01_WorkingWithAbstraction._01_CardSuit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("CardSuit Suits:\n");

        Arrays.stream(Suit.values())
                .forEach(e -> sb.append("Ordinal value: ")
                        .append((e.ordinal()))
                        .append("; Name value: ")
                        .append(e.name())
                        .append("\n"));


        System.out.println(sb);
    }
}
