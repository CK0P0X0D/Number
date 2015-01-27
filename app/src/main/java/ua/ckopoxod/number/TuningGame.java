package ua.ckopoxod.number;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class TuningGame extends ActionBarActivity implements View.OnClickListener {


    public static int i=0;
    public static int GAME_MODE=0; //0-Начало игры, 1-Игра
    public static int secret;
    public static int who=-1;
    public static int nv=0; //номер выводящего сообщения
    final int DIALOG_EXIT = 1;
    Button butGetResult;
    EditText editResult; //ClearEditResult - чистое значение окна ввода
    TextView textViewInfo,textViewNumber;

    Button button01;
    Button button02;
    Button button03;
    Button button04;
    Button button05;
    Button button06;
    Button button07;
    Button button08;
    Button button09;
    Button button00;
    Button buttonDel,buttonGetResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuning_game);
        textViewInfo = (TextView)findViewById(R.id.textViewInfo);
        textViewNumber = (TextView)findViewById(R.id.TNumber);

        if (i==0 && GAME_MODE==0) {                                //первый запуск - генерируем число
            // Генерируем число от 0 до 100
            Random r = new Random();
            secret = r.nextInt(100) + 1;
            Log.d("myLog", "secret=" + secret);
            GAME_MODE=1;
            textViewNumber.setText("Число?");
            textViewInfo.setText("Начинаем игру!");
        }



        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button03 = (Button) findViewById(R.id.button03);
        button04 = (Button) findViewById(R.id.button04);
        button05 = (Button) findViewById(R.id.button05);
        button06 = (Button) findViewById(R.id.button06);
        button07 = (Button) findViewById(R.id.button07);
        button08 = (Button) findViewById(R.id.button08);
        button09 = (Button) findViewById(R.id.button09);
        button00 = (Button) findViewById(R.id.button00);
        buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonGetResult = (Button) findViewById(R.id.buttonGetResult);



        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button04.setOnClickListener(this);
        button05.setOnClickListener(this);
        button06.setOnClickListener(this);
        button07.setOnClickListener(this);
        button08.setOnClickListener(this);
        button09.setOnClickListener(this);
        button00.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
        buttonGetResult.setOnClickListener(this);

    }


    public void onClick(View v) {
        Log.d("myLog", "Нажали кнопку");
        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе
        switch (v.getId()) {
            case R.id.button01:
                Log.d("myLog", "Нажали 1");
                if (who>0){
                    who=who*10+1;
                }
                else {  who=1;  }
                break;
            case R.id.button02:
                Log.d("myLog", "Нажали 2");
                if (who>0){
                    who=who*10+2;
                }
                else {  who=2;  }
                break;
            case R.id.button03:
                Log.d("myLog", "Нажали 3");
                if (who>0){
                    who=who*10+3;
                }
                else {  who=3;  }
                break;
            case R.id.button04:
                Log.d("myLog", "Нажали 4");
                if (who>0){
                    who=who*10+4;
                }
                else {  who=4;  }
                break;
            case R.id.button05:
                Log.d("myLog", "Нажали 5");
                if (who>0){
                    who=who*10+5;
                }
                else {  who=5;  }
                break;
            case R.id.button06:
                Log.d("myLog", "Нажали 6");
                if (who>0){
                    who=who*10+6;
                }
                else {  who=6;  }
                break;
            case R.id.button07:
                Log.d("myLog", "Нажали 7");
                if (who>0){
                    who=who*10+7;
                }
                else {  who=7;  }
                break;
            case R.id.button08:
                Log.d("myLog", "Нажали 8");
                if (who>0){
                    who=who*10+8;
                }
                else {  who=8;  }
                break;
            case R.id.button09:
                Log.d("myLog", "Нажали 9");
                if (who>0){
                    who=who*10+9;
                }
                else {  who=9;  }
                break;
            case R.id.button00:
                Log.d("myLog", "Нажали 0");
                if (who>0){
                    who=who*10;
                }
                else {  who=0;  }
                break;
            case R.id.buttonDel:
                Log.d("myLog", "Нажали buttonDel");
                if (who>0){
                    who=who/10;
                }
                else {  who=-1; textViewNumber.setText("Число?");  }
                break;
            case R.id.buttonGetResult:
                Log.d("myLog", "Нажали buttonGetResult");
                WorkNumber(who);
                break;
        }

        Log.d("myLog", String.valueOf(who));
        if (who!=-1) { textViewNumber.setText(String.valueOf(who));}
        else {textViewNumber.setText("Число?");}

    }

    protected void WorkNumber (int Num) {
        //int test;
        Log.d("myLog", "Num"+Num);
        if (Num!=-1) {  //проверка на пустой ввод

            if (who>=0 && who<=100) {                      //проверка на диапазон ввода чисел (хотя минус не вводится и так)

                    i++;

                    if (i<7 || who==secret) {                                  //проверка количества попыток
                        //textViewInfo.setText("Попытка " + i);
                        //TextView (nv=1); //"Попытка " + i
                        if (who==secret) {
                            //textViewInfo.setText("Вы угадали наше число " + secret + "\nс "+ i + " попытки! :)"); showDialog(DIALOG_EXIT);
                            TextView_NumberText (nv=3);
                        }
                        else {
                            if (who<secret) {
                                //textViewInfo.setText("Попытка №"+ i +"\nВаше число меньше нашего!");
                                TextView_NumberText (nv=1);
                            }
                            else {
                                //textViewInfo.setText("Попытка №"+ i +"\nВаше число больше нашего!");
                                TextView_NumberText (nv=2);
                            }
                        }
                    }
                    else
                    {
                        //textViewInfo.setText("Вы проиграли! :("); showDialog(DIALOG_EXIT);
                        TextView_NumberText (nv=4);
                    }

            }
            else
            {
                //textViewInfo.setText("Введите плиз число от 0 до 100.");
                TextView_NumberText (nv=6);
            }
        }
        else
        {
            //textViewInfo.setText("Введите число плиз.");
            TextView_NumberText (nv=7);
        }

        //editResult.setText(""); //Сброс окна ввода )))
        who=-1; //Сброс окна ввода


        //textViewInfo.setText("\nsecret = " + secret);
    }




    protected void TextView_NumberText (int NumberText) {
        switch (NumberText) {
            case 0:   //Старт
                textViewInfo.setText("Начинаем игру!");
                break;
            case 1:
                textViewInfo.setText("Попытка №"+ i +" Ваше число меньше нашего!");
                break;
            case 2:
                textViewInfo.setText("Попытка №"+ i +" Ваше число больше нашего!");
                break;
            case 3:
                textViewInfo.setText("Вы угадали число " + secret + " с "+ i + " попытки! :)"); showDialog(DIALOG_EXIT);
                break;
            case 4:
                textViewInfo.setText("Вы проиграли! Число то было " + secret + " :("); showDialog(DIALOG_EXIT);
                break;
//            case 5:
 //               textViewInfo.setText("Введите плиз целое число.");
  //              break;
            case 6:
                textViewInfo.setText("Введите плиз число от 0 до 100.");
                break;
            case 7:
                textViewInfo.setText("Введите число плиз.");
                break;

        }
    }



    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView_NumberText(nv);
        if (who==-1) {  textViewNumber.setText("Число?"); }
    }




    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            // заголовок
            if (nv==3)
            { adb.setTitle(R.string.win);}
            else
            { adb.setTitle(R.string.lose);}
            // сообщение
            adb.setIcon(android.R.drawable.ic_dialog_info);
            // кнопка положительного ответа
            adb.setPositiveButton(R.string.ok, myClickListener);
            // запретить отмену диалового окна
            adb.setCancelable(false);
            // создаем диалог
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                // положительная кнопка
                case Dialog.BUTTON_POSITIVE:
                    i=0;
                    nv=0;
                    who=-1;
                    GAME_MODE=0;
                    finish();
                    break;
            }
        }
    };
}
