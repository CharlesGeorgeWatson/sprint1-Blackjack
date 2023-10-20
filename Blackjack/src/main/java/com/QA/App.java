package com.QA;

public class App {
    public static void main(String[] args) {


        
        int num1 = randomNumGen(-1, 30);
        int num2 = randomNumGen(-1, 30);
        System.out.println("Player 1 " + num1);
        System.out.println("Player 2 " + num2);
        System.out.println("Player "+winCondition2Player(num1, num2)+ " wins.");
    }

    public static int randomNumGen(int minNum, int maxNum) { //minNum & maxNum inclusive
        maxNum++;
        return (int) (minNum + (Math.random() * (maxNum - minNum)));
    }

    public static int winCondition2Player(int player1, int player2) {
        if (invalidHand(player1) || invalidHand(player2)){
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

    public static boolean invalidHand(int cardInput){
        return cardInput<2; // 2 is minimum allowed score for a 2 card deal
    }

}

