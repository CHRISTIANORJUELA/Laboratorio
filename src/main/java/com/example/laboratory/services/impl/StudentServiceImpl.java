package com.example.laboratory.services.impl;


import com.example.laboratory.models.Student;
import com.example.laboratory.services.StudentService;
import com.example.laboratory.utils.UtilisMethods;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {

    private ArrayList<Student> listStudents = new ArrayList<>();

    private ArrayList<Student> listStudentFilter = new ArrayList<>();

    public void addStudent(String name, String document, String age, String semester, String career){
        if (listStudents.size() == 0){
            listStudents.add(new Student(name,document,age,semester,career));
        } else {
            if (filter1(listStudents,document)){
                System.out.println("Value already exists");
            }else{
                listStudents.add(new Student(name, document, age, semester, career));
            }
        }
    }


    public  void upDateStudent(Student p,String name,String document,String age,String semester,String career,ObservableList<Student>observableListFalse,ObservableList<Student>observableListFilterFalse){
         try {
             if(observableListFalse.size()<=listStudents.size() || !filter1(listStudents,document)){
                 listStudents.stream().filter(x -> x.getName().equalsIgnoreCase(p.getName().toLowerCase()) && x.getDocument().equalsIgnoreCase(p.getDocument())).forEach(w ->{
                     w.setName(name);
                     if (!filter1(listStudents,document)){
                         w.setDocument(document);
                     }
                     w.setAge(age);
                     w.setSemester(semester);
                     w.setCareer(career);
                 });
             }
         }catch (Exception e){

         }
    }



    public boolean filter1(ArrayList<Student> listStudents, String tfDocument){
        boolean a = listStudents.stream().anyMatch(x -> x.getDocument().equalsIgnoreCase(tfDocument));
        return a;
    }

    public void filterProcesStudent(ChoiceBox<String>boxSelectFilter,String filterName){
        try {
            switch (UtilisMethods.getValueBox(boxSelectFilter)){
                case "Name":
                    listStudentFilter.clear();
                    listStudents.stream().filter(x -> x.getName().toLowerCase().contains(filterName.toLowerCase())).forEach( w ->{
                        listStudentFilter.add(w);
                    });
                    break;
                case "Document":
                    listStudentFilter.clear();
                    listStudents.stream().filter(x -> x.getDocument().toLowerCase().contains(filterName.toLowerCase())).forEach( w ->{
                        listStudentFilter.add(w);
                    });
                    break;
                case "Age":
                    listStudentFilter.clear();
                    listStudents.stream().filter(x -> x.getAge().toLowerCase().contains(filterName.toLowerCase())).forEach( w ->{
                        listStudentFilter.add(w);
                    });
                    break;
            }
        }catch (NullPointerException e){

        }
    }


    public void deleteStudent(Student p){
        for (int i =0;i<listStudents.size();i++){
            if (listStudents.get(i).getName().equalsIgnoreCase(p.getName().toLowerCase()) && listStudents.get(i).getDocument().equalsIgnoreCase(p.getDocument().toLowerCase())){
                delete1(listStudents,i);
            }
        }
    }

    public void  delete1(ArrayList<Student>listStudents,int i){
        listStudents.remove(i);
    }

    public ArrayList<Student> returnListStudents() {
        return this.listStudents;
    }

    public ArrayList<Student>returnListStudentFilter(){
        return this.listStudentFilter;
    }


}
