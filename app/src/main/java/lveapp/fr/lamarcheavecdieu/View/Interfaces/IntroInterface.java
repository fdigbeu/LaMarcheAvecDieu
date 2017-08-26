package lveapp.fr.lamarcheavecdieu.View.Interfaces;

/**
 * Created by Maranatha on 24/08/2017.
 */

public class IntroInterface {
    public interface IIntroPresenter{
    }

    public interface IIntroActivity{

        /**
         * Identify all widgets
         */
        public void findWidgetsAndSetEvents();

        /**
         * Display image into the webview
         */
        public void displayImageToWebView();

        /**
         * show the Home Activity
         */
        public void showHomeActivity();
    }
}
