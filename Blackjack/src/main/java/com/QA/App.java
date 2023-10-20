package com.QA;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int player1Sum = 0;
        int dealerSum = 0;
//        ArrayList<Integer> player1Hand=new ArrayList<Integer>();
//        ArrayList<Integer> player2Hand=new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
//            int drawnCard = randomNumGen(2, 11);
            player1Sum = addCard(player1Sum);
            dealerSum = addCard(dealerSum);
        }
        do {
            if (hitRequest(player1Sum, dealerSum)) {
                player1Sum = addCard(player1Sum);
            } else {
                break;
            }
        } while (!isBust(player1Sum));
        while (shouldDealerHit(dealerSum)) {
            dealerSum = addCard(dealerSum);
            System.out.println("Dealer hits, new total is : " + dealerSum);
        }
        System.out.println("Player final score is " + player1Sum);
        System.out.println("Dealer final score is " + dealerSum);
        System.out.println("Player " + winCondition2Player(player1Sum, dealerSum) + " wins.");
    }

    public static boolean shouldDealerHit(int dealerSum) {
//        return Math.random() < 0.5 ? true : false; //50% chance
        return dealerSum <= 16;
    }

    public static boolean hitRequest(int player1Sum, int dealerSum) {
        System.out.println("Your hand is currently valued at " + player1Sum);
        System.out.println("The dealers hand is currently " + dealerSum);
        System.out.println("would you like to hit? -> Y/N");
        Scanner scanner = new Scanner(System.in);
        String hitChoice = scanner.nextLine();
        return hitChoice.equalsIgnoreCase("Y");
    }

    public static int addCard(int originalSum) {
        return originalSum + randomNumGen(2, 11);
    }

    public static int randomNumGen(int minNum, int maxNum) { //minNum & maxNum inclusive
        maxNum++;
        return (int) (minNum + (Math.random() * (maxNum - minNum)));
    }

    public static int winCondition2Player(int player1, int player2) {
        if (invalidHand(player1) || invalidHand(player2)) {
            System.out.println("Dodgy dealing");
            return 0;
        }

        if (isBust(player1) && isBust(player2)) {
            System.out.println("Both players bust");
            return 0;
        } else if (isBust(player1)) {
            return 2;
        } else if (isBust(player2)) {
            return 1;
        } else if (player1 == player2) {
            System.out.println("Draw");
            return 0; //draw
        } else {
            return (player1 > player2) ? 1 : 2;
        }
    }

    public static boolean isBust(int cardInput) {
        int maxValue = 21;
        return cardInput > maxValue;
    }

    public static boolean invalidHand(int cardInput) {
        return cardInput < 2; // 2 is minimum allowed score for a 2 card deal
    }

}

