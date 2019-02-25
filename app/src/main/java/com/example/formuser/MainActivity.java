package com.example.formuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtLastName;
    private TextView txtEmail;
    private TextView txtPassword;
    private RadioGroup rd;
    private Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = getIntent();

        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btSave = findViewById(R.id.btSave);

//        RadioGroup radioGroup = findViewById(R.id.radioGroup);
//        if (radioGroup.getCheckedRadioButtonId() == R.id.radioGroup) {
//            // radioButton selecionado
////            RadioGroup rd = radioGroup.getCheckedRadioButtonId();
//        }

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtName.getText().toString().isEmpty() || txtLastName.getText().toString().isEmpty()
                        || txtEmail.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Todos os campos são obigatórios", Toast.LENGTH_LONG).show();
                } else {

                    UserParcelable userParcelable = new UserParcelable(txtName.getText().toString(), txtLastName.getText().toString(),
                            txtEmail.getText().toString(), txtPassword.getText().toString());

                    if (intent != null) {
                        intent.putExtra("NOME", userParcelable.getNome());
                        intent.putExtra("SOBRENOME", userParcelable.getSobrenome());
                        intent.putExtra("EMAIL", userParcelable.getEmail());
                        intent.putExtra("SENHA", userParcelable.getPassword());
                        setResult(RESULT_OK, intent);
                        MainActivity.this.finish();
                    }
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        UserParcelable userParcelable = new UserParcelable(
                txtName.getText().toString(), txtLastName.getText().toString(),
                txtEmail.getText().toString(), txtPassword.getText().toString());

        outState.putParcelable("USUARIO_PARCELABLE", userParcelable);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        UserParcelable userParcelable = savedInstanceState.getParcelable("USUARIO_PARCELABLE");
        if(userParcelable != null) {
            Log.d(getClass().getName(), userParcelable.getNome());
        }
    }
}
