package com.example.taylor.scoutingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;


public class FilterTeamsActivity extends ActionBarActivity
{
    ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_teams);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Filter");

        final CheckBox d1 = (CheckBox) findViewById(R.id.d1);
        final CheckBox d2 = (CheckBox) findViewById(R.id.d2);
        final CheckBox d3 = (CheckBox) findViewById(R.id.d3);
        final CheckBox d4 = (CheckBox) findViewById(R.id.d4);
        final CheckBox d5 = (CheckBox) findViewById(R.id.d5);
        final CheckBox d6 = (CheckBox) findViewById(R.id.d6);
        final CheckBox d7 = (CheckBox) findViewById(R.id.d7);
        final CheckBox d8 = (CheckBox) findViewById(R.id.d8);
        final CheckBox d9 = (CheckBox) findViewById(R.id.d9);
        final CheckBox d10 = (CheckBox) findViewById(R.id.highGoal);
        final CheckBox d11 = (CheckBox) findViewById(R.id.lowGoal);
        final CheckBox d12 = (CheckBox) findViewById(R.id.lift);
        final CheckBox d13 = (CheckBox) findViewById(R.id.autonomousPoints);

        checkBoxes.add(d1); checkBoxes.add(d2); checkBoxes.add(d3); checkBoxes.add(d4);
        checkBoxes.add(d5); checkBoxes.add(d6); checkBoxes.add(d7); checkBoxes.add(d8);
        checkBoxes.add(d9); checkBoxes.add(d10); checkBoxes.add(d11); checkBoxes.add(d12);
        checkBoxes.add(d13);

        final Button filter = (Button) findViewById(R.id.filterButton);

        filter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                boolean[] compare = new boolean[13];
                for(int i=0; i < checkBoxes.size(); i++)
                {
                    compare[i] = checkBoxes.get(i).isChecked();
                }

                Intent viewFiltered = new Intent(v.getContext(), ViewFilteredActivity.class);
                viewFiltered.putExtra("compare", compare);
                startActivity(viewFiltered);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_team, menu);
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
