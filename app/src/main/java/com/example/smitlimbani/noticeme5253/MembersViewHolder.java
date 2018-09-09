package com.example.smitlimbani.noticeme5253;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.smitlimbani.noticeme5253.R;

class MembersViewHolder extends RecyclerView.ViewHolder{
    View mView;

    public TextView mDisplayName;
    public TextView mEmailId;
    public TextView mContactNo;
    public RelativeLayout mMemberCard;


    public MembersViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mDisplayName = (TextView)mView.findViewById(R.id.displayNameMC);
        mEmailId = (TextView)mView.findViewById(R.id.emailIdMC);
        mContactNo = (TextView)mView.findViewById(R.id.contactNoMC);
        mMemberCard = (RelativeLayout)mView.findViewById(R.id.memberCard);
    }
}