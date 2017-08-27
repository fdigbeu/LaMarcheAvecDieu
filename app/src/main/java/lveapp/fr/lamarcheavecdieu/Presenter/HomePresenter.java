package lveapp.fr.lamarcheavecdieu.Presenter;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import lveapp.fr.lamarcheavecdieu.Model.Summary;
import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.HomeInterface.IHomePresenter;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.HomeInterface.IHomeActivity;

/**
 * Created by Maranatha on 24/08/2017.
 */

public class HomePresenter implements IHomePresenter {
    private Context context;
    private IHomeActivity iHomeActivity;

    public HomePresenter(IHomeActivity iHomeActivity) {
        this.iHomeActivity = iHomeActivity;
    }

    public void loadHomeData(Context context){
        this.context = context;
        iHomeActivity.findWidgetsAndSetEvents();
    }

    /**
     * Retrieve event of user action
     * @param view
     */
    public void retrieveUserAction(ArrayList<View> listOfView, View view){
        switch (view.getId()){
            // If menu more is selected
            case R.id.fab_menu_more:
                iHomeActivity.displayMenuMoreItem(view);
                break;
            // If summary item is selected
            default:
                String titleKeyCode = CommonPresenter.getKeyCodeByViewId(view.getId());
                Log.i("TAG_TITLE_KEY_CODE", titleKeyCode);
                iHomeActivity.displayReadingActivity(titleKeyCode);
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

    /**
     * Retrieve event of user action
     * @param item
     */
    public void retrieveUserAction(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_continuer_lecture:
                Log.i("TAG_MENU_MORE", "action_continuer_lecture");
                break;

            case R.id.action_partager_appli:
                Log.i("TAG_MENU_MORE", "action_partager_appli");
                break;

            case R.id.action_verifier_update:
                Log.i("TAG_MENU_MORE", "action_verifier_update");
                break;

            case R.id.action_modifier_parametre:
                Log.i("TAG_MENU_MORE", "action_modifier_parametre");
                break;
        }
    }
}
