package _05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = getMatrix(dimensions);

        long sum = getLong(scanner, matrix);

        System.out.println(sum);


    }

    private static long getLong(Scanner scanner, int[][] matrix) {
        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoS = Arrays.stream(command.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            evilDiagonal(evil, matrix);

            sum = getSum(ivoS, matrix, sum);

            command = scanner.nextLine();
        }
        return sum;
    }

    private static int[][] getMatrix(int[] dimensions) {
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

    private static void evilDiagonal(int[] evil, int[][] matrix) {
        int xE = evil[0];
        int yE = evil[1];

        while (xE >= 0 && yE >= 0) {
            if (xE < matrix.length && yE < matrix[0].length) {
                matrix[xE][yE] = 0;
            }
            xE--;
            yE--;
        }
    }

    private static long getSum(int[] ivoS, int[][] matrix, long sum) {
        int xI = ivoS[0];
        int yI = ivoS[1];

        while (xI >= 0 && yI < matrix[1].length) {
            if (xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
                sum += matrix[xI][yI];
            }

            yI++;
            xI--;
        }
        return sum;
    }
}
