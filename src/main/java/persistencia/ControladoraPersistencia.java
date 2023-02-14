
package persistencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaprueba.logica.Alumno;
import jpaprueba.logica.Carrera;
import jpaprueba.logica.Materia;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    
    //////// INSTANCIAS DE LOS JPA CONTROLLERS ////////////
    AlumnoJpaController aluJpa = new AlumnoJpaController ();
    CarreraJpaController carreJpa = new CarreraJpaController();
    MateriaJpaController mateJpa = new MateriaJpaController();

    ///////////////////////////////
    //METODOS DE ENTIDAD/CLASE ALUMNO
    //////////////////////////////
    public void crearAlumno(Alumno alu) {
        aluJpa.create(alu);
    }
    public void eliminarAlumno(int id) {
        //EXEPCION POR SI NO EXISTE EL ID. EL TRY CATCH LO ARMA NETBEANS
        try {
            aluJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarAlumno(Alumno alu) {
        try {
            aluJpa.edit(alu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Alumno traerAlumno(int id) {
        return aluJpa.findAlumno(id);
    }
    public ArrayList<Alumno> traerListaAlumnos() {
        //El metodo findAlumnoEntities devuelve una List. Como en las controladoras estamos usando ArrayList hay que pasar
        //los datos de una List a un ArrayList (LO QUE SE HACE A CONTINUACION NO ES UN CASTEO
        List<Alumno> listita = aluJpa.findAlumnoEntities();
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno> (listita);
        
        return listaAlumnos;
    }
    
    ///////////////////////////////
    //METODOS DE ENTIDAD/CLASE ALUMNO
    //////////////////////////////

    public void crearCarrera(Carrera carre) {
        carreJpa.create(carre);
    }
    public void eliminarCarera(int id) {
        try {
            carreJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarCarrera(Carrera carre) {
        try {
            carreJpa.edit(carre);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Carrera traerCarrera(int id) {
        return carreJpa.findCarrera(id);
    }
    public ArrayList<Carrera> traerListaCarreras() {
        List<Carrera> listita = carreJpa.findCarreraEntities();
        ArrayList<Carrera> listaCarreras = new ArrayList<>(listita);
        return listaCarreras;
    }
    
    ///////////////////////////////
    //METODOS DE ENTIDAD/CLASE MATERIA
    //////////////////////////////

    public void crearMateria(Materia mate) {
        mateJpa.create(mate);
    }
    public void editarMateria(Materia mate) {
        try {
            mateJpa.edit(mate);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarMateria(int id) {
        try {
            mateJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Materia traerMateria(int id) {
        return mateJpa.findMateria(id);
    }

    public LinkedList<Materia> traerListaMaterias() {
        List<Materia> listita = mateJpa.findMateriaEntities();
        LinkedList listaMaterias = new LinkedList (listita);
        return listaMaterias;
    }     
}
