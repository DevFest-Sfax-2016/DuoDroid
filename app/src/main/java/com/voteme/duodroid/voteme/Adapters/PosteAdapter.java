package com.voteme.duodroid.voteme.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.voteme.duodroid.voteme.R;
import com.voteme.duodroid.voteme.model.Agent;
import com.voteme.duodroid.voteme.model.Poste;

import java.util.List;

/**
 * Created by Mohamed chiheb on 27/11/2016.
 */

public class PosteAdapter extends RecyclerView.Adapter<PosteAdapter.CustomViewHolder> implements View.OnClickListener {

    private List<Poste> data;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    public PosteAdapter(Context context, List<Poste> data) {
        this.mContext=context;
        this.data=data;

    }

    @Override
    public PosteAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.poste_row, null);

        PosteAdapter.CustomViewHolder viewHolder = new PosteAdapter.CustomViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(PosteAdapter.CustomViewHolder customViewHolder, int i) {
        final Poste voit = data.get(i);



        //Setting text view title
        customViewHolder.tv_name.setText(voit.getName());

        customViewHolder.tv_adresse.setText(" "+voit.getAdresse());
        customViewHolder.btn_voit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent i=new Intent(mContext, DetailVoiture.class);
                i.putExtra("id",voit.getId());
                mContext.startActivity(i);*/
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
        protected TextView tv_adresse;

        protected ImageButton btn_voit;


        public CustomViewHolder(View view) {
            super(view);

            this.tv_name = (TextView) view.findViewById(R.id.tv_name_p);
            this.tv_adresse=(TextView)view.findViewById(R.id.tv_adresse);

            this.btn_voit=(ImageButton)view.findViewById(R.id.btn_marker);

        }
    }

}
