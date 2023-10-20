package com.QA;
import java.util.Random;
public class App 
{
    public static void main( String[] args )
    {
        int num1=randomNumGen(1,30);
        int num2=randomNumGen(1,30);

    }

    public static int randomNumGen(int minNum, int maxNum){ //minNum & maxNum inclusive
        maxNum++;
        return (int)(minNum + (Math.random()*(maxNum-minNum)));
    }
    public static int winCondition2Player(int player1, int player2){
        if (player1>player2 && player1<=21) {
            //p1 wins
        }
        else if (player2<=21) {
            //p2 wins
        }
        else {
        //both bust
        }
    }

    }
}
