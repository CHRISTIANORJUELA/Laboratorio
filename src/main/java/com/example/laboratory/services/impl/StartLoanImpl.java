package com.example.laboratory.services.impl;

import com.example.laboratory.models.*;
import com.example.laboratory.services.StartLoanService;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class StartLoanImpl implements StartLoanService {

    private double totalamount = 0;
    private int pricePerDay = 1000;
    ArrayList<StartLoan> listStarLoan = new ArrayList<>();
    ArrayList<FinishLoan> finishLoan = new ArrayList<>();



    public void addLoan(String nameManager, String namePerson, String nameElement, String stockElements, String codeLoad, String startTime, ArrayList<Student> listStudentImpl, ArrayList<Monitor> listMonitorImpl, ArrayList<Teacher> listTeacherImpl, ArrayList<Elements> elementsListImpl){
        String choiceValueManager = findTypePassManager(nameManager,listMonitorImpl,listTeacherImpl);
        String choiceValuePerson = findTypepPassPerson(namePerson,listStudentImpl,listTeacherImpl);
        boolean passCode = filter1(listStarLoan,codeLoad);
        Elements elements = findElement(nameElement,stockElements,elementsListImpl);
        LocalDate date = findIsCorrectLocalDate(startTime);
        try {
            if (filterPrincipalForAdd(choiceValueManager, choiceValuePerson, elements,date,passCode)) {
                Object valueNameManager = findvalueManager(nameManager, choiceValueManager, listMonitorImpl, listTeacherImpl);
                Object valueNamePerson = findValuePerson(namePerson, choiceValuePerson, listStudentImpl, listTeacherImpl);
                reduceStock(nameElement, stockElements, elementsListImpl);
                if (listStarLoan.size() == 0) {
                    listStarLoan.add(new StartLoan(nameManager, namePerson, choiceValueManager, choiceValuePerson, nameElement, Integer.parseInt(stockElements), codeLoad,date));
                }else {
                        listStarLoan.add(new StartLoan(nameManager, namePerson, choiceValueManager, choiceValuePerson, nameElement, Integer.parseInt(stockElements), codeLoad,date));
                }
            }
        }catch (Exception e){
            System.out.println("error cargar datos");
        }
    }


    public void termidedLoan(StartLoan st, LocalDate dateFinish, ArrayList<Student>listStudentsController, ArrayList<Monitor>listMonitorController,ArrayList<Teacher> listTeacherController,ArrayList<Elements> listElementsController){
        try {
            long dayLong = ChronoUnit.DAYS.between(st.getStartTime(),dateFinish);
            int days = (int) dayLong;
            double price = days*pricePerDay;
            totalamount += price;
            if (finishLoan.size() == 0){
                finishLoan.add(new FinishLoan(st.getNameManagerString(),st.getNamePersonString(),st.getNameTypeManager(),st.getNameTypePerson(),st.getNameElement(),st.getStockElements(),st.getCodeLoad(),dateFinish,price,days));
                for (int i = 0; i<listStarLoan.size();i++){
                    if (listStarLoan.get(i).getCodeLoad().equalsIgnoreCase(st.getCodeLoad())){
                        deleteLoan(i);
                    }break;
                }
            }else {
                finishLoan.add(new FinishLoan(st.getNameManagerString(),st.getNamePersonString(),st.getNameTypeManager(),st.getNameTypePerson(),st.getNameElement(),st.getStockElements(),st.getCodeLoad(),dateFinish,price,days));
                for (int i = 0; i<listStarLoan.size();i++){
                    if (listStarLoan.get(i).getCodeLoad().equalsIgnoreCase(st.getCodeLoad())){
                        deleteLoan(i);
                    }break;
                }
            }
        }catch (Exception e){
            System.out.println("Error in enter dates of finish Loan");
        }
    }


    public void deleteLoan(int i){
        listStarLoan.remove(i);
    }



    public String findTypePassManager(String nameManager,ArrayList<Monitor>listMonitorImpl,ArrayList<Teacher>listTeacherImpl){
        boolean mPass = listMonitorImpl.stream().anyMatch(x -> x.getName().equalsIgnoreCase(nameManager.toLowerCase()));
        boolean tPass = listTeacherImpl.stream().anyMatch(x -> x.getName().equalsIgnoreCase(nameManager.toLowerCase()));
        if (mPass == true && tPass == true){
            return "found two";
        }
        if (mPass == false && tPass == false ){
            return "not found";
        }
        if (mPass == true){
             return  "Monitor";
        }
        if (tPass == true){
            return "Teacher";
        }
        return "";
    }


    public String findTypepPassPerson(String namePerson,ArrayList<Student>listStudentImpl,ArrayList<Teacher>listTeacherImpl){
        boolean sPass = listStudentImpl.stream().anyMatch(x -> x.getName().equalsIgnoreCase(namePerson.toLowerCase()));
        boolean tPass = listTeacherImpl.stream().anyMatch(x -> x.getName().equalsIgnoreCase(namePerson.toLowerCase()));
        if (sPass == true && tPass == true){
            return "found two";
        }
        if (sPass == false && tPass == false ){
            return "not found";
        }
        if (sPass == true){
            return  "Student";
        }
        if (tPass == true){
            return "Teacher";
        }
        return "";
    }

   public Elements findElement(String nameElement,String stockElements ,ArrayList<Elements>elementsListImpl){
            try {
                for (int i =0;i<elementsListImpl.size();i++){
                    if (elementsListImpl.get(i).getName().equalsIgnoreCase(nameElement.toLowerCase()) && elementsListImpl.get(i).getStock() >= Integer.parseInt(stockElements) && elementsListImpl.get(i).getStatus() != false){
                        return elementsListImpl.get(i);
                    }break;
                }
            }catch (NumberFormatException e){
                System.out.println("Value in stock dont correct");
            }
        return null;
   }



   public boolean filterPrincipalForAdd(String passManager,String passPerson,Elements elements,LocalDate date,boolean passCode){
        if ( passManager != "found two" && passManager != "not found" && passPerson != "found two "  && passPerson != "not found" && elements != null && date != null && passCode != true){
            return true;
        }
        return false;
   }

    public Object findvalueManager(String nameManager,String choiceValueManager,ArrayList<Monitor>listMonitorImpl,ArrayList<Teacher>listTeacherImpl){
        try {
            switch (choiceValueManager){
                case "Monitor":
                    for (int i=0;i<listMonitorImpl.size();i++){
                        if (listMonitorImpl.get(i).getName().equalsIgnoreCase(nameManager.toLowerCase())){
                            return listMonitorImpl.get(i);
                        }
                    }
                    break;
                case "Teacher":
                    for (int i=0;i<listTeacherImpl.size();i++){
                        if (listTeacherImpl.get(i).getName().equalsIgnoreCase(nameManager.toLowerCase())){
                            return listTeacherImpl.get(i);
                        }
                    }
                    break;
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public Object findValuePerson(String namePerson,String choiceValuePerson,ArrayList<Student>listStudentImpl,ArrayList<Teacher>listTeacherImpl){
        try {
            switch (choiceValuePerson){
                case "Student":
                    for (int i=0;i<listStudentImpl.size();i++){
                        if (listStudentImpl.get(i).getName().equalsIgnoreCase(namePerson.toLowerCase())){
                            return listStudentImpl.get(i);
                        }
                    }
                    break;
                case "Teacher":
                    for (int i=0;i<listTeacherImpl.size();i++){
                        if (listTeacherImpl.get(i).getName().equalsIgnoreCase(namePerson.toLowerCase())){
                            return listTeacherImpl.get(i);
                        }
                    }
                    break;
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
}

    public void reduceStock(String nameElement,String stockElements,ArrayList<Elements>elementsListImpl){
        try {
            elementsListImpl.stream().filter(x -> x.getName().equalsIgnoreCase(nameElement.toLowerCase())).forEach(w ->{
                w.setStock(w.getStock()-Integer.parseInt(stockElements));
                if (w.getStock() == 0){
                    w.setStatus(false);
                }
            });
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public boolean filter1(ArrayList<StartLoan> listStarLoan, String code){
        try {
            boolean a = listStarLoan.stream().anyMatch(x -> x.getCodeLoad().equalsIgnoreCase(code.toLowerCase()));
            if (a){
                System.out.println("Value already exists");
            }
            return a;
        }catch (Exception e){

        }
        return false;
    }

    public LocalDate findIsCorrectLocalDate(String startTime){
        try {
            LocalDate lcate = LocalDate.parse(startTime);
            return lcate;
        }catch (Exception e){
            System.out.println("wrong date entered");
        }
        return null;
    }


    public ArrayList<StartLoan> getListStarLoan() {
        return listStarLoan;
    }

    public ArrayList<FinishLoan> getFinishLoan() {
        return finishLoan;
    }

    public double getTotalamount() {
        return totalamount;
    }



    public int getPricePerDay() {
        return pricePerDay;
    }


}
