package anlevkin.lesson04.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    TextView skillsField;
    String[] skilsArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initViews();
        writeSkills();

    }

    private void initViews(){
        skillsField = (TextView) findViewById(R.id.skillsField);
        skilsArr = getResources().getStringArray(R.array.skills);
    }

    private void writeSkills (){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < skilsArr.length; i++) {

            builder.append("- " + skilsArr[i]);
            builder.append("\n");
        }
        skillsField.setText(builder.toString());
    }
}
