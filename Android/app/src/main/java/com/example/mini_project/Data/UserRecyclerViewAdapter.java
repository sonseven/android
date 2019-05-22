package com.example.mini_project.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mini_project.Model.User;
import com.example.mini_project.R;

import org.w3c.dom.Text;

import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<User> userList;

    public UserRecyclerViewAdapter(Context context, List<User> users) {
        this.context = context;
        userList = users;
    }

    @Override
    public UserRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        User user = userList.get(position);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView username;
        TextView password;
        TextView fullname;
        TextView birth;

        public ViewHolder(View itemView) {

            super(itemView);
        }
    }
}
