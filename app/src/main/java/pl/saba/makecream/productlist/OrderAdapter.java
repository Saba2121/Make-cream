package pl.saba.makecream.productlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacja1.R;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {
    private List<OrderDto> orderList = new ArrayList<>();

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_product, parent, false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderDto order = orderList.get(position);
        String orderProductName = order.getOrderProductName();
        holder.getOrderProductNameTextView().setText(orderProductName);
        String orderProductCounter = order.getQuantity();
        holder.getOrderProductCounter().setText(orderProductCounter);

    }

    @Override
    public int getItemCount() {

        return orderList.size();
    }

    public void setOrderList(List<OrderDto> orderList) {
        this.orderList = orderList;
    }
}
