package com.example.laboratory.services;

import com.example.laboratory.models.FinishLoan;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public interface InformationService {
    void countNumberElementsLoans(String nameElement, ArrayList<FinishLoan> listFinishLoanController, TextArea textTarea);

    void searchInformation(String nameElement,ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea);

    void countNumberLoansMonitor(ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea);

    void findStudentMoreLoan(ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea);

    void getTotalAmount (double amount, TextArea textArea);
}
