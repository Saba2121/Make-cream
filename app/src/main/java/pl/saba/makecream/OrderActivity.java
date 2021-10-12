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

import java.util.List;
import java.util.stream.Collectors;

import pl.saba.makecream.productlist.OrderAdapter;
import pl.saba.makecream.productlist.OrderDto;
import pl.saba.makecream.productlist.ProductBaseDto;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        RecyclerView recyclerView = findViewById(R.id.orderProductsRecyclerView);
        Intent i = getIntent();
        List<ProductBaseDto> products = (List<ProductBaseDto>) i.getSerializableExtra("products");
        products.stream()
                .forEach(productBaseDto -> System.out.println(productBaseDto.getProductName() + " " + productBaseDto.getQuantity()));

        OrderAdapter orderAdapter = new OrderAdapter();
        List<OrderDto> orderList = products.stream()
                .map(productBaseDto -> new OrderDto(productBaseDto.getProductName(), productBaseDto.getQuantity().toString()))
                .collect(Collectors.toList());

        orderAdapter.setOrderList(orderList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(orderAdapter);

        Button orderNow = findViewById(R.id.orderBtn);
        orderNow.setOnClickListener(v -> openLoginActivity());

    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
