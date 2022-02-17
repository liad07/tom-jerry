package com.company;
import java.util.*;
public class Main {
    public static Scanner anne = new Scanner(System.in);
    public static int MovePlayer(int playerPos)
    {
        System.out.println("Press enter to continue");
        try{System.in.read();}
        catch(Exception e){}

        playerPos += -5+(int)(Math.random()*(11));
        return playerPos;
    }
    public static void printLocation(int tomPos,int jerryPos)
    {
        char [] arrloc = new char[50];
        for (int i =0; i<50;i++)
        {
            arrloc[i]='*';
        }
        if (tomPos<0||tomPos>49)
        {
            arrloc[jerryPos]='J';
            for (int i =0; i<50;i++)
            {
                System.out.print(arrloc[i]);
            }
            return;
        }
        if (jerryPos<0||jerryPos>49)
        {
            arrloc[tomPos]='T';
            for (int i =0; i<50;i++)
            {
                System.out.print(arrloc[i]);
            }
            return;
        }

        arrloc[tomPos]='T';
        arrloc[jerryPos]='J';
        for (int i =0; i<50;i++)
        {
            System.out.print(arrloc[i]);
        }
    }
    public static void printLocation1(int tomPos,int jerryPos, int turn)
    {
        char [] arrloc = new char[50];
        for (int i =0; i<50;i++)
        {
            arrloc[i]='*';
        }
        if (tomPos<0||tomPos>49)
        {
            arrloc[jerryPos]='J';
            for (int i =0; i<50;i++)
            {
                System.out.print(arrloc[i]);
            }
            return;
        }
        if (jerryPos<0||jerryPos>49)
        {
            arrloc[tomPos]='T';
            for (int i =0; i<50;i++)
            {
                System.out.print(arrloc[i]);
            }
            return;
        }
        if (jerryPos==tomPos) {
            if(turn == 1)
            {
                arrloc[tomPos]='T';
                for (int i =0; i<50;i++)
                {
                    System.out.print(arrloc[i]);
                }

            }
            else
            {
                arrloc[jerryPos]='J';
                for (int i =0; i<50;i++)
                {
                    System.out.print(arrloc[i]);
                }
            }
        }
        else
        {
            arrloc[tomPos]='T';
            arrloc[jerryPos]='J';
            for (int i =0; i<50;i++)
            {
                System.out.print(arrloc[i]);
            }
        }
    }
    public static boolean checkGame(int tomPos,int jerryPos){
        boolean ret = true;
        if (tomPos<0||tomPos>49)
        {
           ret = false;
        }
        if (jerryPos<0||jerryPos>49)
        {
            ret = false;
        }
        if (jerryPos==tomPos){
            ret = false;
        }
    return ret;
    }
    public static int checkWin(int tomPos,int jerryPos){
        int ret = 0;
        if (tomPos<0||tomPos>49)
        {
            ret = 1;
        }
        if (jerryPos<0||jerryPos>49)
        {
            ret = 2;
        }
        if (jerryPos==tomPos){
            ret = 3;
        }
        return ret;
    }
    public static void main(String[] args)
    {
        int tom,jerry,turns=0;
        int chula = 0;
        tom=9;
        jerry=39;
        printLocation1(tom,jerry,0);
        System.out.println();
        while (checkGame(tom,jerry))
        {
            tom = MovePlayer(tom);
            printLocation1(tom,jerry,1);
            System.out.println();
            if(!checkGame(tom,jerry))
            {
                if(tom==jerry)
                {
                    chula = 1;
                }
                break;
            }

            jerry= MovePlayer(jerry);
            printLocation1(tom,jerry,2);
            System.out.println();
            if(tom==jerry)
            {
                chula = 2;
            }
        turns ++;
        }

        if (checkWin(tom,jerry)==1){
            System.out.println("Jerry wins");
        }
        if (checkWin(tom,jerry)==2){
            System.out.println("Tom wins");

        }
        if (checkWin(tom,jerry)==3)
        {
            if(chula == 1)
                System.out.println("Tom wins");
            if(chula == 2)
                System.out.println("Jerry wins");
        }
        System.out.println("The game lasted " + turns + " turns");
    }
}
