package com.example.taylor.scoutingapp;


/**
 * Created by Taylor on 2/28/2016.
 */
public class Team //implements Parcelable
{
    String teamName, notes;
    int number;
    boolean[] defenses;

    public Team(String name, int num)
    {
        teamName = name;
        number = num;
        defenses = new boolean[12];
        for(int i=0; i<9; i++)
            defenses[i] = false;
    }


}
