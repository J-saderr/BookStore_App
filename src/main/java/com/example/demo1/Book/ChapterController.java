package com.example.demo1.Book;

import com.example.demo1.Controller.MainController;
import com.example.demo1.getData;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ChapterController extends MainController implements Initializable {
    @FXML
    private Label chapter;
    @FXML
    private Label nameOfBook;

    @FXML
    private TextArea chapterDetail;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayName();
        displayChapterName();
        displayChapterDetail();
    }
    public void displayName(){
        String name = getData.Bookname;
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        nameOfBook.setText(name);
    }
    public void displayChapterName() {

        if (getData.chapter0 != null ||
                getData.chapter1 != null ||
                getData.chapter2 != null ||
                getData.chapter3 != null ||
                getData.chapter4 != null ||
                getData.chapter5 != null) {

            String chapter_ = getData.chapter0 != null ? getData.chapter0 :
                    getData.chapter1 != null ? getData.chapter1 :
                            getData.chapter2 != null ? getData.chapter2 :
                                    getData.chapter3 != null ? getData.chapter3 :
                                            getData.chapter4 != null ? getData.chapter4 :
                                                    getData.chapter5;
            chapter_ = chapter_.substring(0, 1).toUpperCase() + chapter_.substring(1);
            chapter.setText(chapter_);
        }
    }
    public void displayChapterDetail() {

        if (getData.detailChapter0 != null ||
                getData.detailChapter1 != null ||
                getData.detailChapter2 != null ||
                getData.detailChapter3 != null ||
                getData.detailChapter4 != null ||
                getData.detailChapter5 != null) {

            String chapterdetail_ = "";
            if (getData.detailChapter0 != null) {
                chapterdetail_ = getData.detailChapter0;
            } else if (getData.detailChapter1 != null) {
                chapterdetail_ = getData.detailChapter1;
            } else if (getData.detailChapter2 != null) {
                chapterdetail_ = getData.detailChapter2;
            } else if (getData.detailChapter3 != null) {
                chapterdetail_ = getData.detailChapter3;
            } else if (getData.detailChapter4 != null) {
                chapterdetail_ = getData.detailChapter4;
            } else if (getData.detailChapter5 != null) {
                chapterdetail_ = getData.detailChapter5;
            }

            chapterdetail_ = chapterdetail_.substring(0, 1).toUpperCase() + chapterdetail_.substring(1);
            chapterDetail.setText(chapterdetail_);
        }
    }
}