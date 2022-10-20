package com.example.laboratory.services.impl;

import com.example.laboratory.models.FinishLoan;
import com.example.laboratory.models.Monitor;
import com.example.laboratory.models.PayMonitors;
import com.example.laboratory.services.PayMonitorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PayMonitorServiceImpl implements PayMonitorService {
    private ArrayList<PayMonitors> listPayMonitor = new ArrayList<>();

    public void putTable(ArrayList<FinishLoan>finishLoanController,ArrayList<Monitor> monitorController){
        listPayMonitor.clear();
        List<FinishLoan> list = finishLoanController;
        Map<String,Double> map1 = list.stream()
                .filter(x -> x.getNameTypeManager().equalsIgnoreCase("Monitor"))
                .collect(Collectors.groupingBy(
                        FinishLoan::getNameManagerString,
                        Collectors.summingDouble(FinishLoan::getPrice)
                        ));
        map1.forEach((k,v)->{
            try {
                int antiquity = getAntiquity(k,monitorController);
                if (antiquity == -1){
                    System.out.println("I can not possible find the antiquity");
                }else {
                    if (antiquity > 0){
                        v = (v*0.20)+(((v*0.02)*antiquity));
                        listPayMonitor.add(new PayMonitors(k,v));
                    } else if (antiquity == 0) {
                        v = v-(v*0.20);
                        listPayMonitor.add(new PayMonitors(k,v));
                    }
                }
            } catch (ArithmeticException e){
                System.out.println("error");
            }
        });
    }


    public int getAntiquity(String name, ArrayList<Monitor> listMonitor){
        System.out.println(listMonitor.get(0).getDocument());
        try {
            List<Monitor> list1 = listMonitor;
            List<Monitor> list2 = list1.stream()
                    .filter(x -> x.getName().equalsIgnoreCase(name.toLowerCase()))
                    .collect(Collectors.toList());
            System.out.println("La antiquity : "+list2.get(0).getAntiquity());
            return list2.get(0).getAntiquity();
        }catch (NullPointerException e){

        }
        return -1;
    }


    public ArrayList<PayMonitors> getListPayMonitor() {
        return listPayMonitor;
    }
}
