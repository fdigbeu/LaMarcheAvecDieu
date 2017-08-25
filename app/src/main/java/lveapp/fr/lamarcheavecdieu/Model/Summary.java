package lveapp.fr.lamarcheavecdieu.Model;

/**
 * Created by Maranatha on 25/08/2017.
 */

public class Summary {
    private String title;
    private String titleKeyCode;
    private String titleNumber;

    public Summary(String title, String titleKeyCode, String titleNumber) {
        this.title = title;
        this.titleKeyCode = titleKeyCode;
        this.titleNumber = titleNumber;
    }

    public Summary(String title, String titleKeyCode, String titleNumber, String subtitleKeyCode) {
        this.title = title;
        this.titleKeyCode = titleKeyCode;
        this.titleNumber = titleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleKeyCode() {
        return titleKeyCode;
    }

    public void setTitleKeyCode(String titleKeyCode) {
        this.titleKeyCode = titleKeyCode;
    }

    public String getTitleNumber() {
        return titleNumber;
    }

    public void setTitleNumber(String titleNumber) {
        this.titleNumber = titleNumber;
    }
}
