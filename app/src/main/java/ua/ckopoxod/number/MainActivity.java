package ua.ckopoxod.number;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    public static int i=0;
    public static int GAME_MODE=0; //0-Начало игры, 1-Игра
    public static int secret;
    public static float who;
    public static int nv=0; //номер выводящего сообщения
    final int DIALOG_EXIT = 1;
    Button butGetResult;
    EditText editResult; //ClearEditResult - чистое значение окна ввода
    TextView textViewInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (i==0 && GAME_MODE==0) {                                //первый запуск - генерируем число
            // Генерируем число от 0 до 100
            Random r = new Random();
            secret = r.nextInt(100) + 1;
            Log.d("myLog", "secret=" + secret);
            GAME_MODE=1;
        }

        butGetResult = (Button)findViewById(R.id.buttonGetResult);
        editResult = (EditText)findViewById(R.id.editText);
        textViewInfo = (TextView)findViewById(R.id.textViewInfo);
    }


    public void onClick(View v) {
        int test;

        if (editResult.getText().toString().length()>0) {  //проверка на пустой ввод
            who = Float.parseFloat(editResult.getText().toString());
            test = (int) who;
            if (who>=0 && who<=100) {                      //проверка на диапазон ввода чисел (хотя минус не вводится и так)
                if (who==test) {                           //проверка на введенное число - целое ли оно

                    i++;

                    if (i<7) {                                  //проверка количества попыток
                        //textViewInfo.setText("Попытка " + i);
                        //TextView (nv=1); //"Попытка " + i
                        if (who==secret) {
                            //textViewInfo.setText("Вы угадали наше число " + secret + "\nс "+ i + " попытки! :)"); showDialog(DIALOG_EXIT);
                            TextViewNumberText (nv=3);
                        }
                        else {
                            if (who<secret) {
                                //textViewInfo.setText("Попытка №"+ i +"\nВаше число меньше нашего!");
                                TextViewNumberText (nv=1);
                            }
                            else {
                                //textViewInfo.setText("Попытка №"+ i +"\nВаше число больше нашего!");
                                TextViewNumberText (nv=2);
                            }
                        }
                    }
                    else
                    {
                        //textViewInfo.setText("Вы проиграли! :("); showDialog(DIALOG_EXIT);
                        TextViewNumberText (nv=4);
                    }
                }
                else
                {
                    //textViewInfo.setText("Введите плиз целое число.");
                    TextViewNumberText (nv=5);
                }
            }
            else
            {
                //textViewInfo.setText("Введите плиз число от 0 до 100.");
                TextViewNumberText (nv=6);
            }
        }
        else
        {
            //textViewInfo.setText("Введите число плиз.");
            TextViewNumberText (nv=7);
        }

        editResult.setText(""); //Сброс окна ввода )))

        //textViewInfo.setText("\nsecret = " + secret);
    }



    protected void TextViewNumberText (int NumberText) {
        switch (NumberText) {
            case 0:   //Старт
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
            case 5:
                textViewInfo.setText("Введите плиз целое число.");
                break;
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
        TextViewNumberText(nv);
    }




    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            // заголовок
            if (nv==3) { adb.setTitle(R.string.exitwin);}
            else { adb.setTitle(R.string.exitlose);}
            // сообщение
            adb.setIcon(android.R.drawable.ic_dialog_info);
            // кнопка положительного ответа
            adb.setPositiveButton(R.string.yes, myClickListener);
            // кнопка отрицательного ответа
            adb.setNegativeButton(R.string.no, myClickListener);
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
                    GAME_MODE=0;
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    break;
                // негативная кнопка
                case Dialog.BUTTON_NEGATIVE:
                    finish();
                    break;
            }
        }
    };
}
