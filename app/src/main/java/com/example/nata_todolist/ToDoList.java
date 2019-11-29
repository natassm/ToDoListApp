package com.example.nata_todolist;

public class ToDoList {

    String titledoes, datadoes, datedoes;

    public ToDoList(){

    }

    public ToDoList(String titledoes, String datadoes, String datedoes) {
        this.titledoes = titledoes;
        this.datadoes = datadoes;
        this.datedoes = datedoes;
    }

    public String getTitledoes() {
        return titledoes;
    }

    public void setTitledoes(String titledoes) {
        this.titledoes = titledoes;
    }

    public String getDatadoes() {
        return datadoes;
    }

    public void setDatadoes(String datadoes) {
        this.datadoes = datadoes;
    }

    public String getDatedoes() {
        return datedoes;
    }

    public void setDatedoes(String datedoes) {
        this.datedoes = datedoes;
    }
}
