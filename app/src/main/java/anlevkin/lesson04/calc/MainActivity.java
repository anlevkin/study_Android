package anlevkin.lesson04.calc;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int oper = 0;
    EditText aField;
    EditText bField;
    TextView resultField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        if (savedInstanceState != null) {
            aField.setText(savedInstanceState.getString("aField"));
            bField.setText(savedInstanceState.getString("bField"));
            resultField.setText(savedInstanceState.getString("result"));
            oper = savedInstanceState.getInt("operation");
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("aField", aField.getText().toString());
        savedInstanceState.putString("bField", bField.getText().toString());
        savedInstanceState.putString("result", resultField.getText().toString());
        savedInstanceState.putInt("operation", oper);
    }

    private void initViews(){
        aField = (EditText) findViewById(R.id.fieldA);
        bField = (EditText) findViewById(R.id.fieldB);
        resultField  = (TextView) findViewById(R.id.resultField);
    }

    public void onClickCalculate(View v){
        int aInt = Integer.parseInt(aField.getText().toString());
        int bInt = Integer.parseInt(bField.getText().toString());
        int rInt = 0;

        try {
            switch (oper) {
                case 1:
                    rInt = aInt + bInt;
                    break;
                case 2:
                    rInt = aInt - bInt;
                    break;
                case 3:
                    rInt = aInt * bInt;
                    break;
                case 4:
                    rInt = aInt / bInt;
                    break;
            }
            String r = String.valueOf(rInt);
            resultField.setText(r);
        } catch (ArithmeticException e) {
            resultField.setText("Ошибка!");
        }
    }

    public void onClickPlus(View v){
        resultField.setText("");
        oper = 1;
    }

    public void onClickMinus(View v){
        resultField.setText("");
        oper = 2;
    }

    public void onClickMulti(View v){
        resultField.setText("");
        oper = 3;
    }

    public void onClickDiv(View v){
        resultField.setText("");
        oper = 4;
    }

    public void onClickAbout(View v){
        Intent intentToAbout = new Intent(this, AboutActivity.class);
        startActivity(intentToAbout);
    }


}
