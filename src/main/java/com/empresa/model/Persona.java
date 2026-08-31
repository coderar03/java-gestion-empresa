package com.empresa.model;

public abstract class Persona {
    private int id;
    private String nombre;
    private String email;

    //Constructor vacío
    public Persona() {        
    }

    //Constructor con parámetros
    public Persona (int id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;        
    }

    //Método abstracto
    public abstract void mostrarInfo();
    
    //Getters y Setters
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;        
    }

    public String getEmail (){
        return email;
    }

    public void setEmail(String email){
        this.email= email;
    }

}
