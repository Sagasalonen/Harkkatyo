package com.example.harkkatyo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView lutemonName,lutemonAttacks,lutemonDefences, lutemonLives,lutemonExperiencePoints;
    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        // tähän add contact näkymästä kaikki jutut tähän tyyliin:  contactName = itemView.findViewById(R.id.ContactNameText);
        //        contactNumber = itemView.findViewById(R.id.ContactNumberText);
        //        contactGroup = itemView.findViewById(R.id.ContactGroupText);
        //
        //        deleteContact = itemView.findViewById(R.id.ContactDeleteButton);
        //        detailsContact=itemView.findViewById(R.id.ContactDetailsButton);
    }
}
