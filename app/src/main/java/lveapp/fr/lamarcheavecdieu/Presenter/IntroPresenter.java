package lveapp.fr.lamarcheavecdieu.Presenter;

import android.content.Context;
import android.os.CountDownTimer;

import lveapp.fr.lamarcheavecdieu.View.Interfaces.IntroInterface.IIntroPresenter;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.IntroInterface.IIntroActivity;

/**
 * Created by Maranatha on 24/08/2017.
 */

public class IntroPresenter implements IIntroPresenter {
    // Attributs
    private IIntroActivity iIntroActivity;
    private Context context;

    // Constructor
    public IntroPresenter(IIntroActivity iIntroActivity){
        this.iIntroActivity = iIntroActivity;
    }

    // Load intro data
    public void loadIntroData(Context context){
        this.context = context;
        iIntroActivity.findWidgetsAndSetEvents();
        iIntroActivity.displayImageToWebView();
        iIntroActivity.showHomeActivity();
    }

    // Cancel count down timer
    public void cancelDownTimer(CountDownTimer downTimer){
        if (downTimer != null){
            downTimer.cancel();
        }
    }
}
