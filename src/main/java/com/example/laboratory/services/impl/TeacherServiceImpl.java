package com.example.laboratory.services.impl;

import com.example.laboratory.models.Teacher;
import com.example.laboratory.services.TeacherService;
import com.example.laboratory.utils.UtilisMethods;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;


public class TeacherServiceImpl implements TeacherService {

    ArrayList<Teacher> listTeacher = new ArrayList<>();
    ArrayList<Teacher> filterListTeacher = new ArrayList<>();
    public void addTeacher(String name, String document, String age, String course, String codeRoom){
        if (listTeacher.size() == 0){
            listTeacher.add(new Teacher(name,document,age,course,codeRoom));
        } else {
            if (filter1(listTeacher,document)){
                System.out.println("Value already exists");
            }else{
                listTeacher.add(new Teacher(name, document, age, course, codeRoom));
            }
        }
    }

    public void upDateTeacher(Teacher p,ObservableList<Teacher>observableListFalse,String name,String document,String age,String course,String coderoom) {
        try {
            if(observableListFalse.size()<=listTeacher.size() || !filter1(listTeacher,document)){
                listTeacher.stream().filter(x -> x.getName().equalsIgnoreCase(p.getName().toLowerCase()) && x.getDocument().equalsIgnoreCase(p.getDocument())).forEach(w ->{
                    w.setName(name);
                    if (!filter1(listTeacher,document)){
                        w.setDocument(document);
                    }
                    w.setAge(age);
                    w.setCourse(course);
                    w.setCodeRoom(coderoom);
                });
            }
        }catch (Exception e){

        }
    }

    public void filterProcessTeacher(ChoiceBox<String>choiceBoxSelect,String valueFilter){
        try {
            switch (UtilisMethods.getValueBox(choiceBoxSelect)){
                case "Name":
                    filterListTeacher.clear();
                    listTeacher.stream().filter(x -> x.getName().toLowerCase().contains(valueFilter.toLowerCase())).forEach( w ->{
                        filterListTeacher.add(w);
                    });
                    break;
                case "Document":
                    filterListTeacher.clear();
                    listTeacher.stream().filter(x -> x.getDocument().toLowerCase().contains(valueFilter.toLowerCase())).forEach( w ->{
                        filterListTeacher.add(w);
                    });
                    break;
                case "CodeRoom":
                    filterListTeacher.clear();
                    listTeacher.stream().filter(x -> x.getCodeRoom().toLowerCase().contains(valueFilter.toLowerCase())).forEach( w ->{
                        filterListTeacher.add(w);
                    });
                    break;

            }
        }catch (NullPointerException e){
            System.out.println("Please select a value in campus");
        }
    }

    public void deleteTeacher(Teacher t){
        for (int i =0;i<listTeacher.size();i++){
            if (listTeacher.get(i).getName().equalsIgnoreCase(t.getName().toLowerCase()) && listTeacher.get(i).getDocument().equalsIgnoreCase(t.getDocument().toLowerCase())){
                delete1(listTeacher,i);
            }
        }
    }

    public void  delete1(ArrayList<Teacher>listStudents,int i){
        listStudents.remove(i);
    }
    public boolean filter1(ArrayList<Teacher> teachers, String tfDocument){
        boolean a = teachers.stream().anyMatch(x -> x.getDocument().equalsIgnoreCase(tfDocument));
        return a;
    }

    public ArrayList<Teacher> getListTeacher() {
        return listTeacher;
    }

    public ArrayList<Teacher> getFilterListTeacher() {
        return filterListTeacher;
    }
}
