package _06_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long availableCapacity = Long.parseLong(scanner.nextLine());
        String[] safeContents = scanner.nextLine().split("\\s+");

        Map<String, Map<String, Long>> treasureBag = new LinkedHashMap<>();
        long totalGold = 0;
        long totalGems = 0;
        long totalCash = 0;

        for (int i = 0; i < safeContents.length; i += 2) {
            String itemName = safeContents[i];
            long itemQuantity = Long.parseLong(safeContents[i + 1]);

            String itemType = determineItemType(itemName);

            if (itemType.isEmpty() || !canAddItem(treasureBag, availableCapacity, itemQuantity)) {
                continue;
            }

            if (!isValidItem(treasureBag, itemType, itemQuantity)) {
                continue;
            }

            addItemToTreasureBag(treasureBag, itemType, itemName, itemQuantity);

            switch (itemType) {
                case "Gold" -> totalGold += itemQuantity;
                case "Gem" -> totalGems += itemQuantity;
                case "Cash" -> totalCash += itemQuantity;
            }
        }

        printTreasureBag(treasureBag);
    }

    private static String determineItemType(String itemName) {
        if (itemName.length() == 3) {
            return "Cash";
        } else if (itemName.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (itemName.equalsIgnoreCase("gold")) {
            return "Gold";
        }
        return "";
    }

    private static boolean canAddItem(Map<String, Map<String, Long>> treasureBag, long availableCapacity, long itemQuantity) {
        long currentTotal = treasureBag.values().stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .mapToLong(Long::longValue)
                .sum();
        return availableCapacity >= currentTotal + itemQuantity;
    }

    private static boolean isValidItem(Map<String, Map<String, Long>> treasureBag, String itemType, long itemQuantity) {
        return switch (itemType) {
            case "Gem" -> validateGem(treasureBag, itemQuantity);
            case "Cash" -> validateCash(treasureBag, itemQuantity);
            default -> true;
        };
    }

    private static boolean validateGem(Map<String, Map<String, Long>> treasureBag, long itemQuantity) {
        long totalGems = treasureBag.getOrDefault("Gem", new LinkedHashMap<>()).values().stream()
                .mapToLong(Long::longValue)
                .sum();
        long totalGold = treasureBag.getOrDefault("Gold", new LinkedHashMap<>()).values().stream()
                .mapToLong(Long::longValue)
                .sum();
        return totalGems + itemQuantity <= totalGold;
    }

    private static boolean validateCash(Map<String, Map<String, Long>> treasureBag, long itemQuantity) {
        long totalCash = treasureBag.getOrDefault("Cash", new LinkedHashMap<>()).values().stream()
                .mapToLong(Long::longValue)
                .sum();
        long totalGems = treasureBag.getOrDefault("Gem", new LinkedHashMap<>()).values().stream()
                .mapToLong(Long::longValue)
                .sum();
        return totalCash + itemQuantity <= totalGems;
    }

    private static void addItemToTreasureBag(Map<String, Map<String, Long>> treasureBag, String itemType, String itemName, long itemQuantity) {
        treasureBag.putIfAbsent(itemType, new LinkedHashMap<>());
        treasureBag.get(itemType).putIfAbsent(itemName, 0L);
        treasureBag.get(itemType).put(itemName, treasureBag.get(itemType).get(itemName) + itemQuantity);
    }

    private static void printTreasureBag(Map<String, Map<String, Long>> treasureBag) {
        for (Map.Entry<String, Map<String, Long>> entry : treasureBag.entrySet()) {
            long totalValue = entry.getValue().values().stream()
                    .mapToLong(Long::longValue)
                    .sum();

            System.out.printf("<%s> $%s%n", entry.getKey(), totalValue);

            entry.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(item -> System.out.println("##" + item.getKey() + " - " + item.getValue()));
        }
    }
}
