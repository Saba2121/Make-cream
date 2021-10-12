package pl.saba.makecream;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikacja1.R;

public class LoginActivity extends AppCompatActivity {

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edUserName = findViewById(R.id.userNameEditText);
        EditText edPassword = findViewById(R.id.passwordEditText);
        Button loginBtn = findViewById(R.id.loginBtn);
        Button signUpBtn = findViewById(R.id.signUpBtn);

        signUpBtn.setOnClickListener(v -> openSignUpActivity());
        loginBtn.setOnClickListener(v -> {
            SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
            String strUserName = credentials.getString("User name", null);
            String strPassword = credentials.getString("Password", null);

            String userName_from_ed = edUserName.getText().toString();
            String password_from_ed = edPassword.getText().toString();

            if (strUserName != null && userName_from_ed != null && strUserName.equalsIgnoreCase(userName_from_ed)) {
                if (strPassword != null && password_from_ed != null && strPassword.equalsIgnoreCase(password_from_ed)) {
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void openSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}

