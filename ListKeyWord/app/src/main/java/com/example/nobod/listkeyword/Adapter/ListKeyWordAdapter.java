package com.example.nobod.listkeyword.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nobod.listkeyword.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class modify Adapter to generate data to layout
 * author CuongNguyen
 * since 05/03/2019
 */
public class ListKeyWordAdapter extends RecyclerView.Adapter<ListKeyWordAdapter.ViewHoder> {

    private static final String TAG = "ListKeyWordAdapter";

    private ArrayList<String> keyWords = new ArrayList<>();

    private Context context;

    public ListKeyWordAdapter(Context context, ArrayList<String> keyWords) {
        this.context = context;
        this.keyWords = keyWords;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder : called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Random random = new Random();
        int currentColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        Drawable drawable = (Drawable) ContextCompat.getDrawable(context, R.drawable.custom_border);
        drawable.setColorFilter(currentColor, PorterDuff.Mode.SRC_ATOP);
        holder.relativeLayout.setBackground(drawable);
        holder.txt_key_word.setText(keyWords.get(position));
    }

    @Override
    public int getItemCount() {
        return keyWords.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView txt_key_word;
        RelativeLayout relativeLayout;

        public ViewHoder(View itemView) {
            super(itemView);
            txt_key_word = itemView.findViewById(R.id.txt_key_word);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}
