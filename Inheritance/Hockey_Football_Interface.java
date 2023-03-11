package com.oppe_practise;

import java.util.Arrays;
import java.util.Scanner;

interface HockeyTeam{
    public int calculateHockeyScore();
    public int findHighestGoalByIndividualInHockey();
}

interface FootballTeam{
    public int calculateFootballScore();
    public int findHighestGoalByIndividualInFootball();
}

class Sport implements HockeyTeam,FootballTeam{
    int[] hockeyPlayers;
    int[] footballPlayers;
    
    public Sport(int[] hockeyPlayers,int[] footballPlayers)
    {
        this.hockeyPlayers = hockeyPlayers;
        this.footballPlayers = footballPlayers;
    }
    
    public int calculateHockeyScore()
    {
        int sum = 0;
        for(int i:hockeyPlayers)
        {
            sum = sum + i;
        }
        return sum;
    }
    
    public int calculateFootballScore()
    {
        int sum = 0;
        for(int i:footballPlayers)
        {
            sum = sum + i;
        }
        return sum;
    }
    
    public int findHighestGoalByIndividualInHockey()
    {
        int max = 0;
        for(int i:hockeyPlayers)
        {
            if(i>max)
            {
                max = i;
            }
        }
        return max;
    }
    
    public int findHighestGoalByIndividualInFootball()
    {
        int max = 0;
        for(int i:footballPlayers)
        {
            if(i>max)
            {
                max = i;
            }
        }
        return max;
    }
}

public class Hockey_Football_Interface{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int[] hockeyPlayers = new int[11];
        int[] footballPlayers = new int[11];

        for(int i = 0; i < 11; i++)
        {
            hockeyPlayers[i] = sc.nextInt();
        }

        for(int i = 0; i < 11; i++)
        {
            footballPlayers[i] = sc.nextInt();
        }
        
        Sport s = new Sport(hockeyPlayers, footballPlayers);
        try{
            HockeyTeam.class.getMethod("calculateHockeyScore");
            HockeyTeam.class.getMethod("findHighestGoalByIndividualInHockey");
            FootballTeam.class.getMethod("calculateFootballScore");
            FootballTeam.class.getMethod("findHighestGoalByIndividualInFootball");

            if(s instanceof HockeyTeam && s instanceof FootballTeam)
            {
                System.out.println(s.calculateHockeyScore());
                System.out.println(s.calculateFootballScore());
                System.out.println(s.findHighestGoalByIndividualInHockey());
                System.out.println(s.findHighestGoalByIndividualInFootball());
            }
        }
        catch (NoSuchMethodException ex)
        {
            System.out.println("No such function is exits");
        }
    }
}