package ru.zubkov.hhtest.otherscripts;

import java.util.Date;

public class Person {
    private int id = 0;
    private Note note;
    private String name;

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public Person(int id, Note note) {
        this.id = id;
        this.note = note;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void ssetDate(){
        note.setDate((new Date()).toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
