package pl.saba.makecream;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacja1.R;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pl.saba.makecream.productlist.ProductAdapter;
import pl.saba.makecream.productlist.ProductBaseDto;
import pl.saba.makecream.productlist.ProductDto;


public class ChooseProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_choose);
        Integer typeOfSkin = getIntent().getIntExtra("typeOfSkin", 1);
        RecyclerView recyclerView = findViewById(R.id.productsRecyclerView);
        ProductAdapter productAdapter = new ProductAdapter();
        List<ProductDto> allProducts = Arrays.asList(
                new ProductDto("Grape seed oil - 5ml", getResources().getDrawable(R.drawable.product_1), 1),
                new ProductDto("Raspberry seed oil 5ml", getResources().getDrawable(R.drawable.product_2), 1),
                new ProductDto("Almond oil 5ml", getResources().getDrawable(R.drawable.product_3), 1),
                new ProductDto("Strawberry seed oil 5ml", getResources().getDrawable(R.drawable.product_4), 1),
                new ProductDto("Vitamin a + e 5ml", getResources().getDrawable(R.drawable.product_5), 1),
                new ProductDto("Hyaluronic acid 2% 5ml", getResources().getDrawable(R.drawable.product_6), 2),
                new ProductDto("Apricot oil 5ml", getResources().getDrawable(R.drawable.product_7), 2),
                new ProductDto("Coconut oil 5ml", getResources().getDrawable(R.drawable.product_8), 2),
                new ProductDto("Cocoa butter 5ml", getResources().getDrawable(R.drawable.product_9), 2),
                new ProductDto("Vitamin a + e 5ml", getResources().getDrawable(R.drawable.product_5), 2),
                new ProductDto("Almond oil 5ml", getResources().getDrawable(R.drawable.product_3), 3),
                new ProductDto("Tamanu oil 5ml", getResources().getDrawable(R.drawable.product_10), 3),
                new ProductDto("Argan oil 5ml", getResources().getDrawable(R.drawable.product_11), 3),
                new ProductDto("Shea butter 5ml", getResources().getDrawable(R.drawable.product_12), 3),
                new ProductDto("Hyaluronic acic 1% 5ml", getResources().getDrawable(R.drawable.product_6), 3),
                new ProductDto("Glycolic acid 5ml", getResources().getDrawable(R.drawable.product_13), 4),
                new ProductDto("Monoionic silver 5ml", getResources().getDrawable(R.drawable.product_14), 4),
                new ProductDto("Vitamin a + e 5ml", getResources().getDrawable(R.drawable.product_5), 4),
                new ProductDto("Zinc 5ml", getResources().getDrawable(R.drawable.product_15), 4),
                new ProductDto("Sulfur 5ml", getResources().getDrawable(R.drawable.product_16), 4),
                new ProductDto("Hyaluronic acid 3% 5ml", getResources().getDrawable(R.drawable.product_6), 4),
                new ProductDto("Avocado oil 5ml", getResources().getDrawable(R.drawable.product_17), 4));


//       allProducts = allProducts.stream()
//                .filter(productDto -> productDto.getTypeOfSkin().equals(typeOfSkin))
//                .collect(Collectors.toList());

        productAdapter.setProductList(allProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productAdapter);

        Button orderCreamBtn = findViewById(R.id.orderCreamBtn);
        orderCreamBtn.setOnClickListener(v -> showOrderActivity(allProducts));
    }

    public void showOrderActivity(List<ProductDto> productList) {

        List<ProductBaseDto> orderBaseProducts = productList.stream()
                .filter(productDto -> productDto.getProductAddedToOrder())
                .map(productDto -> new ProductBaseDto(productDto.getProductName(), productDto.getProductQuantity()))
                .collect(Collectors.toList());

        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("products", (Serializable) orderBaseProducts);
        startActivity(intent);


    }


}
