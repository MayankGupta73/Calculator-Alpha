package com.example.mayankgupta.calculatoralpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView calcOut;
    Button input0,input1,input2,input3,input4,input5,input6,input7,input8,input9;
    Button inputEqual, inputAdd, inputMinus, inputMult, inputDiv, Clear;

    float a=0,b=0;
    String op;
    boolean flag = false;

    void updateScreen()
    {
        if(!flag)
        {
            if(a-(int)a == 0)
                calcOut.setText(String.valueOf((int)a));
            else
            calcOut.setText(String.valueOf(a));
        }
        else
        {
            if(b-(int)b == 0)
                calcOut.setText(String.valueOf((int)b));
            else
            calcOut.setText((String.valueOf(b)));
        }
    }

    void operationSwitch()
    {
        flag = true;
        calcOut.setText(calcOut.getText()+" "+op);
    }

    void addToNum(int x)
    {
        if(!flag)
        {
            a = (a*10) + x;
            updateScreen();
        }
        else
        {
            b = (b*10) + x;
            updateScreen();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting Ids
        input0 = (Button)findViewById(R.id.input0);
        input1 = (Button)findViewById(R.id.input1);
        input2 = (Button)findViewById(R.id.input2);
        input3 = (Button)findViewById(R.id.input3);
        input4 = (Button)findViewById(R.id.input4);
        input5 = (Button)findViewById(R.id.input5);
        input6 = (Button)findViewById(R.id.input6);
        input7 = (Button)findViewById(R.id.input7);
        input8 = (Button)findViewById(R.id.input8);
        input9 = (Button)findViewById(R.id.input9);
        inputEqual = (Button) findViewById(R.id.inputEqual);
        inputAdd = (Button) findViewById(R.id.inputAdd);
        inputMinus = (Button) findViewById(R.id.inputMinus);
        inputMult = (Button) findViewById(R.id.inputMult);
        inputDiv = (Button) findViewById(R.id.inputDiv);
        Clear = (Button) findViewById(R.id.Clear);
        calcOut = (TextView) findViewById(R.id.calcOut);

        View.OnClickListener ocl = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (v.getId())
                {
                    case R.id.input0:
                        addToNum(0); break;
                    case R.id.input1:
                        addToNum(1); break;
                    case R.id.input2:
                        addToNum(2); break;
                    case R.id.input3:
                        addToNum(3); break;
                    case R.id.input4:
                        addToNum(4); break;
                    case R.id.input5:
                        addToNum(5); break;
                    case R.id.input6:
                        addToNum(6); break;
                    case R.id.input7:
                        addToNum(7); break;
                    case R.id.input8:
                        addToNum(8); break;
                    case R.id.input9:
                        addToNum(9); break;
                    case R.id.inputAdd:
                        op = "+";
                        operationSwitch();
                        break;
                    case R.id.inputMinus:
                        op = "-";
                        operationSwitch();
                        break;
                    case R.id.inputMult:
                        op = "*";
                        operationSwitch();
                        break;
                    case R.id.inputDiv:
                        op = "/";
                        operationSwitch();
                        break;
                    case R.id.Clear:
                        a=0; b=0;
                        flag = false;
                        updateScreen();
                        break;
                    case R.id.inputEqual:
                        switch (op)
                        {
                            case "+":
                                a+= b;
                                break;
                            case "-":
                                a-= b;
                                break;
                            case "*":
                                a*= b;
                                break;
                            case "/":
                                a/= b;
                                break;
                        }
                        b=0; flag=false;
                        updateScreen();
                        break;
                }
            }
        };

        Clear.setOnClickListener(ocl);
        input0.setOnClickListener(ocl);
        input1.setOnClickListener(ocl);
        input2.setOnClickListener(ocl);
        input3.setOnClickListener(ocl);
        input4.setOnClickListener(ocl);
        input5.setOnClickListener(ocl);
        input6.setOnClickListener(ocl);
        input7.setOnClickListener(ocl);
        input8.setOnClickListener(ocl);
        input9.setOnClickListener(ocl);
        inputEqual.setOnClickListener(ocl);
        inputAdd.setOnClickListener(ocl);
        inputMinus.setOnClickListener(ocl);
        inputMult.setOnClickListener(ocl);
        inputDiv.setOnClickListener(ocl);
    }
}
