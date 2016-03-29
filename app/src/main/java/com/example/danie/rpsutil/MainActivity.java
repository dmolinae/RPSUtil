package com.example.danie.rpsutil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView_horas;
    private TextView textView_precio;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button button_ac;
    private Button button_del;

    private Button button_sd;
    private Button button_50;
    private Button button_75;

    private String primera_hora;
    private String segunda_hora;
    private Integer hrs1,hrs2,mins1,mins2,rest_hrs,rest_mins,precio;
    private Float rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_horas = (TextView)findViewById(R.id.textView_horas);
        textView_precio = (TextView)findViewById(R.id.textView_precio);
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button_ac = (Button)findViewById(R.id.button_ac);
        button_del = (Button)findViewById(R.id.button_del);

        button_sd = (Button)findViewById(R.id.button_sd);
        button_50 = (Button)findViewById(R.id.button_50);
        button_75 = (Button)findViewById(R.id.button_75);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText(textView_horas.getText()+"9");
            }
        });

        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_horas.setText("");
            }
        });

        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView_horas.getText().toString().substring(textView_horas.length()-1,textView_horas.length()).equals(":")){
                    textView_horas.setText(textView_horas.getText().toString().substring(0,textView_horas.getText().length()-2));
                }
                else if(textView_horas.getText().toString().substring(textView_horas.length()-1,textView_horas.length()).equals(" ")){
                    textView_horas.setText(textView_horas.getText().toString().substring(0,textView_horas.getText().length()-4));
                }
                else {
                    textView_horas.setText(textView_horas.getText().toString().substring(0, textView_horas.getText().length() - 1));
                }
            }
        });

        button_sd.setOnClickListener(new View.OnClickListener() {
            Integer result;
            @Override
            public void onClick(View v) {
                result = precio;
                textView_precio.setText("$ "+result.toString());
            }
        });

        button_50.setOnClickListener(new View.OnClickListener() {
            Integer result;
            @Override
            public void onClick(View v) {
                result = (precio/2);
                textView_precio.setText("$ "+result.toString());
            }
        });

        button_75.setOnClickListener(new View.OnClickListener() {
            Integer result;
            @Override
            public void onClick(View v) {
                result = (precio/4);
                textView_precio.setText("$ "+result.toString());
            }
        });


        textView_horas.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 13) {
                    textView_precio.setText("");
                    if (s.length() == 2) {
                        textView_horas.setText(textView_horas.getText().toString() + ":");
                    }
                    if (s.length() == 5) {
                        textView_horas.setText(textView_horas.getText().toString() + " - ");
                    }
                    if (s.length() == 10) {
                        textView_horas.setText(textView_horas.getText().toString() + ":");
                    }
                } else {
                    primera_hora = s.toString().substring(0, 2) + s.toString().substring(3, 5);
                    segunda_hora = s.toString().substring(8, 10) + s.toString().substring(11, 13);

                    hrs1 = Integer.parseInt(primera_hora.substring(0, 2));
                    hrs2 = Integer.parseInt(segunda_hora.substring(0, 2));

                    mins1 = Integer.parseInt(primera_hora.substring(2, 4));
                    mins2 = Integer.parseInt(segunda_hora.substring(2, 4));

                    if (hrs1 <= hrs2) {
                        rest_hrs = hrs2 - hrs1;
                    } else {
                        rest_hrs = (hrs2 + 24) - hrs1;
                    }

                    if (mins1 <= mins2) {
                        rest_mins = mins2 - mins1;
                    } else {
                        rest_mins = (60 - mins1) + mins2;
                        rest_hrs--;
                    }
                    rest = ((rest_hrs.floatValue() * 60) + rest_mins.floatValue()) / 60;

                    precio = rest_hrs * 1000;

                    if (rest_mins <= 30 && rest_mins > 0) {
                        precio = precio + 500;
                    }
                    if (rest_mins > 30) {
                        precio = precio + 1000;
                    }

                    if (precio > 6000) {
                        precio = 6000;
                    }
                    if (rest < 0.17) {
                        precio = 0;
                    }
                    textView_precio.setText("$ " + precio.toString());
                }
            }
        });


    }
}
