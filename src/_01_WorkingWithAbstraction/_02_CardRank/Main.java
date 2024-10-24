package _01_WorkingWithAbstraction._02_CardRank;


import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append("CardSuit Ranks:\n");
        Arrays.stream(Rank.values()).forEach(e -> sb.append("Ordinal value: ").append(e.ordinal())
                                        .append("; Name value: ").append(e).append("\n"));

        System.out.println(sb);

    }
}
