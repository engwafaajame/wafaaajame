package com.emuniapp.emuni.Models;

public class Category {
    private  String id;
    private  String student_db_id;
    private  String category_name;
    private  String  category_description;

    public Category(String id, String student_db_id, String category_name, String category_description) {
        this.id = id;
        this.student_db_id = student_db_id;
        this.category_name = category_name;
        this.category_description = category_description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_db_id() {
        return student_db_id;
    }

    public void setStudent_db_id(String student_db_id) {
        this.student_db_id = student_db_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
}
