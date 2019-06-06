package com.example.menudemojava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Элементы экрана
    TextView tv;
    CheckBox chb;
    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int n1=1;
    int n2=100;
    int random = n1 + (int) (Math.random() * n2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // находим элементы
        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);
        tvInfo = findViewById(R.id.textView_info);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);

        tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")");


        View.OnClickListener clickListener_control = new View.OnClickListener() {
            @Override
            public void onClick(View v) { //обрабатывает нажатие кнопочки "Ввести число"
                String value = etInput.getText().toString();
                tvInfo.setText(value);

                if (value.trim().length() == 0) {
                    tvInfo.setText("Введите число! ("+n1+"-"+n2+")");
                }
                else {
                    int valint = Integer.parseInt(value);
                    if ((valint>n2) || (valint<n1)) {
                        tvInfo.setText("Введенное число вне границ диапазона!  ("+n1+"-"+n2+")");
                    }
                    else if (valint==random) {
                        tvInfo.setText("Вы выиграли!");

                    }
                    else if (valint<random) {
                        tvInfo.setText("Недолет  ("+n1+"-"+n2+")");
                    }
                    else {
                        tvInfo.setText("Перелет ("+n1+"-"+n2+")");
                    }

                }

            }
        };

        bControl.setOnClickListener(clickListener_control);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    // обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    // обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        if (item.getTitle().toString().equals("EASY")) {
            n1 = 1;
            n2 = 100;
            tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")");
            random = n1 + (int) (Math.random() * n2);
            etInput.setText(null);

        }
        else if (item.getTitle().toString().equals("MEDIUM")) {
            n1 = 1;
            n2 = 1000;
            tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")");
            random = n1 + (int) (Math.random() * n2);
            etInput.setText(null);

        }
        else if (item.getTitle().toString().equals("HARD")) {
            n1 = 1;
            n2 = 10000;
            tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")");
            random = n1 + (int) (Math.random() * n2);
            etInput.setText(null);

        }
        else if (item.getTitle().toString().equals("EXIT")) {
            finish();
        }
        else if (item.getTitle().toString().equals("START")) {
            n1 = 1;
            n2 = 100;
            tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")");
            random = n1 + (int) (Math.random() * n2);
            etInput.setText(null);

        }

//        sb.append("Item Menu");
//        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
//        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
//        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
//        sb.append("\r\n title: " + item.getTitle());
//        tv.setText(sb.toString());

        return super.onOptionsItemSelected(item);
    }


}
