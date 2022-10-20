package com.example.laboratory.services;

import com.example.laboratory.models.Elements;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public interface ElementsService {
    void addElement(String name, String care, String material, String stock, String code);
    void searchCodeElement(TextField tfSearchElement, TextArea textArea);

    void  downElement(TextField tfDownElement,TextArea textArea,Elements e);

    ArrayList<Elements> getListElemets();
}
