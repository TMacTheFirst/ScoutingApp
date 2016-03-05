package com.example.taylor.scoutingapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;


public class ViewTeamActivity extends ActionBarActivity
{
    public boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_team);
;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        flag = true;
        String name = (String) getIntent().getExtras().get("name");
        int number = (int) getIntent().getExtras().get("number");
        String notes = (String) getIntent().getExtras().get("notes");
        boolean[] defenses = (boolean[]) getIntent().getExtras().get("defenses");
        final int position = (int) getIntent().getExtras().get("index");

        setTitle("Team " + number);

        final TextView nameView = (TextView) findViewById(R.id.teamName);
        nameView.setText(name);

        final EditText notesView = (EditText) findViewById(R.id.notes);
        notesView.setText(notes);
        notesView.setFocusable(false);

        final CheckBox d1 = (CheckBox) findViewById(R.id.d1);
        d1.setChecked(defenses[0]);
        d1.setClickable(false);

        final CheckBox d2 = (CheckBox) findViewById(R.id.d2);
        d2.setChecked(defenses[1]);
        d2.setClickable(false);

        final CheckBox d3 = (CheckBox) findViewById(R.id.d3);
        d3.setChecked(defenses[2]);
        d3.setClickable(false);

        final CheckBox d4 = (CheckBox) findViewById(R.id.d4);
        d4.setChecked(defenses[3]);
        d4.setClickable(false);

        final CheckBox d5 = (CheckBox) findViewById(R.id.d5);
        d5.setChecked(defenses[4]);
        d5.setClickable(false);

        final CheckBox d6 = (CheckBox) findViewById(R.id.d6);
        d6.setChecked(defenses[5]);
        d6.setClickable(false);

        final CheckBox d7 = (CheckBox) findViewById(R.id.d7);
        d7.setChecked(defenses[6]);
        d7.setClickable(false);

        final CheckBox d8 = (CheckBox) findViewById(R.id.d8);
        d8.setChecked(defenses[7]);
        d8.setClickable(false);

        final CheckBox d9 = (CheckBox) findViewById(R.id.d9);
        d9.setChecked(defenses[8]);
        d9.setClickable(false);

        final CheckBox d10 = (CheckBox) findViewById(R.id.highGoal);
        d10.setChecked(defenses[9]);
        d10.setClickable(false);

        final CheckBox d11 = (CheckBox) findViewById(R.id.lowGoal);
        d11.setChecked(defenses[10]);
        d11.setClickable(false);

        final CheckBox d12 = (CheckBox) findViewById(R.id.lift);
        d12.setChecked(defenses[11]);
        d12.setClickable(false);

        final CheckBox d13 = (CheckBox) findViewById(R.id.autonomousPoints);
        d13.setChecked(defenses[12]);
        d13.setClickable(false);

        final Button edit = (Button) findViewById(R.id.editButton);

        //confirm save dialog options
        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        Team t = MainActivity.teams.get(position);
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
                        t.defenses[12] = d13.isChecked();

                        t.notes = notesView.getText() + "";

                        MainActivity.adapter.notifyDataSetChanged();

                        SharedPreferences.Editor prefsEditor = MainActivity.mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(t);
                        prefsEditor.remove("Team " + position);
                        prefsEditor.putString("Team " + position, json);
                        prefsEditor.putInt("count", MainActivity.teams.size());
                        prefsEditor.commit();

                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked

                        break;
                }
            }
        };

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(flag)
                {
                    flag = false;
                    edit.setText("Save");
                    notesView.setFocusableInTouchMode(true);

                    d1.setClickable(true);
                    d2.setClickable(true);
                    d3.setClickable(true);
                    d4.setClickable(true);
                    d5.setClickable(true);
                    d6.setClickable(true);
                    d7.setClickable(true);
                    d8.setClickable(true);
                    d9.setClickable(true);
                    d10.setClickable(true);
                    d11.setClickable(true);
                    d12.setClickable(true);
                    d13.setClickable(true);

                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();
                }
            }
        };

        edit.setOnClickListener(listener);

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
