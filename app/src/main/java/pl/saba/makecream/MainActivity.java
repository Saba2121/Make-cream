package pl.saba.makecream;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikacja1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button welcomeButton = findViewById(R.id.welcomeButton);
        welcomeButton.setOnClickListener(v -> {
            openSkinChooseActivity();
        });
    }

    public void openSkinChooseActivity() {
        Intent intent = new Intent(this, SkinChooseActivity.class);
        startActivity(intent);
    }
}
