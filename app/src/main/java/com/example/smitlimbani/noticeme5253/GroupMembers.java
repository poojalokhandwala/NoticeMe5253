package com.example.smitlimbani.noticeme5253;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class GroupMembers extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private RecyclerView mMembersList;
    private FirebaseRecyclerAdapter<UserDetails, MembersViewHolder> firebaseRecyclerAdapter;
    private String groupId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_members);

        mMembersList = (RecyclerView)findViewById(R.id.membersList);
        mMembersList.setHasFixedSize(true);
        groupId = getIntent().getExtras().getString("group_id");
        String groupId = getIntent().getExtras().getString("group_id");
        Query keyQuery = databaseReference.child("is_from").child(groupId);

        FirebaseRecyclerOptions<UserDetails> options = new FirebaseRecyclerOptions.Builder<UserDetails>()
                .setIndexedQuery(keyQuery, firebaseDatabase.getReference().child("user_details"),UserDetails.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<UserDetails, MembersViewHolder>(options) {
            @NonNull
            @Override
            public MembersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_card, parent, false);
                return new MembersViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull MembersViewHolder holder, int position, @NonNull UserDetails model) {

                holder.mDisplayName.setText(model.getDisplayName());
                holder.mContactNo.setText(model.getContactNo());
                holder.mEmailId.setText(model.getEmailId());
            }
        };

        mMembersList.setLayoutManager(new LinearLayoutManager(this));
        firebaseRecyclerAdapter.startListening();
        mMembersList.setAdapter(firebaseRecyclerAdapter);

    }

//    public class MembersViewHolder extends RecyclerView.ViewHolder{
//        View mView;
//
//        public TextView mDisplayName;
//        public TextView mEmailId;
//        public TextView mContactNo;
//
//        public MembersViewHolder(View itemView) {
//            super(itemView);
//            mView = itemView;
//            mDisplayName = (TextView)mView.findViewById(R.id.displayNameMC);
//            mEmailId = (TextView)mView.findViewById(R.id.emailIdMC);
//            mContactNo = (TextView)mView.findViewById(R.id.contactNoMC);
//
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseRecyclerAdapter.startListening();
    }

    public void addMember(View view)
    {
        startActivity(new Intent(GroupMembers.this, AddMember.class).putExtra("gid", groupId));
    }
}
