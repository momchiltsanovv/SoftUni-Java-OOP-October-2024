package _03_CardsWithPower;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String cardRank = sc.nextLine();
        String cardSuit = sc.nextLine();

        CardRank cardRankEnum = CardRank.valueOf(cardRank);
        CardSuit cardSuitEnum = CardSuit.valueOf(cardSuit);
        //asdasd

        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit, cardRankEnum.getPower() + cardSuitEnum.getPower());
    }
}
