package com.example.laboratory.services.impl;

import com.example.laboratory.controllers.MonitorController;
import com.example.laboratory.controllers.StudentController;
import com.example.laboratory.controllers.TeacherController;

public class Laboratory {
    private StudentServiceImpl studentServiceImpl;
    private MonitorServiceImpl monitorServiceImpl;

    private TeacherServiceImpl teacherServiceImpl;

    private ElementsServiceImpl elementsServiceImpl;

    private StartLoanImpl startLoanImpl;

    private InformationServiceImpl informationServiceImpl;

    private PayMonitorServiceImpl payMonitorService;



    public Laboratory() {
        studentServiceImpl = new StudentServiceImpl();
        monitorServiceImpl = new MonitorServiceImpl();
        teacherServiceImpl = new TeacherServiceImpl();
        elementsServiceImpl = new ElementsServiceImpl();
        startLoanImpl = new StartLoanImpl();
        informationServiceImpl = new InformationServiceImpl();
        payMonitorService = new PayMonitorServiceImpl();
    }


    public StudentServiceImpl getStudentImpl(){
        return studentServiceImpl;
    }

    public MonitorServiceImpl getMonitorServiceImpl(){
        return monitorServiceImpl;
    }

    public TeacherServiceImpl getTeacherServiceImpl(){
        return teacherServiceImpl;
    }

    public ElementsServiceImpl getElementsServiceImpl(){
        return elementsServiceImpl;
    }

    public StartLoanImpl getStartLoanImpl(){return startLoanImpl;}

    public InformationServiceImpl getInformationServiceImpl() {
        return informationServiceImpl;
    }

    public PayMonitorServiceImpl getPayMonitorService(){
        return payMonitorService;
    }
}
