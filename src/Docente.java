import java.io.Serializable;
import java.util.*;

public class Docente implements Serializable {

    private String Nombre;
    private String Apellido;
    private int Clase;
    private String Materia;
    List<Estudiante> estudiantes = new ArrayList<>();


    public Docente() {
    }

    public Docente(String nombre, String apellido, int clase, String materia) {
        Nombre = nombre;
        Apellido = apellido;
        Clase = clase;
        Materia = materia;
        this.estudiantes = estudiantes;

    }

    public void registrarNotas(){
        int cantidadNotas;
        boolean s=false;
        Scanner t = new Scanner(System.in).useLocale(Locale.US);

        if (estudiantes.size()>0) {
            System.out.println("Cuantas notas va a registrar por estudiante: ");
            cantidadNotas = t.nextInt();

                for (Estudiante e : estudiantes) {
                    List<Double> nota = new ArrayList<>();
                    do {

                        System.out.println(e.getNombre() + " " + e.getApellido() + " : ");

                    for (int j = 0; j < cantidadNotas; j++) {
                        double nota2;
                        nota2 = t.nextDouble();
                        if (nota2 > 0 && nota2 <= 5) {
                            s = true;
                            nota.add(nota2);

                        } else System.out.println("Este valor no es valido y por lo tanto no se guardara; ingresa valores entre 0 y 5");

                    }
                } while (s == false);

                    e.setNotas(nota);
                }


        }else System.out.println("No hay estudiantes registrados");


    }

    public void añadirEstudiante(String nombre , String apellido, String documento){
        estudiantes.add(new Estudiante(nombre , apellido , documento));
        for (Estudiante e: estudiantes){
            if (e.getNombre().equals(nombre) && e.getApellido().equals(apellido) && e.getDocumento().equals(documento)){
                System.out.println("Estudiante: "+e.getNombre()+" "+e.getApellido()+" Incrito correctamente");
            }

        }

    }

    public void removerEstudiante(String nombre, String apellido, String documento) {
        try {
            Iterator<Estudiante> iterador = estudiantes.iterator();
            boolean encontrado = false;

            while (((java.util.Iterator<?>) iterador).hasNext()) {
                Estudiante e = iterador.next();
                if (e.getNombre().equals(nombre) &&  e.getApellido().equals(apellido) && e.getDocumento().equals(documento)) {

                    iterador.remove();
                    System.out.println("Se removió a: " + e);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Estudiante no encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar remover el estudiante: " + e.getMessage());
        }
    }

    public void visualizar (String nombre , String apellido , String documento){
        for (Estudiante m: estudiantes){
            if(m.getNombre().equals(nombre) && m.getApellido().equals(apellido)){
                System.out.println("Tus notas en esta clase son: "+ m.getNotas()+" y tu promedio en esta clase es: "+m.promedio());
            }
        }
    }

    public void visualizarP(){
        for (Estudiante m: estudiantes){
                System.out.println(m + " Promedio: " + m.promedio());
        }
    }

    public double promedioDeClase(){
        double promedio;
        double p=0;
        for (Estudiante e: estudiantes){
             p = p + e.promedio();
        }
        promedio = p/ estudiantes.size();
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

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public int getClase() {
        return Clase;
    }

    public void setClase(int clase) {
        this.Clase = clase;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Docente " +
                "Nombre= " + Nombre + '\'' +
                ", Apellido= " + Apellido + '\'' +
                ", Materia= " + Materia +
                ", clase= " + Clase +
                ", Estudiantes= "+ estudiantes;
    }
}
