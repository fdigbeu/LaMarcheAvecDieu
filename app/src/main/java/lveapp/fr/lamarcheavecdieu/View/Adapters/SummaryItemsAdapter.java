package lveapp.fr.lamarcheavecdieu.View.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import lveapp.fr.lamarcheavecdieu.Model.Summary;
import lveapp.fr.lamarcheavecdieu.R;

/**
 * Created by Maranatha on 27/08/2017.
 */

public class SummaryItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater mInflater;
    private Context context;
    private DrawerLayout drawer;
    private ArrayList<Summary> summaryData;

    // Constructor
    public SummaryItemsAdapter(Context context, ArrayList<Summary> summaryData, DrawerLayout drawer) {
        this.context = context;
        this.summaryData = summaryData;
        this.drawer = drawer;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            // Summary header
            case 0:
                view = mInflater.inflate(R.layout.item_header_summary, parent, false);
                return  new SummaryHeaderItemHolder(view);
            // Summury title
            case 1:
                view = mInflater.inflate(R.layout.item_title_summary, parent, false);
                return  new SummaryTitleItemHolder(view);
            // Summary subtitle
            case 2:
                view = mInflater.inflate(R.layout.item_subtitle_summary, parent, false);
                return  new SummarySubTitleItemHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        TextView titleItemTextView, subtitleItemTextView = null;
        LinearLayout headerItemLayout = null;

        Typeface font = Typeface.createFromAsset(context.getAssets(),"fonts/Garamond_Premier_Pro.ttf");

        Summary summary = summaryData.get(position);

        int itemViewType = getItemViewType(position);

        // Header
        if(itemViewType == 0){
            SummaryHeaderItemHolder headerItemHolder = (SummaryHeaderItemHolder)holder;
            headerItemLayout = headerItemHolder.headerSummary;
        }
        // Summary title
        else if(itemViewType == 1){
            SummaryTitleItemHolder titleItemHolder = (SummaryTitleItemHolder)holder;
            titleItemTextView = titleItemHolder.titleItem;
            titleItemTextView.setTypeface(font);
            if(summary != null){
                titleItemTextView.setText(summary.getTitleNumber()+" "+summary.getTitle());
            }
            titleItemHolder.positionItem = position;
        }
        // Summary subtitle
        else if(itemViewType == 2){
            SummarySubTitleItemHolder subtitleItemHolder = (SummarySubTitleItemHolder)holder;
            subtitleItemTextView = subtitleItemHolder.subtitleItem;
            subtitleItemTextView.setTypeface(font);
            if(summary != null) {
                subtitleItemTextView.setText(summary.getTitleNumber() + " " + summary.getTitle());
            }
            subtitleItemHolder.positionItem = position;
        }
        else{}
    }


    @Override
    public int getItemViewType(int position) {
        Summary summary = summaryData.get(position);
        // Header
        if(summary.getTitleKeyCode().equalsIgnoreCase("_header_"))
            return 0;
         // Summary title
        else if(summary.getTitleKeyCode().split("_").length == 1)
            return 1;
        // Summary subtitle
        else if(summary.getTitleKeyCode().split("_").length == 2)
            return 2;
        else
            return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return summaryData.size();
    }

    /**
     * Summary header : Image of the book
     */
    public class SummaryHeaderItemHolder extends RecyclerView.ViewHolder {
        LinearLayout headerSummary;

        public SummaryHeaderItemHolder(View itemView) {
            super(itemView);
            headerSummary = itemView.findViewById(R.id.header_summary);
        }
    }

    /**
     * Summary title : title value
     */
    public class SummaryTitleItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleItem;
        int positionItem;

        public SummaryTitleItemHolder(View itemView) {
            super(itemView);
            titleItem = itemView.findViewById(R.id.title_summary);
            titleItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.id.title_summary:
                    drawer.closeDrawer(GravityCompat.START);
                    Log.i("TAG_SUMMARY_ITEM", "SummaryTitleItemHolder");
                    break;
            }
        }
    }

    /**
     * Summary Subtitle : subtitle value
     */
    public class SummarySubTitleItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView subtitleItem;
        int positionItem;

        public SummarySubTitleItemHolder(View itemView) {
            super(itemView);
            subtitleItem = itemView.findViewById(R.id.subtitle_summary);
            subtitleItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.id.subtitle_summary:
                    drawer.closeDrawer(GravityCompat.START);
                    Log.i("TAG_SUMMARY_ITEM", "SummarySubTitleItemHolder");
                    break;
            }
        }
    }
}
