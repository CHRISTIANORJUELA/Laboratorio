package com.example.laboratory.services.impl;

import com.example.laboratory.models.Monitor;
import com.example.laboratory.services.MonitorService;
import com.example.laboratory.utils.UtilisMethods;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import java.util.ArrayList;

public class MonitorServiceImpl implements MonitorService {

    private ArrayList<Monitor> listMonitors = new ArrayList<>();
    private ArrayList<Monitor> listMonitorsFilter = new ArrayList<>();
    public void addMonitor(String name, String document, String age, String antiquity, String codeRoom){
        try {
            if (listMonitors.size() == 0){
                listMonitors.add(new Monitor(name,document,age,Integer.parseInt(antiquity),codeRoom));
            } else {
                if (filter1(listMonitors,document)){
                    System.out.println("Value already exists");
                }else{
                    listMonitors.add(new Monitor(name, document, age, Integer.parseInt(antiquity), codeRoom));
                }
            }
        }catch (NumberFormatException e) {
            System.out.println("Please enter correct value posibble in antiquity");
        }
    }

    public boolean filter1(ArrayList<Monitor> listMonitors, String tfDocument){
        boolean a = listMonitors.stream().anyMatch(x -> x.getDocument().equalsIgnoreCase(tfDocument));
        return a;
    }



    public void  upDateMonitor(ObservableList<Monitor>observableListFalse,ObservableList<Monitor>observableListFilterFalse,Monitor p,String Name,String document,String age,String antiquity,String coderoom){
        try {
            if( observableListFalse.size() <= listMonitors.size() || !filter1(listMonitors,document)){
                listMonitors.stream().filter(x -> x.getName().equalsIgnoreCase(p.getName().toLowerCase()) && x.getDocument().equalsIgnoreCase(p.getDocument())).forEach(w ->{
                    w.setName(Name);
                    if (!filter1(listMonitors,document)){
                        w.setDocument(document);
                    }
                    w.setAge(age);
                    w.setAntiquity(Integer.parseInt(antiquity));
                    w.setCodeRoom(coderoom);
                });
            }
        }catch (NumberFormatException e){
            System.out.println("Please enter correct value possible in Antiquity");
        }

    }

    public void filterProcessMonitor(ChoiceBox<String> boxChoiceValues, String valueFilter){
        try {
            switch (UtilisMethods.getValueBox(boxChoiceValues)){
                case "Name":
                    listMonitorsFilter.clear();
                    listMonitors.stream().filter(a -> a.getName().toLowerCase().contains(valueFilter.toLowerCase())).forEach( w ->{
                        listMonitorsFilter.add(w);
                    });
                    break;
                case "Document":
                    listMonitorsFilter.clear();
                    listMonitors.stream().filter(a -> a.getDocument().toLowerCase().contains(valueFilter.toLowerCase())).forEach( w ->{
                        listMonitorsFilter.add(w);
                    });
                    break;
                case "Antiquity":
                    listMonitorsFilter.clear();
                    listMonitors.stream().filter(a -> a.getAntiquity() == Integer.parseInt(valueFilter)).forEach( w ->{
                        listMonitorsFilter.add(w);
                    });
                    break;
            }
        }catch (NullPointerException e){
            System.out.println("Please select a value in campus");
        }
    }

    public void deleteMonitor(Monitor m){
        for (int i =0;i<listMonitors.size();i++){
            if (listMonitors.get(i).getName().equalsIgnoreCase(m.getName().toLowerCase()) && listMonitors.get(i).getDocument().equalsIgnoreCase(m.getDocument().toLowerCase())){
                delete(listMonitors,i);
            }
        }
    }

    public void  delete(ArrayList<Monitor>listMonitors,int i){
        listMonitors.remove(i);
    }


    public ArrayList<Monitor> getListMonitors() {
        return listMonitors;
    }

    public ArrayList<Monitor> getListMonitorsFilter() {
        return listMonitorsFilter;
    }
}
