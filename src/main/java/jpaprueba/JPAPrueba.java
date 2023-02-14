

package jpaprueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaprueba.logica.Alumno;
import jpaprueba.logica.Carrera;
import jpaprueba.logica.ControladoraLogica;
import jpaprueba.logica.Materia;
//import persistencia.ControladoraPersistencia;


public class JPAPrueba {

    public static void main(String[] args) {
        
        ////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////
        ////////          ENTIDAD/CLASE ALUMNOS        ///////////////
        //////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////        
        
        //ESTA CONTROLADORA YA NO SE USA PORQUE NO CUMPLE EL MODELO DE CAPAS
        //ControladoraPersistencia controPersis = new ControladoraPersistencia(); 
        
        /*
        Alumno alu1 = new Alumno(20,"Sanji", "Vinsmoke", new Date());//EN REALIDAD ESTO VENDRIA DESDE LA IGU
        Alumno alu2 = new Alumno(17,"Hoshino", "Yutaka", new Date());//EN REALIDAD ESTO VENDRIA DESDE LA IGU
        controLogica.crearAlumno(alu1);
        */
        
                
        //Creacion de un nuevo Alumno para luego editarlo
        /*
        Alumno alu = new Alumno(18,"Bart", "Simpsons", new Date());
        /*
        
        
        /*
        System.out.println("Wait a moment");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JPAPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        //Edicion mediante metodo EDIT (se envia un objeto completo)
        /*
        alu.setNombre("Var Tolomeo");
        alu.setApellido("Sinso");
        controLogica.editarAlumno(alu);
        */
                
        //controLogica.eliminarAlumno(16);
        
        //Traer un registro con Find
        /*
        Alumno aluAux = controLogica.traerAlumno(20);
        System.out.println("El alumno es: " + aluAux.getNombre()+" "+aluAux.getApellido());
        
        //Traer todos los registros con FindEntities
        ArrayList<Alumno> listaAux = controLogica.traerListaAlumnos();
        
        System.out.println("TRAER TODOS LOS ALUMNOS");
        System.out.println("---------------------------");
        for (Alumno alu:listaAux){
            System.out.println("Alumno: " + alu.getNombre());
            System.out.println("----------------");
        }
        */
        
        
        ////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////
        ////////       ONE TO ONE      ALUMNO & CARRERA       /////////
        //////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////  
        
        /*
        ArrayList<Alumno> listaAlumnos = controLogica.traerListaAlumnos();
        
        System.out.println("LISTADO DE ALUMNOS: ");
        System.out.println("");
        for (Alumno i:listaAlumnos){
            System.out.println("El alumno: " + i.getNombre() + " " + i.getApellido());
            System.out.println("Esta inscripto en la carrera: " + i.getCarre().getNombre());
            System.out.println("-------------------");
        }
        */
        /*
        Alumno alumno1 = controLogica.traerAlumno(1);
        
        System.out.println("El alumno : "+ alumno1.getNombre() + " " + alumno1.getApellido());
        System.out.println("Cursa la carrera: " + alumno1.getCarre().getNombre());
        */
        
        ////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////
        ////////   ONE TO MANY   ALUMNO & CARRERA $ MATERIA   /////////
        //////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////
                
        /*
        Materia mate1 = new Materia (1,"Quimica","Cuatrimestral");
        controLogica.crearMateria(mate1);
        Materia mate2 = new Materia (2,"Fisica","Cuatrimestral");
        controLogica.crearMateria(mate2);
        Materia mate3 = new Materia (3,"Filosofia","Anual");
        controLogica.crearMateria(mate3);
        Materia mate4 = new Materia (4,"Elementos de Audio","Anual");
        controLogica.crearMateria(mate4);
        */
        
        //////////////////////////////////////////////////////
        //////////////////////////////////////////////////////
        ////////////////EJERCICIO COMPLETO///////////////////
        ////////////////////////////////////////////////////
        ////////////////////////////////////////////////////
        
        //Instancia de una ControladoraLogica
        ControladoraLogica controLogica = new ControladoraLogica ();
        
        //Creacion de una lista de materias. Estara vacia porque todavia no se cargaron materias
        LinkedList<Materia> listaMaterias = new LinkedList<>();
                
        //Instanciacion de una carrera (con la lista de materias vacia)
        Carrera carre = new Carrera (1,"Tecnicatura en Programacion",listaMaterias);
        //Creacion de la carrera en la BD
        controLogica.crearCarrera(carre);
        
        //Instanciacion y carga en BD de materias. Con la carrera asignada
        Materia mate1 = new Materia (1, "Programacion I","Cuatrimestral",carre);
        Materia mate2 = new Materia (2, "Programacion II","Cuatrimestral",carre);
        Materia mate3 = new Materia (2, "Matematica I","Anual",carre);
        controLogica.crearMateria(mate1);
        controLogica.crearMateria(mate2);
        controLogica.crearMateria(mate3);
        
        //Carga de materias a la lista de materias
        listaMaterias.add(mate1);
        listaMaterias.add(mate2);
        listaMaterias.add(mate3);
        
        //Edicion de la lista de materias de carre a nivel Logico
        carre.setListaMaterias(listaMaterias);
        //Edicion de la lista de materias de carre a nivel BD
        controLogica.editarCarrera(carre);
        
        //Creacion de Alumno (logica)
        Alumno alu = new Alumno (1,"Gonzalo","Henriquez",new Date(),carre);
        //Creacion de alumno en BD
        controLogica.crearAlumno(alu);
        
        
        
        System.out.println("El alumno 1 es: " + controLogica.traerAlumno(1).getNombre() + " " + 
                controLogica.traerAlumno(1).getApellido() );
        System.out.println("Esta inscripto en la carrera: " + controLogica.traerAlumno(1).getCarre().getNombre());
        System.out.println("Esta carrera tiene las materias: ");
        LinkedList<Materia> listita = controLogica.traerCarrera(1).getListaMaterias();
        for (Materia i : listita){
            System.out.println(i.getNombre());
        }
        
} 

}
