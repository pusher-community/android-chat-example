package com.example.jamiepatel.pusherchat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by jamiepatel on 22/09/2015.
 */
public class MessageAdapter extends BaseAdapter {

    Context messageContext;
    List<Message> messageList;

    public MessageAdapter(Context context, List<Message> messages){
        messageList = messages;
        messageContext = context;
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageViewHolder holder;
        if (convertView == null){
            LayoutInflater messageInflater = (LayoutInflater) messageContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = messageInflater.inflate(R.layout.message, null);
            holder = new MessageViewHolder();
            holder.thumbnailImageView = (ImageView) convertView.findViewById(R.id.img_thumbnail);
            holder.senderView = (TextView) convertView.findViewById(R.id.message_sender);
            holder.bodyView = (TextView) convertView.findViewById(R.id.message_body);

            convertView.setTag(holder);
        } else {
            holder = (MessageViewHolder) convertView.getTag();
        }

        Message message = (Message) getItem(position);

        holder.bodyView.setText(message.body);
        holder.senderView.setText(message.sender);
        holder.thumbnailImageView.setImageResource(R.mipmap.ic_launcher);

        return convertView;
    }

    public void add(Message message){
        messageList.add(message);
        notifyDataSetChanged();
        System.out.println(getCount());
    }

    private static class MessageViewHolder {
        public ImageView thumbnailImageView;
        public TextView senderView;
        public TextView bodyView;

    }
}
