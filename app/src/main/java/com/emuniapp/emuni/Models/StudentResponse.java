package com.emuniapp.emuni.Models;

import java.util.List;

public class StudentResponse {

    private List<Student> students = null;

    public List<Student> getstudents ()
    {
        return students ;
    }

    public void setstudents (List<Student>students )

    {
        this.students  = students ;
    }
}
