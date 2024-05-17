package gr225.seliverstov.lab05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
EditText txt2;
Switch sw1, sw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

    txt2 = findViewById(R.id.Message2);
    sw1 = findViewById(R.id.OneSwitch);
    sw2 = findViewById(R.id.TwoSwitch);

    Intent i = getIntent();

        boolean ssw1 = i.getBooleanExtra("1Chek", false);
        if (ssw1 == true) sw1.setChecked(true);
        if (ssw1 == false) sw1.setChecked(false);
        boolean ssw2 = i.getBooleanExtra("2Chek", false);
        if (ssw2 == true) sw2.setChecked(true);
        if (ssw2 == false) sw2.setChecked(false);

        String s  = i.getStringExtra("abc");
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();


    }
    public void on_ok_click(View v){

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("1Switch", sw1.isChecked());
        i.putExtra("2Switch", sw2.isChecked());
        String s = txt2.getText().toString();
        i.putExtra("qwe", s);

        setResult(RESULT_OK, i);
        finish();
    }
    public void cansel_click(View v)
    {
     setResult(RESULT_CANCELED);
     finish();
    }

}