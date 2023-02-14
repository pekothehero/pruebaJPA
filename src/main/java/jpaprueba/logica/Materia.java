
package jpaprueba.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Materia implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String tipoCursada;
    @ManyToOne
    private Carrera carre;

    public Materia() {
    }

    public Materia(int id, String nombre, String tipoCursada, Carrera carre) {
        this.id = id;
        this.nombre = nombre;
        this.tipoCursada = tipoCursada;
        this.carre = carre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCursada() {
        return tipoCursada;
    }

    public void setTipoCursada(String tipoCursada) {
        this.tipoCursada = tipoCursada;
    }

    public Carrera getCarre() {
        return carre;
    }

    public void setCarre(Carrera carre) {
        this.carre = carre;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre=" + nombre + ", tipoCursada=" + tipoCursada + '}';
    }
    
    
}
