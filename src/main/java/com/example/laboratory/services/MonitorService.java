package com.example.laboratory.services;

import com.example.laboratory.models.Monitor;
import com.example.laboratory.models.StartLoan;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public interface MonitorService {
    void addMonitor(String name, String document, String age, String antiquity, String codeRoom);
    void upDateMonitor(ObservableList<Monitor>observableListFalse,ObservableList<Monitor>observableListFilterFalse,Monitor p,String Name,String document,String age,String antiquity,String coderoom);
    void filterProcessMonitor(ChoiceBox<String> boxChoiceValues, String valueFilter);

    void deleteMonitor(Monitor m);

    ArrayList<Monitor> getListMonitors();

    ArrayList<Monitor> getListMonitorsFilter();

}
