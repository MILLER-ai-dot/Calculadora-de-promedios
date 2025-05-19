import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Estudiante implements Serializable {

    private String Nombre;
    private String Apellido;
    private String Documento;
    private List<Double> notas = new ArrayList();


    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String documento) {
        Nombre = nombre;
        Apellido = apellido;
        Documento = documento;
        this.notas = notas;
    }

    public double promedio() {
        double p = 0;
        double promedio;
        for (int i = 0; i < notas.size(); i++) {
            p = p + notas.get(i);
        }
        promedio = p / notas.size();
        return promedio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Estudiante " +
                "Nombre= " + Nombre  +
                ", Apellido= " + Apellido +
                ", Notas = " + notas;
    }
}
