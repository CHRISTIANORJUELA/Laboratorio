package com.example.laboratory.services.impl;

import com.example.laboratory.models.FinishLoan;
import com.example.laboratory.services.InformationService;
import javafx.scene.control.TextArea;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class InformationServiceImpl implements InformationService {

    public void searchInformation(String codeloan,ArrayList<FinishLoan>listFinishLoan,TextArea textTarea){
        boolean pass = listFinishLoan.stream().anyMatch(x -> x.getCodeLoad().equalsIgnoreCase(codeloan.toLowerCase()));
        if (pass){
            List<FinishLoan> listFinish = listFinishLoan.stream()
                    .filter(x -> x.getCodeLoad().equalsIgnoreCase(codeloan.toLowerCase())).toList();
            textTarea.setText("");
            textTarea.setText(" Name of Manager : "+listFinish.get(0).getNameManagerString()+
                    " Name Person "+listFinish.get(0).getNamePersonString()+
                    " Price loan "+listFinish.get(0).getPrice());
        }else {
            System.out.println("Code loan not exists");
        }
    }
    public void countNumberElementsLoans(String nameElement, ArrayList<FinishLoan> listFinishLoan, TextArea textTarea){
        boolean pass = listFinishLoan.stream().anyMatch(x -> x.getNameElement().equalsIgnoreCase(nameElement.toLowerCase()));
        if (pass){
            List<FinishLoan> listFinishLoanconvert = listFinishLoan;
            Map<String,Long>  map2 = listFinishLoanconvert.stream()
                    .filter(x -> x.getNameElement().equalsIgnoreCase(nameElement.toLowerCase()))
                    .collect(Collectors.groupingBy(FinishLoan::getNameElement,Collectors.counting()));

            map2.forEach((k,v) -> System.out.println("Element "+k+ "  is in : "+v+" Loan "));
        }else {
            System.out.println("The element dont exists");
        }
    }



    public void countNumberLoansMonitor(ArrayList<FinishLoan>listFinishLoan,TextArea textTarea){
        List<FinishLoan> listFinish = listFinishLoan;
        String search = "Monitor";
        Map<String,Long> map1 = listFinish.stream()
                .filter(x -> x.getNameTypeManager().equalsIgnoreCase(search))
                .collect(Collectors.groupingBy(FinishLoan::getNameManagerString,Collectors.counting()));
        map1.forEach((k,v) -> System.out.println("Monitor "+k+" is "+v+" times"));
    }


    public void  findStudentMoreLoan(ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea){}

    public void  getTotalAmount (double amount, TextArea textArea){
        textArea.setText("");
        textArea.setText("The total amount in laboratory is : "+amount);
    }
}
