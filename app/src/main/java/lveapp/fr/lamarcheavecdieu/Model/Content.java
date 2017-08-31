package lveapp.fr.lamarcheavecdieu.Model;

/**
 * Created by Maranatha on 25/08/2017.
 */

public class Content {
    private String titleNumber;
    private String titleValue;
    private String titleKeyCode;
    private String titleDetail;
    private String subTitleNumber;
    private String subTitleValue;
    private String subTitleKeyCode;
    private String subTitleDetail;
    private String typeContent;

    public Content(String titleNumber, String titleValue, String titleKeyCode, String titleDetail, String subTitleNumber, String subTitleValue, String subTitleKeyCode, String subTitleDetail, String typeContent) {
        this.titleNumber = titleNumber;
        this.titleValue = titleValue;
        this.titleKeyCode = titleKeyCode;
        this.titleDetail = titleDetail;
        this.subTitleNumber = subTitleNumber;
        this.subTitleValue = subTitleValue;
        this.subTitleKeyCode = subTitleKeyCode;
        this.subTitleDetail = subTitleDetail;
        this.typeContent = typeContent;
    }

    public String getTitleNumber() {
        return titleNumber;
    }

    public void setTitleNumber(String titleNumber) {
        this.titleNumber = titleNumber;
    }

    public String getTitleValue() {
        return titleValue;
    }

    public void setTitleValue(String titleValue) {
        this.titleValue = titleValue;
    }

    public String getTitleKeyCode() {
        return titleKeyCode;
    }

    public void setTitleKeyCode(String titleKeyCode) {
        this.titleKeyCode = titleKeyCode;
    }

    public String getTitleDetail() {
        return titleDetail;
    }

    public void setTitleDetail(String titleDetail) {
        this.titleDetail = titleDetail;
    }

    public String getSubTitleNumber() {
        return subTitleNumber;
    }

    public void setSubTitleNumber(String subTitleNumber) {
        this.subTitleNumber = subTitleNumber;
    }

    public String getSubTitleValue() {
        return subTitleValue;
    }

    public void setSubTitleValue(String subTitleValue) {
        this.subTitleValue = subTitleValue;
    }

    public String getSubTitleKeyCode() {
        return subTitleKeyCode;
    }

    public void setSubTitleKeyCode(String subTitleKeyCode) {
        this.subTitleKeyCode = subTitleKeyCode;
    }

    public String getSubTitleDetail() {
        return subTitleDetail;
    }

    public void setSubTitleDetail(String subTitleDetail) {
        this.subTitleDetail = subTitleDetail;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }
}
