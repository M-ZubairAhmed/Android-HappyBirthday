package com.mastermindapps.happybirthday;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawingLayout();
    }

    @Override
    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to quit this amazing app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"How could you be so heartless?",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .setCancelable(false)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"You are a good soul",Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }

    protected void drawingLayout() {
        //Root layout
        android.support.constraint.ConstraintLayout rootLayout = (android.support.constraint.ConstraintLayout) findViewById(R.id.root_layout);
        rootLayout.setBackgroundResource(R.drawable.androidparty);

        //Text view
        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText(R.string.happy_birthday);
        textView.setTextColor(ContextCompat.getColor(this,R.color.colorAccent));
        textView.setAllCaps(true);
        textView.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        android.support.constraint.ConstraintLayout.LayoutParams params = new android.support.constraint.ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int dpForPadding = (int)convertDpPx(28);
        textView.setPadding(dpForPadding,dpForPadding,dpForPadding,dpForPadding);
        textView.setTextSize(22);
    }

    protected float convertDpPx(float dp){
        float density = getApplicationContext().getResources().getDisplayMetrics().density;
        return dp * density;
    }
}
