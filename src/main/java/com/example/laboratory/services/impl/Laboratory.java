package com.example.laboratory.services.impl;

public class Laboratory {
    private StudentServiceImpl studentServiceImpl;
    private MonitorServiceImpl monitorServiceImpl;

    private TeacherServiceImpl teacherServiceImpl;

    private ElementsServiceImpl elementsServiceImpl;

    public Laboratory() {
        studentServiceImpl = new StudentServiceImpl();
        monitorServiceImpl = new MonitorServiceImpl();
        teacherServiceImpl = new TeacherServiceImpl();
        elementsServiceImpl = new ElementsServiceImpl();
    }


    public StudentServiceImpl getStudentImpl(){
        return studentServiceImpl;
    }

    public MonitorServiceImpl getMonitorServiceImpl(){
        return monitorServiceImpl;
    }

    public TeacherServiceImpl getTeacheServiceImpl(){
        return teacherServiceImpl;
    }

    public ElementsServiceImpl getElementsServiceImpl(){
        return elementsServiceImpl;
    }






}
