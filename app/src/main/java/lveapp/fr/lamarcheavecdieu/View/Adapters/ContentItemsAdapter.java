package lveapp.fr.lamarcheavecdieu.View.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import lveapp.fr.lamarcheavecdieu.Model.Content;
import lveapp.fr.lamarcheavecdieu.R;


/**
 * Created by Maranatha on 28/08/2017.
 */

public class ContentItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private ArrayList<Content> contentData;

    // Constructor
    public ContentItemsAdapter(Context context, ArrayList<Content> contentData) {
        this.context = context;
        this.contentData = contentData;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            // Content Title
            case 0:
                view = mInflater.inflate(R.layout.item_title_content, parent, false);
                return new ContentTitleItemHolder(view);
            // Content Subtitle
            case 1:
                view = mInflater.inflate(R.layout.item_subtitle_content, parent, false);
                return new ContentSubTitleItemHolder(view);
            // Content detail
            case 2:
                view = mInflater.inflate(R.layout.item_detail_content, parent, false);
                return new ContentDetailItemHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        TextView titleItemTextView = null;
        TextView subtitleItemTextView = null;
        TextView detailItemTextView = null;
        TextView numberItemTextView = null;

        Typeface font = Typeface.createFromAsset(context.getAssets(),"fonts/Garamond_Premier_Pro.ttf");

        Content content = contentData.get(position);

        int itemViewType = getItemViewType(position);

        // Content Title
        if(itemViewType == 0){
            ContentTitleItemHolder titleItemHolder = (ContentTitleItemHolder)holder;
            numberItemTextView = titleItemHolder.titleNumber;
            titleItemTextView = titleItemHolder.titleItem;
            numberItemTextView.setTypeface(font);
            titleItemTextView.setTypeface(font);
            if(content != null){
                if(content.getTitleNumber().isEmpty() || content.getTitleNumber() == null || content.getTitleNumber().length() == 0){
                    numberItemTextView.setVisibility(View.GONE);
                }
                else{
                    numberItemTextView.setText(content.getTitleNumber());
                }
                titleItemTextView.setText(content.getTitleValue());
            }
            titleItemHolder.positionItem = position;
        }
        // Content Subtitle
        else if(itemViewType == 1){
            ContentSubTitleItemHolder subtitleItemHolder = (ContentSubTitleItemHolder)holder;
            numberItemTextView = subtitleItemHolder.subtitleNumber;
            subtitleItemTextView = subtitleItemHolder.subtitleItem;
            numberItemTextView.setTypeface(font);
            subtitleItemTextView.setTypeface(font);
            if(content != null) {
                numberItemTextView.setText(content.getSubTitleNumber());
                subtitleItemTextView.setText(content.getSubTitleValue());
            }
            subtitleItemHolder.positionItem = position;
        }
        // Content detail
        else if(itemViewType == 2){
            ContentDetailItemHolder detailItemHolder = (ContentDetailItemHolder)holder;
            detailItemTextView = detailItemHolder.detailItem;
            detailItemTextView.setTypeface(font);
            if(content != null) {
                if(content.getTypeContent().equalsIgnoreCase("BOOK_CONTENT_SUBTITLE"))
                    detailItemTextView.setText(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ? Html.fromHtml(content.getSubTitleDetail(), Html.FROM_HTML_MODE_LEGACY) : Html.fromHtml(content.getSubTitleDetail()));
                else if(content.getTypeContent().equalsIgnoreCase("BOOK_CONTENT_TITLE"))
                    detailItemTextView.setText(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ? Html.fromHtml(content.getTitleDetail(), Html.FROM_HTML_MODE_LEGACY) : Html.fromHtml(content.getTitleDetail()));
                else{}
            }
            detailItemHolder.positionItem = position;
        }
        else{}
    }


    @Override
    public int getItemViewType(int position) {
        Content content = contentData.get(position);
        // Content Title
        if(content.getTypeContent() != null && content.getTypeContent().equalsIgnoreCase("SUMMARY_TITLE"))
            return 0;
            // Content Subtitle
        else if(content.getTypeContent() != null && content.getTypeContent().equalsIgnoreCase("SUMMARY_SUBTITLE"))
            return 1;
            // Content detail
        else if((content.getTypeContent() != null && content.getTypeContent().equalsIgnoreCase("BOOK_CONTENT_TITLE")) ||
                content.getTypeContent() != null && content.getTypeContent().equalsIgnoreCase("BOOK_CONTENT_SUBTITLE"))
            return 2;
        else
            return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return contentData.size();
    }

    /**
     * Content title : title value
     */
    public class ContentTitleItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout titleLayout;
        TextView titleNumber;
        TextView titleItem;
        int positionItem;

        public ContentTitleItemHolder(View itemView) {
            super(itemView);
            titleNumber = itemView.findViewById(R.id.title_number);
            titleItem = itemView.findViewById(R.id.title_content);
            titleLayout = itemView.findViewById(R.id.title_layout);
            titleLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.id.subtitle_layout:
                    Log.i("TAG_CONTENT_SUBTITLE", "ContentSubTitleItemHolder");
                    break;
            }
        }
    }


    /**
     * Content subtitle : subtitle value
     */
    public class ContentSubTitleItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout subtitleLayout;
        TextView subtitleNumber;
        TextView subtitleItem;
        int positionItem;

        public ContentSubTitleItemHolder(View itemView) {
            super(itemView);
            subtitleNumber = itemView.findViewById(R.id.subtitle_number);
            subtitleItem = itemView.findViewById(R.id.subtitle_content);
            subtitleLayout = itemView.findViewById(R.id.subtitle_layout);
            subtitleLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.id.subtitle_layout:
                    Log.i("TAG_CONTENT_SUBTITLE", "ContentSubTitleItemHolder");
                    break;
            }
        }
    }

    /**
     * Content detail
     */
    public class ContentDetailItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout detailLayout;
        TextView detailItem;
        int positionItem;

        public ContentDetailItemHolder(View itemView) {
            super(itemView);
            detailItem = itemView.findViewById(R.id.detail_content);
            detailLayout = itemView.findViewById(R.id.detail_layout);
            detailLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.id.detail_layout:
                    Log.i("TAG_DETAIL_CONTENT", "ContentDetailItemHolder");
                    break;
            }
        }
    }
}
