package vn.techmaster;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main (String[]args){
        LotteryGame game = new LotteryGame(6, 1, 49);
        System.out.println(game.getExplanationString());
        boolean run = true;
        while (run) {
            game.play();
            System.out.print("Continue (Y / N): ");
            System.out.flush();
            run = scanner.nextLine().equalsIgnoreCase("Y");
            System.out.println();
        }
    }

    public static int warn (String message){
        while (true) {
            try {
                System.out.print(message);
                System.out.flush();
                return Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number.");
            }
        }
    }
}