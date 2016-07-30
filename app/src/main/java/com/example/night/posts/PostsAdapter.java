package com.example.night.posts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by night on 12/7/16.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context mContext;
    private List<Post> mPosts;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView bodyTextView;
        public TextView numberView;

        public ViewHolder(View itemView) {
            super(itemView);

            numberView = (TextView) itemView.findViewById(R.id.postNumber);
            titleTextView = (TextView) itemView.findViewById(R.id.postTitle);
            bodyTextView = (TextView) itemView.findViewById(R.id.postBody);
        }
    }

    //Constructor
    public PostsAdapter(Context context, List<Post> posts) {
        mContext = context;
        mPosts = posts;
    }

    //access to the context from the recycler view
    private Context getContext() {
        return mContext;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = mPosts.get(position);

        TextView postNumber = holder.numberView;
        postNumber.setText(Integer.toString(position + 1));

        TextView postTitle = holder.titleTextView;
        postTitle.setText(post.getTitle());

        TextView postBody = holder.bodyTextView;
        postBody.setText(post.getBody());

    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.post_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;
    }
}
