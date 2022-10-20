package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static


    public static void oneMonthCalendar(int totaldays, int startweekday)
    {
            boolean extra = false; //Für Leerzeile falls die letzte Zahl nicht zahl%7
            for (int i = 1; i < startweekday;i++)
            {
                System.out.print("   ");
            }
            for(int i = 1; i < totaldays+1;i++)
            {
                if (i < 10)
                {
                    System.out.print(" " + i + " ");
                }
                else
                {
                    System.out.print(i + " ");
                    extra = true; //extra leerzeile falls innerhalb von 7 liegt
                }
                if (((startweekday-1) + i)%7 == 0)
                {
                    System.out.println();
                    extra = false;
                }
            }
            if (extra)
            {
                System.out.println("");
            }
    }
    public static long[] lcg (long seed)
    {
        long[] genNumber = new long[10];

        long a = 1103515245L;
        long m = 2147483648L;// 2^31
        long c = 12345L;
        genNumber[0] = (a*seed+c)%m; //Start x0
        for (int i = 0; i < 9; i++)
        {
            genNumber[i+1] = ((a*genNumber[i])+c)%m;
        }
        return genNumber;
    }

    public static void guessingGame(int numberToGuess)
    {
        Scanner sc = new Scanner(System.in);
        boolean guessed = false;
        int count = 0;
        while(!guessed && count != 10)
        {
            System.out.print("Guess number " + (count+1) +": ");
            int number = sc.nextInt();


            if (number > numberToGuess && count != 9)
            {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (number < numberToGuess && count != 9) {
                System.out.println("The number AI picked is higher than your guess.");
            } else if (number == numberToGuess)
            {
                guessed = true;
            }
            count++;
        }
        if (guessed)
        {
            System.out.println("You won wisenheimer!");
        }
        else
        {
            System.out.println("You lost! Have you ever heard of divide & conquer?");
        }

    }

    public static int randomNumberBetweenOneAndHundred()
    {
        int number = 0;
        number = (int) (Math.floor(Math.random() * (+101 - 1)) + 1);
        //Math.random() * (max+1 - min) + min; Numbers between 1, inclusive 100
        //Math.floor(Math.random() * (+101 - 1)) + 1; (Math.floor just used for getting integers Rounded 4.07 -> 5)
        return number;
    }

    public static boolean swapArrays(int[] first, int[]second)
    {
        int[] help;
        if (first.length == second.length)
        {
            help = new int[first.length];
            for (int i = 0; i < first.length; i++)
            {
                help[i] = first[i];
                first[i] = second[i];
                second[i] = help[i];
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    public static String camelCase(String sentence)
    {
        char[] cs = sentence.toCharArray();
        boolean big = true;
        boolean small = false;
        StringBuilder resut = new StringBuilder();
        for (int i = 0; i < cs.length; i++)
        {
            if(cs[i] == 32)
            {
                big = true;
                small = false;

            } else if(big && (cs[i] <= 90 && cs[i] >= 65 || cs[i] >= 97 && cs[i] <= 122))
            {
                if (cs[i] >= 97 && cs[i] <= 122)
                {
                    resut.append((char) (cs[i] - 32));
                }
                else
                {
                    resut.append(cs[i]);
                }
                big = false;
                small = true;
            } else if (small && (cs[i] <= 90 && cs[i] >= 65 || cs[i] >= 97 && cs[i] <= 122)) {
                if (cs[i] >= 65 && cs[i] <= 90)
                {
                    resut.append((char) (cs[i] + 32));
                }
                else
                {
                    resut.append(cs[i]);
                }
            }

        }
        return resut.toString();
    }

    public static int checkDigit(int[] code)
    {
        int sum = 0;
        for(int i = 0; i < code.length;i++)
        {
            code[i] *= (i+2);
            sum += code[i];
        }
        int rest = sum%11;
        int psumme = 11-rest;
        if(psumme == 10)
        {
            psumme = 0;
        } else if(psumme == 11)
        {
            psumme = 5;
        }
        return psumme;
    }
    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        //oneMonthCalendar(31,7);
        //long[] s = lcg (23);
        //guessingGame(10);
        //guessingGame(randomNumberBetweenOneAndHundred());
        //camelCase("but a noisY noise annoYs an oYster more.");
        // print their results
        // etc.
    }
}