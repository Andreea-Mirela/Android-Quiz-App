package com.example.firstquizz;

public class Intrebare {
    Integer Id;
     String text;
    Integer idImagine;
     String raspuns1;
     String raspuns2;
     String raspuns3;
    Integer idRaspunsCorect;

    public Intrebare(Integer id, String text, Integer idImagine, String raspuns1, String raspuns2, String raspuns3, Integer idRaspunsCorect) {
        Id = id;
        this.text = text;
        this.idImagine = idImagine;
        this.raspuns1 = raspuns1;
        this.raspuns2 = raspuns2;
        this.raspuns3 = raspuns3;
        this.idRaspunsCorect = idRaspunsCorect;
    }
}
