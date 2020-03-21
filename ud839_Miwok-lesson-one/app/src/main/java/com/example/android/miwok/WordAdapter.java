package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PC on 27-09-2017.
 */

public class WordAdapter extends ArrayAdapter<word> {
    private int colorResourceId;
    public WordAdapter(Activity context, ArrayList<word> words,int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.colorResourceId=colorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        word currentword = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentword.getMiwokvalue());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentword.getDefaultvalue());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentword.hasImage())
        {
            // Find the ImageView in the list_item.xml layout with the ID list_item_icon
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentword.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
            //has to make it visible explicitely for scrap views which was not there (maybe) previously
        }
        else
        {
            //set to gone as we don't need to waste space by hiding the imageviews
            iconView.setVisibility(View.GONE);
        }
        //Set the theme color for the list item
        View textContainer=listItemView.findViewById(R.id.text_container);
        //Find the color that resource id maps to
        int color= ContextCompat.getColor(getContext(),colorResourceId);
        //Set the backgroundColor of the text container view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
