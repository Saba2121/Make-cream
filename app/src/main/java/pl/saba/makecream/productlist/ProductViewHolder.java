package pl.saba.makecream.productlist;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacja1.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private final TextView productNameTextView;
    private final CheckBox productCheckBox;
    private final ImageView productImage;
    private final Button productPlusBtn;
    private final Button productMinusBtn;
    private final TextView productCounterTextView;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        productNameTextView = itemView.findViewById(R.id.productName);
        productCheckBox = itemView.findViewById(R.id.productCheckBox);
        productImage = itemView.findViewById(R.id.productImage);
        productPlusBtn = itemView.findViewById(R.id.plusBtn);
        productMinusBtn = itemView.findViewById(R.id.minusBtn);
        productCounterTextView = itemView.findViewById(R.id.orderCounter);
    }

    public TextView getProductNameTextView() {
        return this.productNameTextView;
    }

    public CheckBox getProductCheckBox() {
        return this.productCheckBox;
    }

    public ImageView getProductImage() {
        return this.productImage;
    }

    public Button getProductPlusBtn() {
        return this.productPlusBtn;
    }

    public Button getProductMinusBtn() {
        return this.productMinusBtn;
    }

    public TextView getProductCounterTextView() {
        return this.productCounterTextView;
    }

}
