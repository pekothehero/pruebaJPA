
package jpaprueba.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    
    ControladoraPersistencia ctrlPersis = new ControladoraPersistencia(); //INSTANCIA DE CONTROLADORA DE PERSISTENCIA
    
    

    ///////////////////////////////////////
    //METODOS DE CLASE/ENTIDAD ALUMNO
    ////////////////////////////////////////
    
    //METODO PARA ENVIAR LOS DATOS DE UN NUEVO ALUMNO (OBJETO ALUMNO) 
    //AL METODO EQUIVALENTE EN LA CONTROLADORA DE PERSISTENCIA
    public void crearAlumno (Alumno alu){
        ctrlPersis.crearAlumno(alu);
    }    
    public void eliminarAlumno (int id){
        ctrlPersis.eliminarAlumno(id);
    }    
    public void editarAlumno(Alumno alu){
        ctrlPersis.editarAlumno(alu);
    }    
    public Alumno traerAlumno(int id){
        return ctrlPersis.traerAlumno(id);
    }    
    public ArrayList<Alumno> traerListaAlumnos (){
        return ctrlPersis.traerListaAlumnos();
    }
    
    ///////////////////////////////////////
    //METODOS DE CLASE/ENTIDAD CARRERA
    ////////////////////////////////////////
    public void crearCarrera (Carrera carre){
        ctrlPersis.crearCarrera(carre);
    }
    public void eliminarCarrera (int id){
        ctrlPersis.eliminarCarera(id);
    }
    public void editarCarrera (Carrera carre){
        ctrlPersis.editarCarrera(carre);
    }
    public Carrera traerCarrera (int id){
        return ctrlPersis.traerCarrera(id);
    }
    public ArrayList<Carrera> traerListaCarreras(){
        return ctrlPersis.traerListaCarreras();
    }
    
    ///////////////////////////////////////
    //METODOS DE CLASE/ENTIDAD CARRERA
    ////////////////////////////////////////
    public void crearMateria(Materia mate){
        ctrlPersis.crearMateria(mate);
    }
    public void editarMateria(Materia mate){
        ctrlPersis.editarMateria(mate);
    }
    public void eliminarMateria(int id){
        ctrlPersis.eliminarMateria(id);
    }
    public Materia traerMateria(int id){
        return ctrlPersis.traerMateria(id);
    }
    public LinkedList<Materia> traerListaMaterias(){
        return ctrlPersis.traerListaMaterias();
    }
}
