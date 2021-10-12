package pl.saba.makecream;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikacja1.R;

public class SkinChooseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_choose);
        Button sensitiveSkinButton = (findViewById(R.id.sensitiveSkinBtn));
        Button drySkinButton = (findViewById(R.id.drySkinBtn));
        Button combinationSkinButton = (findViewById(R.id.combinationSkinBtn));
        Button oilySkinButton = (findViewById(R.id.oilySkinBtn));
        sensitiveSkinButton.setOnClickListener(v -> productChooseActivity(1));
        drySkinButton.setOnClickListener(v -> productChooseActivity(2));
        combinationSkinButton.setOnClickListener(v -> productChooseActivity(3));
        oilySkinButton.setOnClickListener(v -> productChooseActivity(4));

    }

    public void productChooseActivity(Integer typeOfSkin) {
        Intent intent = new Intent(this, ChooseProductActivity.class);
        intent.putExtra("typeOfSkin", typeOfSkin);
        startActivity(intent);
    }

}
