package com.example.calc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CaclFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button zero, one, two, three, four, five, six, seven, eight,
            nine, clear, plus, minus, division, multiply, equals, save;
    private Double firstValues;
    private Double secondValues;
    private String operation;
    private Double result;
    private TextView textView;
    private MyInterface callback;
    public CaclFragment(MyInterface callback) {
        this.callback = callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cacl, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListeners();
        saveClick();

    }
     private void saveClick(){
         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (textView.getText() != null){
                    callback.save(textView.getText().toString());
                 }
             }
         });
     }

    private void initView() {
        textView = view.findViewById(R.id.result_field);
        save = view.findViewById(R.id.save);
        zero = view.findViewById(R.id.zero);
        one = view.findViewById(R.id.one);
        two = view.findViewById(R.id.two);
        three = view.findViewById(R.id.three);
        four = view.findViewById(R.id.four);
        five = view.findViewById(R.id.five);
        six = view.findViewById(R.id.six);
        seven = view.findViewById(R.id.seven);
        eight = view.findViewById(R.id.eight);
        nine = view.findViewById(R.id.nine);
        clear = view.findViewById(R.id.clear);
        plus = view.findViewById(R.id.plus);
        minus = view.findViewById(R.id.minus);
        division = view.findViewById(R.id.division);
        multiply = view.findViewById(R.id.multiply);
        equals = view.findViewById(R.id.equal);
    }

    private void initListeners() {
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        division.setOnClickListener(this);
        multiply.setOnClickListener(this);
        equals.setOnClickListener(this);
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        clear.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        translateIdToIndex(view.getId());
        switch (v.getId()) {
            case R.id.zero:
                textView.append("0");
                break;
            case R.id.one:
                textView.append("1");
                break;
            case R.id.two:
                textView.append("2");
                break;
            case R.id.three:
                textView.append("3");
                break;
            case R.id.four:
                textView.append("4");
                break;
            case R.id.five:
                textView.append("5");
                break;
            case R.id.six:
                textView.append("6");
                break;
            case R.id.seven:
                textView.append("7");
                break;
            case R.id.eight:
                textView.append("8");
                break;
            case R.id.nine:
                textView.append("9");
                break;
            case R.id.clear:
                textView.setText("");
                break;
            case R.id.plus:
                operation(R.id.plus);
                break;
            case R.id.minus:
                operation(R.id.minus);
                break;
            case R.id.multiply:
                operation(R.id.multiply);
                break;
            case R.id.division:
                operation(R.id.division);
                break;
            case R.id.equal:
                operation(R.id.equal);
                break;
        }
    }
    public void operation(int id) {
        switch (id) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "+");
                break;
            case R.id.minus:
                operation = "-";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "-");
                break;
            case R.id.multiply:
                operation = "*";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "*");
                break;
            case R.id.division:
                operation = "/";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "/");
                break;
            case R.id.equal:
                if (operation != null) {
                    String second = textView.getText().toString().replace(firstValues + operation + "", "");
                    secondValues = Double.valueOf(second);
                    switch (operation) {
                        case "+":
                            result = firstValues + secondValues;
                            textView.setText(firstValues + "+" + secondValues + "=" + result);
                            break;
                        case "-":
                            result = firstValues - secondValues;
                            textView.setText(firstValues + "-" + secondValues + "=" + result);
                            break;
                        case "*":
                            result = firstValues * secondValues;
                            textView.setText(firstValues + "*" + secondValues + "=" + result);
                            break;
                        case "/":
                            result = firstValues / secondValues;
                            textView.setText(firstValues + "/" + secondValues + "=" + result);
                            break;
                    }
                }
            default:
                break;
        }
    }

}

