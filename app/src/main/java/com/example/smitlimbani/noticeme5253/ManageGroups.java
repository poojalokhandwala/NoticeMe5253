package com.example.smitlimbani.noticeme5253;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextClock;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

public class ManageGroups extends AppCompatActivity {


    private RecyclerView mGroupList;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();
    private FirebaseRecyclerAdapter<GroupDetails, GroupViewHolder> firebaseRecyclerAdapter;
    private TextView mgn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_groups);

        mGroupList = (RecyclerView) findViewById(R.id.groupList);

        mGroupList.setHasFixedSize(true);

        Query query = mDatabaseReference.child("groups").orderByChild("group_admin").equalTo(mAuth.getCurrentUser().getUid().toString());

        FirebaseRecyclerOptions<GroupDetails> options = new FirebaseRecyclerOptions.Builder<GroupDetails>().setQuery(query, GroupDetails.class).build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<GroupDetails, GroupViewHolder>(options) {

            @NonNull
            @Override
            public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_group, parent, false);
                return new GroupViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull GroupViewHolder holder, int position, @NonNull GroupDetails model) {
                holder.mGroupName.setText(model.getGroup_name().toString());
                holder.mOrgName.setText(model.getOrg_name().toString());
            }
        };

        mGroupList.setLayoutManager(new LinearLayoutManager(this));
        firebaseRecyclerAdapter.startListening();
        mGroupList.setAdapter(firebaseRecyclerAdapter);

    }

    public class GroupViewHolder extends RecyclerView.ViewHolder{

        public TextView mGroupName;
        public TextView mOrgName;

        public GroupViewHolder(View itemView) {
            super(itemView);
            mGroupName=(TextView)itemView.findViewById(R.id.groupName);
            mOrgName=(TextView)itemView.findViewById(R.id.orgName);
        }
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(firebaseRecyclerAdapter!=null)
//        {
//            firebaseRecyclerAdapter.startListening();
//        }
//    }
}
