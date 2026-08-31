package com.empresa.interfaces;

import com.empresa.model.Persona;

//Interface
public interface OperacionesEmpresa {
    void registrarPersona(Persona p);
    void eliminarPersona(int id);
    Persona buscarPersona(String nombre);
    void listarPersonas();    
    
}
