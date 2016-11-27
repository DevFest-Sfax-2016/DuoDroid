package com.voteme.duodroid.voteme.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.voteme.duodroid.voteme.MyDialog;
import com.voteme.duodroid.voteme.R;
import com.voteme.duodroid.voteme.model.Agent;

import java.util.List;

/**
 * Created by Mohamed chiheb on 27/11/2016.
 */

public class AgentAdapter extends RecyclerView.Adapter<AgentAdapter.CustomViewHolder> implements View.OnClickListener {

    private List<Agent> data;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    public AgentAdapter(Context context, List<Agent> data) {
        this.mContext=context;
        this.data=data;

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
        customViewHolder.tv_score.setText("Score: "+voit.getScore());
        customViewHolder.tv_poste.setText("Poste: "+voit.getCode_pst());
        customViewHolder.btn_voit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder  builder  = new AlertDialog.Builder(mContext, R.style.MyAlertDialogStyleSuccess);

                builder.setIcon(R.drawable.thumbup);
                builder.setTitle("Vote me.");

                builder.setPositiveButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        // Intent i=new Intent(Reservation.this,DetailReservation.class);
                        //i.putExtra("id",);
                    }
                });
                builder.setNegativeButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        // Intent i=new Intent(Reservation.this,DetailReservation.class);
                        //i.putExtra("id",);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                Button neg = alert.getButton(AlertDialog.BUTTON_NEGATIVE);
                neg.setBackgroundResource(R.drawable.thumbdown);
                Button pos = alert.getButton(AlertDialog.BUTTON_POSITIVE);
                pos.setBackgroundResource(R.drawable.thumbup);
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

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_name;
        protected TextView tv_score;
        protected TextView tv_poste;
        protected ImageButton btn_voit;


        public CustomViewHolder(View view) {
            super(view);

            this.tv_name = (TextView) view.findViewById(R.id.tv_name);
            this.tv_score=(TextView)view.findViewById(R.id.tv_score);
            this.tv_poste=(TextView)view.findViewById(R.id.tv_poste);
            this.btn_voit=(ImageButton)view.findViewById(R.id.btn_vote);

        }
    }

}
