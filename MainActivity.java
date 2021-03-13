package com.example.parser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.stanford.nlp.trees.Tree;


public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView output;
    Button parse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.inputEdx);
        output = findViewById(R.id.outputTxt);
        parse = findViewById(R.id.button);
        Translate translate = new Translate();

        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputSentence = input.getText().toString();
                Tree tree = translate.parse(inputSentence);
                String treeOutput = tree.toString();
                output.setText(treeOutput);
            }
        });
    }





}