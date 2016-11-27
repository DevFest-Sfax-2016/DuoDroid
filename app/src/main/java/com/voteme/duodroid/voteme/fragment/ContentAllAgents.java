package com.voteme.duodroid.voteme.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voteme.duodroid.voteme.Adapters.AgentAdapter;
import com.voteme.duodroid.voteme.R;
import com.voteme.duodroid.voteme.model.Agent;

import java.util.List;

import yalantis.com.sidemenu.interfaces.ScreenShotable;

public class ContentAllAgents extends Fragment implements ScreenShotable {
    // TODO: Rename parameter arguments, choose names that match

    private View containerView;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AgentAdapter adapter;
    protected int res;
    private Bitmap bitmap;
    private List<Agent> data;
    private SwipeRefreshLayout swipeRefreshLayout;
    public ContentAllAgents() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.containerView = view.findViewById(R.id.container);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public static ContentAllAgents newInstance(int resId) {
        ContentAllAgents contentFragment = new ContentAllAgents();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_content_all_agents, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.freshSwipeView);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.list_agents);
        // int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        // mRecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        // mRecyclerView.setLayoutManager(mLayoutManager);

        // mLayoutManager.canScrollVertically();
        mRecyclerView.setLayoutManager(mLayoutManager);
        recuperer();
        adapter=new AgentAdapter(getContext(),data);
        mRecyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recuperer();
            }
        });

        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);

                                        //recuperer();
                                    }
                                }
        );
      return v;
    }

private  void recuperer(){}

    @Override
    public void takeScreenShot() {
        Thread thread = new Thread() {
            @Override
            public void run() {
               /* Bitmap bitmap = Bitmap.createBitmap(containerView.getWidth(),
                        containerView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                containerView.draw(canvas);
                ContentAllAgents.this.bitmap = bitmap;*/
            }
        };

        thread.start();

    }


    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }
}
