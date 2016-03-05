package com.example.taylor.scoutingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
{
    public static ArrayList<Team> teams;
    public static TeamAdapter adapter;
    public static SharedPreferences mPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teams = new ArrayList<Team>();

        mPrefs = getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();

        int count = 0;
        count = mPrefs.getInt("count", 0);

        for(int i=0; i<count; i++)
        {
            String json = mPrefs.getString("Team " + i, "");
            Team t = gson.fromJson(json, Team.class);

            teams.add(t);
        }

        Button addTeamButton = (Button) findViewById(R.id.addTeamButton);
        addTeamButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addTeamIntent = new Intent(v.getContext(), AddTeamActivity.class);
                startActivity(addTeamIntent);
            }
        });

        ListView list = (ListView) findViewById(R.id.listView);
        adapter = new TeamAdapter(this, teams);
        adapter.notifyDataSetChanged();
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent viewIntent = new Intent(view.getContext(), ViewTeamActivity.class);
                viewIntent.putExtra("name", teams.get(position).teamName);
                viewIntent.putExtra("number", teams.get(position).number);
                viewIntent.putExtra("notes", teams.get(position).notes);
                viewIntent.putExtra("defenses", teams.get(position).defenses);
                viewIntent.putExtra("index", position);
                startActivity(viewIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        if(id == R.id.filter_teams)
        {
            Intent filter = new Intent(this, FilterTeamsActivity.class);
            startActivity(filter);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
