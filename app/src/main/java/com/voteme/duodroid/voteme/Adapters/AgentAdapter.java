package com.voteme.duodroid.voteme.Adapters;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.voteme.duodroid.voteme.MainActivity;
import com.voteme.duodroid.voteme.R;
import com.voteme.duodroid.voteme.model.Agent;
import com.voteme.duodroid.voteme.model.Poste;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mohamed chiheb on 27/11/2016.
 */

public class AgentAdapter extends RecyclerView.Adapter<AgentAdapter.CustomViewHolder> implements View.OnClickListener {

    private List<Agent> data;
    private Context mContext;
    private DatabaseReference mDatabase;
    String name;
    Agent a;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    public AgentAdapter(Context context, List<Agent> data) {
        this.mContext=context;
        this.data=data;
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.agent_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        final Agent voit = data.get(i);



        //Setting text view title
        customViewHolder.tv_name.setText(voit.getName());
        customViewHolder.tv_score.setText(" "+voit.getScore()+" Points");

        customViewHolder.tv_poste.setText(" "+voit.getCode_pst());
        customViewHolder.btn_voit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAgentScore(Integer.parseInt(voit.getKeyid()),voit.getScore(),true);
            }
        });
        customViewHolder.btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAgentScore(Integer.parseInt(voit.getKeyid()),voit.getScore(),false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onClick(View v) {


    }
    public String getPosteById(final int id)
    {
         name="";
        mDatabase = database.getReference("/poste");

        Log.d("test","entrer");
        //mDatabase.child("/agent");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d("Count " ,""+snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Poste post = postSnapshot.getValue(Poste.class);
                    if(Integer.parseInt(postSnapshot.getKey().toString())==id)
                    {
                        Log.d("Get Name Data",  post.getName());
                        name= post.getName();
                    }


                    //Log.d("Get Data", post.getName());
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        return name;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_name;
        protected TextView tv_score;
        protected TextView tv_poste;
        protected ImageButton btn_voit;
        protected ImageButton btn_down;


        public CustomViewHolder(View view) {
            super(view);

            this.tv_name = (TextView) view.findViewById(R.id.tv_name);
            this.tv_score=(TextView)view.findViewById(R.id.tv_score);
            this.tv_poste=(TextView)view.findViewById(R.id.tv_poste);
            this.btn_voit=(ImageButton)view.findViewById(R.id.btn_vote);
            this.btn_down=(ImageButton)view.findViewById(R.id.btn_down);


        }
    }
    public void updateAgentScore(final int key,final int score, final boolean b)
    {
        mDatabase = database.getReference("/agent");

        Log.d("test","entrer");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d("Count " ,""+snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {

                    if(Integer.parseInt(postSnapshot.getKey())==key)
                    {
                        a = postSnapshot.getValue(Agent.class);
                        Log.d("Get Data",  postSnapshot.getKey());
                    }


                }
                Map<String,Object> taskMap = new HashMap<String,Object>();
                if(b){
                    taskMap.put("score", score+1);
                }else {
                    taskMap.put("score", score-1);
                }

                mDatabase.child(Integer.toString(key)).updateChildren(taskMap);
                Intent i=new Intent(mContext, MainActivity.class);
                mContext.startActivity(i);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

}
