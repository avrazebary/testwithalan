package com.example.avraz.networkingarraylist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avraz.networkingarraylist.JSONParsing.Article;
import com.example.avraz.networkingarraylist.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<Article> {


    public NewsAdapter(@NonNull Context context,  ArrayList<Article> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }
        Article currentItem = getItem(position);
        TextView title = convertView.findViewById(R.id.title_view);
        TextView description = convertView.findViewById(R.id.description);
        TextView author = convertView.findViewById(R.id.author_view);
        ImageView image = convertView.findViewById(R.id.image_view);

        title.setText(currentItem.getTitle());
        author.setText(currentItem.getAuthor());
        description.setText(currentItem.getDescription());
        Picasso.get().load(currentItem.getUrlToImage()).into(image);
        return convertView;
    }


}
