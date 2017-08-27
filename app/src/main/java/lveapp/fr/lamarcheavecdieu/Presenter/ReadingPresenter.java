package lveapp.fr.lamarcheavecdieu.Presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.ReadingInterface.IReadingActivity;

/**
 * Created by Maranatha on 26/08/2017.
 */

public class ReadingPresenter {
    private Context context;
    private IReadingActivity iReadingActivity;

    public ReadingPresenter(IReadingActivity iReadingActivity) {
        this.iReadingActivity = iReadingActivity;
    }

    public void loadReadingData(Context context){
        this.context = context;
        iReadingActivity.findWidgetsAndSetEvents();
    }


    /**
     * Retrieve event of user action
     * @param view
     */
    public void retrieveUserAction(ArrayList<View> listOfView, View view){
        switch (view.getId()){
            // If summary item is selected
            default:
                String titleKeyCode = CommonPresenter.getKeyCodeByViewId(view.getId());
                Log.i("TAG_TITLE_KEY_CODE", titleKeyCode);
                if(listOfView != null){
                    CommonPresenter.selectThisSummaryItem(listOfView, view);
                }
                /*Summary summary = CommonPresenter.getSummaryTitleInfos(context, titleKeyCode);
                if(summary != null){
                    Log.i("TAG_TITLE_KEY_CODE", "summary_title_key_code = "+summary.getTitleKeyCode());
                    Log.i("TAG_TITLE_KEY_CODE", "summary_title = "+summary.getTitle());
                    Log.i("TAG_TITLE_KEY_CODE", "summary_title_number = "+summary.getTitleNumber());
                }*/
                break;
        }
    }
}
