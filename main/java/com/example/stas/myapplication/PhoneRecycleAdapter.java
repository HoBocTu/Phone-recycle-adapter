package com.example.stas.myapplication;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stas.myapplication.Phone;
import com.example.stas.myapplication.R;

import java.util.List;

public class PhoneRecycleAdapter extends RecyclerView.Adapter<PhoneRecycleAdapter.PhoneVH> {

    List<Phone> panList;

    public PhoneRecycleAdapter(List<Phone> carList) {
        this.panList = carList;
    }

    @NonNull
    @Override
    public PhoneVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.nice_phone_item, viewGroup, false);

        return new PhoneVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneVH phoneVH, final int i) {
        final Phone phone = panList.get(i);

        phoneVH.phoneImage.setImageResource(phone.getImageResourceId());
        phoneVH.phoneName.setText(phone.getName());
        phoneVH.panDescription.setText(phone.getDesk());
        phoneVH.phoneCard.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(v.getContext(), Main2Activity.class);
                                                  intent.putExtra("Phone", phone);
                                                 // ((Phone)intent.getSerializableExtra("phone")).getName();
                                                  System.out.printf("Yeah\n");
                                                  v.getContext().startActivity(intent);
                                              }
                                          }
        );
        phoneVH.phoneCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                panList.remove(i);
                notifyItemRemoved(i);
                notifyItemChanged(i);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return panList.size();
    }

    class PhoneVH extends RecyclerView.ViewHolder {
        private ImageView phoneImage;
        private TextView phoneName;
        private TextView panDescription;
        private CardView phoneCard;

        public PhoneVH(@NonNull View itemView) {
            super(itemView);

            phoneImage = itemView.findViewById(R.id.phoneImage);
            phoneName= itemView.findViewById(R.id.phoneName);
            panDescription = itemView.findViewById(R.id.phoneDescription);
            phoneCard = itemView.findViewById(R.id.phoneCard);
        }
    }
}
