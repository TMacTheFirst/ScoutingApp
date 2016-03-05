package com.example.taylor.scoutingapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewFilteredActivity extends ActionBarActivity
{
    public static TeamAdapter adapter;
    public static ArrayList<Team> filteredTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_filtered);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Filtered Teams");

        filteredTeams = new ArrayList<Team>();
        fillInFilteredTeams();

        ListView list = (ListView) findViewById(R.id.listView);
        adapter = new TeamAdapter(this, filteredTeams);
        adapter.notifyDataSetChanged();
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent viewIntent = new Intent(view.getContext(), ViewTeamActivity.class);
                viewIntent.putExtra("name", filteredTeams.get(position).teamName);
                viewIntent.putExtra("number", filteredTeams.get(position).number);
                viewIntent.putExtra("notes", filteredTeams.get(position).notes);
                viewIntent.putExtra("defenses", filteredTeams.get(position).defenses);
                viewIntent.putExtra("index", position);
                startActivity(viewIntent);
            }
        });
    }

    public void fillInFilteredTeams()
    {
        boolean[] compare = (boolean[]) getIntent().getExtras().get("compare");
        for(int i=0; i<MainActivity.teams.size(); i++)
        {
            Team t = MainActivity.teams.get(i);
            boolean match = true;
            for(int j=0; j<t.defenses.length; j++)
            {
                if(compare[j] == true && t.defenses[j] != true)
                    match = false;
            }
            if(match)
                filteredTeams.add(t);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_filtered, menu);
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
        if (id == android.R.id.home)
        {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
