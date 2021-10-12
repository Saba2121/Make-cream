package pl.saba.makecream.productlist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacja1.R;

public class OrderViewHolder extends RecyclerView.ViewHolder {
    private TextView orderProductNameTextView;
    private TextView orderProductCounter;


    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        orderProductNameTextView = itemView.findViewById(R.id.orderProductName);
        orderProductCounter = itemView.findViewById(R.id.orderProductCounter);


    }

    public TextView getOrderProductNameTextView() {
        return this.orderProductNameTextView;
    }

    public TextView getOrderProductCounter() {
        return this.orderProductCounter;
    }


}
