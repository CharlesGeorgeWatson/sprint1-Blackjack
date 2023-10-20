package com.QA;
import java.util.Random;
public class App 
{
    public static void main( String[] args ) {
        int num1=randomNumGen(1,30);
        int num2=randomNumGen(1,30);
        System.out.println("Player 1 " + num1);
        System.out.println("Player 2 " + num2);
        System.out.println(winCondition2Player(num1, num2));
    }

    public static int randomNumGen(int minNum, int maxNum){ //minNum & maxNum inclusive
        maxNum++;
        return (int)(minNum + (Math.random() * (maxNum-minNum)));
    }
    
    public static int winCondition2Player(int player1, int player2){
        if(isBust(player1)&& isBust(player2)){
            return 0;
        }else if(isBust(player1)){
            return 2;
        }else if(isBust(player2)){
            return 1;
        }else if(player1 == player2){
            return 0; //draw
        }else{
            return (player1>player2) ? 1 : 2;
        }
    }

    public static boolean isNotBust(int cardInput){
        int maxValue = 21; 
        if(cardInput>maxValue){
            return false;
        }
        return true;
    }
    public static boolean isBust(int cardInput){
    int maxValue = 21;
    if(cardInput>maxValue){
        return true;
    }
    return false;
}

}

