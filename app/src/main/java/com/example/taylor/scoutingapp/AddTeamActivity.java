package com.example.taylor.scoutingapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;


public class AddTeamActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_team);

        Button saveTeamButton = (Button) findViewById(R.id.saveTeamButton);
        final EditText name = (EditText) findViewById(R.id.nameText);
        final EditText number = (EditText) findViewById(R.id.numberText);
        final EditText notes = (EditText) findViewById(R.id.notesText);

        final CheckBox d1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox d2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox d3 = (CheckBox) findViewById(R.id.checkBox3);
        final CheckBox d4 = (CheckBox) findViewById(R.id.checkBox4);
        final CheckBox d5 = (CheckBox) findViewById(R.id.checkBox5);
        final CheckBox d6 = (CheckBox) findViewById(R.id.checkBox6);
        final CheckBox d7 = (CheckBox) findViewById(R.id.checkBox7);
        final CheckBox d8 = (CheckBox) findViewById(R.id.checkBox8);
        final CheckBox d9 = (CheckBox) findViewById(R.id.checkBox9);
        final CheckBox d10 = (CheckBox) findViewById(R.id.checkBox10);
        final CheckBox d11 = (CheckBox) findViewById(R.id.checkBox11);
        final CheckBox d12 = (CheckBox) findViewById(R.id.checkBox12);

        saveTeamButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Team t = new Team(name.getText().toString(), Integer.parseInt(number.getText().toString()));
                t.notes = notes.getText().toString();
                t.defenses[0] = d1.isChecked();
                t.defenses[1] = d2.isChecked();
                t.defenses[2] = d3.isChecked();
                t.defenses[3] = d4.isChecked();
                t.defenses[4] = d5.isChecked();
                t.defenses[5] = d6.isChecked();
                t.defenses[6] = d7.isChecked();
                t.defenses[7] = d8.isChecked();
                t.defenses[8] = d9.isChecked();
                t.defenses[9] = d10.isChecked();
                t.defenses[10] = d11.isChecked();
                t.defenses[11] = d12.isChecked();


                MainActivity.teams.add(t);
                MainActivity.adapter.notifyDataSetChanged();

                SharedPreferences.Editor prefsEditor = MainActivity.mPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(t);
                prefsEditor.putString("Team " + (MainActivity.teams.size()-1), json);
                prefsEditor.putInt("count", MainActivity.teams.size());
                prefsEditor.commit();

                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_team, menu);
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
