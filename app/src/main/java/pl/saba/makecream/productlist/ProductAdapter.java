package pl.saba.makecream.productlist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacja1.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<ProductDto> productList = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductDto product = productList.get(position);
        String productName = product.getProductName();
        holder.getProductNameTextView().setText(productName);
        Drawable productImage = product.getProductImage();
        holder.getProductImage().setBackground(productImage);

        CheckBox productCheckbox = holder.getProductCheckBox();
        productCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                holder.getProductNameTextView().setTextColor(ContextCompat.getColor(context, R.color.grey));
                product.addProductToOrder();

            } else {
                holder.getProductNameTextView().setTextColor(ContextCompat.getColor(context, R.color.teal_700));
                product.deleteProductFromOrder();
            }
        });

        productCheckbox.setChecked(product.getProductAddedToOrder());

        holder.getProductMinusBtn().setOnClickListener(v -> {
            if (productCheckbox.isChecked()) {
                product.decrementProductQuantity();
                this.notifyItemChanged(position);
            }
        });
        holder.getProductPlusBtn().setOnClickListener(v -> {
            if (productCheckbox.isChecked()) {
                product.incrementProductQuantity();
                this.notifyItemChanged(position);
            }

        });
        holder.getProductCounterTextView().setText(product.getProductQuantity().toString());

    }

    @Override
    public int getItemCount() {

        return productList.size();
    }

    public void setProductList(List<ProductDto> productList) {
        this.productList = productList;

    }

}

