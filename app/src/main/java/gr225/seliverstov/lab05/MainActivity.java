package gr225.seliverstov.lab05;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txt;
    CheckBox chk1, chk2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.Message);
        chk1 = findViewById(R.id.OneChek);
        chk2 = findViewById(R.id.TwoCheck);

        Intent i = getIntent();




    }

    public void On_Dialog_Click(View v)
    {
         
    String s = txt.getText().toString();

    Intent i = new Intent(this, MainActivity2.class);
    i.putExtra("abc", s);

    i.putExtra("1Chek", chk1.isChecked());
    i.putExtra("2Chek", chk2.isChecked());

    startActivityForResult(i, 555);
    }
    public void ExitButton(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to leave?")
                .setTitle("Dialog Title")
                .setIcon(R.drawable.exitimage)
                .setPositiveButton("OK", new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        finish(); // Выход из текущей активности
       }
    })
        .setNegativeButton("Cansel", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public  void DIALOG(View v)
    {
        if (txt.getText().toString() == " "){

            Toast.makeText(this, "Empty Text", Toast.LENGTH_SHORT).show();
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Title");
        alert.setMessage(txt.getText().toString());

// Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = String.valueOf(input.getText());
                // Do something with value!
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });


        alert.show();
    }
    protected void  onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {

        if (requestCode == 555)
        {
            if (data != null)
            {
                boolean cch1 = data.getBooleanExtra("1Switch", false);
                if (cch1 == true) chk1.setChecked(true);
                else if (cch1 == false) chk1.setChecked(false);
                boolean cch2 = data.getBooleanExtra("2Switch", false);
                if (cch2 == true) chk2.setChecked(true);
                else if (cch2 == false) chk2.setChecked(false);
                String s  = data.getStringExtra("qwe");
                txt.setText(s);


            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

