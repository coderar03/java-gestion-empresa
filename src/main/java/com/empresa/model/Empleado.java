package com.empresa.model;

public class Empleado extends Persona {
    private int salario;
    private String departamento;

    //constructor vacío
    public Empleado(){
        super(); // Llama al constructor vacío de Persona      
    }

    //constructor con parámetros
    public Empleado(int id, String nombre, String email, int salario, String departamento){
        super(id,nombre,email);
        this.salario = salario;
        this.departamento = departamento;
    }

    // getters y setters

    public int getSalario(){
        return salario;
    }

    public void setSalario(int salario){
        this.salario = salario;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    //Implementación del método abstracto
    @Override

    public void mostrarInfo(){
        System.out.println("Id: " + getId() +
                            " | Empleado: " + getNombre() + 
                            " | Email: " + getEmail() + 
                            " | Salario: " + getSalario() + 
                            " | Departamento: " + getDepartamento());
    }

    //Método para cálculo del salario anual
    public float calcularSalarioAnual(){
        return salario * 12;
    }

}


