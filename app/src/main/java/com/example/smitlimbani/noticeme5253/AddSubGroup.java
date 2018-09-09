package com.example.smitlimbani.noticeme5253;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class AddSubGroup extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private RecyclerView mGroupsList;
    private FirebaseRecyclerAdapter<GroupDetails, GroupViewHolder> firebaseRecyclerAdapter;
    private ImageButton mSearch;
    private EditText mSearchBox;
    private String searchQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sub_group);

        mSearch = (ImageButton) findViewById(R.id.searchGroupBtn);

        mSearchBox = (EditText) findViewById(R.id.searchGroupBox);

        mGroupsList = (RecyclerView) findViewById(R.id.searchGroupList);
        mGroupsList.setHasFixedSize(true);

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchQuery = mSearchBox.getText().toString();
                userSearch(searchQuery);
            }
        });

    }

    public void userSearch(String searchString) {
        Query query = databaseReference.child("groups").orderByChild("group_name").startAt(searchString).endAt(searchString + "\uf8ff");

        FirebaseRecyclerOptions<GroupDetails> options = new FirebaseRecyclerOptions.Builder<GroupDetails>()
                .setQuery(query, GroupDetails.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<GroupDetails, GroupViewHolder>(options) {
            @NonNull
            @Override
            public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_group, parent, false);
                return new GroupViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull final GroupViewHolder holder, final int position, @NonNull final GroupDetails model) {

                holder.mGroupName.setText(model.getGroup_name().toString());
                holder.mOrgName.setText(model.getOrg_name().toString());

                holder.mGroupName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        databaseReference.child("can_post_to").child(getIntent().getExtras().getString("gid")).child(getRef(holder.getAdapterPosition()).getKey()).setValue(true);

                        Toast.makeText(getApplicationContext(), model.getGroup_name() + " added to the group", Toast.LENGTH_LONG).show();
                    }
                });
            }
        };

        mGroupsList.setLayoutManager(new LinearLayoutManager(this));
        firebaseRecyclerAdapter.startListening();
        mGroupsList.setAdapter(firebaseRecyclerAdapter);
    }


}
