package com.example.taylor.scoutingapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;


public class ViewTeamActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_team);

        String name = (String) getIntent().getExtras().get("name");
        int number = (int) getIntent().getExtras().get("number");
        String notes = (String) getIntent().getExtras().get("notes");
        boolean[] defenses = (boolean[]) getIntent().getExtras().get("defenses");

        TextView nameView = (TextView) findViewById(R.id.teamName);
        nameView.setText(name);

        TextView numberView = (TextView) findViewById(R.id.teamNumber);
        numberView.setText("" + number);

        TextView notesView = (TextView) findViewById(R.id.notes);
        notesView.setText(notes);

        CheckBox d1 = (CheckBox) findViewById(R.id.d1);
        d1.setChecked(defenses[0]);

        CheckBox d2 = (CheckBox) findViewById(R.id.d2);
        d2.setChecked(defenses[1]);

        CheckBox d3 = (CheckBox) findViewById(R.id.d3);
        d3.setChecked(defenses[2]);

        CheckBox d4 = (CheckBox) findViewById(R.id.d4);
        d4.setChecked(defenses[3]);

        CheckBox d5 = (CheckBox) findViewById(R.id.d5);
        d5.setChecked(defenses[4]);

        CheckBox d6 = (CheckBox) findViewById(R.id.d6);
        d6.setChecked(defenses[5]);

        CheckBox d7 = (CheckBox) findViewById(R.id.d7);
        d7.setChecked(defenses[6]);

        CheckBox d8 = (CheckBox) findViewById(R.id.d8);
        d8.setChecked(defenses[7]);

        CheckBox d9 = (CheckBox) findViewById(R.id.d9);
        d9.setChecked(defenses[8]);

        CheckBox d10 = (CheckBox) findViewById(R.id.highGoal);
        d10.setChecked(defenses[9]);

        CheckBox d11 = (CheckBox) findViewById(R.id.lowGoal);
        d11.setChecked(defenses[10]);

        CheckBox d12 = (CheckBox) findViewById(R.id.lift);
        d12.setChecked(defenses[11]);

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

        return super.onOptionsItemSelected(item);
    }
}
