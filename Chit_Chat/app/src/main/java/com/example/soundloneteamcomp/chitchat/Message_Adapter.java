package com.example.soundloneteamcomp.chitchat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class Message_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_ME = 1;
    private static final int VIEW_TYPE_OTHER = 2;

    private List<Messages> userMessageList;

    public Message_Adapter(List<Messages> userMessageList) {
        this.userMessageList = userMessageList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 1:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_message, parent, false);
                viewHolder = new MyChatViewHolder(v);
                break;
            case 2:
                View v2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_message2, parent, false);
                viewHolder = new OtherChatViewHolder(v2);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (userMessageList.get(position).getMessage().length() > 5) {
            configureMyChatViewHolder((MyChatViewHolder) holder, position);
        } else {
            configureOtherChatViewHolder((OtherChatViewHolder) holder, position);
        }
    }

    private void configureMyChatViewHolder(MyChatViewHolder myChatViewHolder, int position) {
        Messages messages = userMessageList.get(position);
        myChatViewHolder.txtChatMessage.setText(messages.getMessage());
    }

    private void configureOtherChatViewHolder(OtherChatViewHolder otherChatViewHolder, int position) {
        Messages messages = userMessageList.get(position);
        otherChatViewHolder.txtChatMessage.setText(messages.getMessage());
    }

    @Override
    public int getItemCount() {
        if (userMessageList != null) {
            return userMessageList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (userMessageList.get(position).getMessage().length() > 5) {
            return VIEW_TYPE_ME;
        } else {
            return VIEW_TYPE_OTHER;
        }
    }

    private static class MyChatViewHolder extends RecyclerView.ViewHolder {
        private TextView txtChatMessage;
        private CircleImageView userProfile;

        public MyChatViewHolder(View itemView) {
            super(itemView);
            txtChatMessage = (TextView) itemView.findViewById(R.id.message_txt);
            userProfile = (CircleImageView) itemView.findViewById(R.id.message_profile);
        }
    }

    private static class OtherChatViewHolder extends RecyclerView.ViewHolder {
        private TextView txtChatMessage;
        private CircleImageView userProfile;

        public OtherChatViewHolder(View itemView) {
            super(itemView);
            txtChatMessage = (TextView) itemView.findViewById(R.id.message_txt);
            userProfile = (CircleImageView) itemView.findViewById(R.id.message_profile);
        }
    }
}