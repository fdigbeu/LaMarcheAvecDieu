package lveapp.fr.lamarcheavecdieu.View.Interfaces;

import android.view.View;

import java.util.ArrayList;

import lveapp.fr.lamarcheavecdieu.Model.Content;
import lveapp.fr.lamarcheavecdieu.Model.Summary;

/**
 * Created by Maranatha on 26/08/2017.
 */

public class ReadingInterface {
    public interface IReadingPresenter{

    }

    public interface IReadingActivity{

        /**
         * Identify all widgets
         */
        public void findWidgetsAndSetEvents();

        /**
         * Display details of summary
         * @param summaryItems
         */
        public void displaySummaryContent(ArrayList<Summary> summaryItems);

        /**
         * Display detail of the book
         * @param contentItems
         */
        public void displayBookContent(ArrayList<Content> contentItems);
    }
}
