import java.util.Scanner;

public class Coin {
    public static int countWays(int[] coins, int sum) {
        return countWaysHelper(coins, sum, 0);
    }

    private static int countWaysHelper(int[] coins, int sum, int index) {
        if (sum == 0) {
            return 1; // Found a valid combination
        }
        if (sum < 0 || index >= coins.length) {
            return 0; // No valid combination
        }

        // Include the current coin
        int includeCurrentCoin = countWaysHelper(coins, sum - coins[index], index);

        // Exclude the current coin and move to the next
        int excludeCurrentCoin = countWaysHelper(coins, sum, index + 1);

        return includeCurrentCoin + excludeCurrentCoin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of denominations: ");
        int N = scanner.nextInt();
        int[] coins = new int[N];

        System.out.println("Enter the denominations:");
        for (int i = 0; i < N; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();

        int result = countWays(coins, sum);
        System.out.println("Number of ways to make sum " + sum + ": " + result);

        scanner.close();
    }
}
