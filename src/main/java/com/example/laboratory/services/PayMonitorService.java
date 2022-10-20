package com.example.laboratory.services;

import com.example.laboratory.models.FinishLoan;
import com.example.laboratory.models.Monitor;
import com.example.laboratory.models.PayMonitors;

import java.util.ArrayList;

public interface PayMonitorService {

    void putTable(ArrayList<FinishLoan>finishLoanController,ArrayList<Monitor> monitorController);
    ArrayList<PayMonitors> getListPayMonitor();
}
