package com.example.laboratory.services.impl;

import com.example.laboratory.models.Elements;
import com.example.laboratory.services.ElementsService;
import com.example.laboratory.utils.Care;
import com.example.laboratory.utils.Material;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ElementsServiceImpl implements ElementsService {

    private ArrayList<Elements> listElemets = new ArrayList<>();

    public void addElement(String name, String care, String material, String stock, String code){
        try {
            Care care1 = returnCare(care);
            Material material1 = returnMaterial(material);
            Elements e = null;
                if (care1 != null && material1 != null){
                    e = new Elements(name.toLowerCase(),material1,care1,Integer.parseInt(stock),code,true);
                }
                if (listElemets.size() == 0){
                    listElemets.add(e);
                }else if (listElemets.size() > 0 && !searchAnyArrayList(listElemets,name,code)){
                    listElemets.add(e);
                }
            }catch (NumberFormatException event){
                System.out.println("Please select Correct value possible in choice values");
            }
    }


    public  void searchCodeElement(TextField tfSearchElement, TextArea textArea){
        String code = tfSearchElement.getText().toLowerCase();
        boolean a = listElemets.stream().anyMatch(x -> x.getStatus() != false && x.getName().equalsIgnoreCase(code));
        if (a){
            textArea.clear();
            textArea.setText("There is a element");
        }else{
            textArea.clear();
            textArea.setText("item not found possibly discontinued");
        }

    }




   public void  downElement(TextField tfDownElement,TextArea textArea,Elements e){
        listElemets.stream().filter(x -> x.getName().toLowerCase().equalsIgnoreCase(e.getName().toLowerCase()) && x.getCode().toLowerCase().equalsIgnoreCase(e.getCode().toLowerCase()))
                .forEach(w ->{
                    w.setStatus(false);
                });

   }




    public Care returnCare(String care){
        switch (care){
            case "Dont wet":
                return Care.DONTWENT;
            case "Handle with care":
                return Care.HANDLEWITHCARE;
            case "Without care":
                return Care.WITHOUTCARE;
        }
        return null;
    }


    public Material returnMaterial(String material){
        switch (material){
            case "Aluminium":
                return Material.ALUMINIUM;
            case "Iron":
                return Material.IRON;
            case "Plastic":
                return Material.PLASTIC;
       }
        return null;
    }

    public boolean searchAnyArrayList(ArrayList<Elements>elements,String name, String code){
        return elements.stream().anyMatch(x -> x.getName().equalsIgnoreCase(name.toLowerCase()) || x.getCode().equalsIgnoreCase(code));
    }

    public boolean searchAnyObservableList(ObservableList<Elements> elementsObservableList,String name, String code ){
        return elementsObservableList.stream().anyMatch(x -> x.getName().equalsIgnoreCase(name.toLowerCase()) || x.getCode().equalsIgnoreCase(code));
    }


    public ArrayList<Elements> getListElemets() {
        return listElemets;
    }
}


