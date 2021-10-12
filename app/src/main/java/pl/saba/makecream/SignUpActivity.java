package pl.saba.makecream;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikacja1.R;

public class SignUpActivity extends AppCompatActivity {

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText edUserName = findViewById(R.id.userNameEditTextSU);
        EditText edPassword = findViewById(R.id.passwordEditTextSU);
        EditText edConfirmPassword = findViewById(R.id.confirmPassword);
        Button edCreateUser = findViewById(R.id.createUserBtn);

        edCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUserName = edUserName.getText().toString();
                String strPassword = edPassword.getText().toString();
                String strConfirmPassword = edConfirmPassword.getText().toString();

                if (strPassword != null && strConfirmPassword != null && strPassword.equalsIgnoreCase(strConfirmPassword)) {
                    SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("Password", strPassword);
                    editor.putString("User name", strUserName);
                    editor.commit();

                    SignUpActivity.this.finish();
                }
            }
        });
    }
}
