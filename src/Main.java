import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
// codigo hecho por: Miller Chacon 970102 y Alejandro Quiroga 973076
        DecimalFormat formato = new DecimalFormat("0.00");
        boolean cerrar=false;
        String opc;
        List<Docente> docentes = new ArrayList<>();
        List<Estudiante> estudiantes = new ArrayList<>();
        cargarDocentes(docentes);
        cargarEstudiantes(estudiantes);
        Scanner t = new Scanner(System.in).useLocale(Locale.US);

        do {

            System.out.println(Colores.NARANJA+"----------------------------------------------------------");
            System.out.println(Colores.NARANJA+" >>BIENVENIDO VAMOS A CALCULAR TU PROMEDIO DE NOTAS<<");
            System.out.println(Colores.NARANJA+"----------------------------------------------------------");
            System.out.println(Colores.CYAN+ """
                    
                    1) Soy un estudiante y quiero calcular mi promedio
                    
                    2) Soy un docente y quiero calcular varios promedios
                                       
                    3) Soy un directivo y quiero ver el rendimiento docente
                                       
                    4) Cerrar programa                                       
                    """);
            System.out.println(Colores.NARANJA+"----------------------------------------------------------");

            opc = t.next();

            limpiarPantalla();

            switch (opc) {

                case "1" -> {
                    String opc2;
                    boolean cerrado1=false;
                    do {

                        System.out.println(Colores.NARANJA+"-----------------------------------");
                        System.out.println(Colores.NARANJA+" >> Bienvenido que deseas hacer << ");
                        System.out.println(Colores.NARANJA+"-----------------------------------");
                        System.out.println(Colores.CYAN+"""
                                
                            1) Registrarme
                            
                            2) Iniciar sesion
                            
                            3) Salir
                                """);
                        System.out.println(Colores.NARANJA+"-----------------------------------");
                    opc2 = t.next();
                    limpiarPantalla();
                        switch (opc2) {
                            case "1" -> {
                                String nombre;
                                String apellido;
                                String documento;
                                boolean valido=true;
                                t.nextLine();
                                System.out.println(Colores.NARANJA+"----------------------");
                                System.out.println(Colores.NARANJA+"  **Registrando**");
                                System.out.println(Colores.NARANJA+"----------------------");
                                System.out.println(Colores.CYAN);
                                System.out.println("Ingrese su nombre: ");
                                nombre = t.nextLine().strip();
                                System.out.println("Ingrese su apellido: ");
                                apellido = t.nextLine().strip();
                                System.out.println("Ingrese su Contraseña: ");
                                documento = t.nextLine().strip();

                                for (Estudiante e: estudiantes){
                                    if (e.getNombre().equals(nombre) && e.getApellido().equals(apellido) && e.getDocumento().equals(documento)){
                                        valido = false;
                                    }
                                }
                                if (valido){
                                    estudiantes.add(new Estudiante(nombre,apellido,documento));
                                    System.out.println(Colores.CYAN+"Inscrito correctamente");
                                }else System.out.println(Colores.ROJO+"Este usuario ya existe ");



                            }
                            case "2" -> {
                                String opc3;
                                boolean cerrado2 = false;
                                boolean encontrado2 = false;
                                String nombre;
                                String apellido;
                                String documento;
                                t.nextLine();
                                System.out.println(Colores.NARANJA+"----------------------");
                                System.out.println(Colores.NARANJA+" **Iniciando sesion** ");
                                System.out.println(Colores.NARANJA+"----------------------");
                                System.out.println(Colores.CYAN);
                                System.out.println("Identificate");
                                System.out.println("Ingrese su nombre: ");
                                nombre = t.nextLine().strip();
                                System.out.println("Ingrese su apellido: ");
                                apellido = t.nextLine().strip();
                                System.out.println("Ingrese su Contraseña: ");
                                documento = t.nextLine().strip();
                                System.out.println(Colores.NARANJA+"----------------------");
                                for (Estudiante e: estudiantes) {
                                    if (e.getNombre().equals(nombre) && e.getApellido().equals(apellido) && e.getDocumento().equals(documento)){
                                        do {
                                            encontrado2 = true;

                                            System.out.println(Colores.NARANJA+"----------------------------------");
                                            System.out.println(Colores.NARANJA+"      >> Que deseas hacer <<");
                                            System.out.println(Colores.NARANJA+"----------------------------------");
                                            System.out.println(Colores.CYAN+ """
                                                    
                                            1) Ver clases disponibles
                                            
                                            2) Inscribir clase
                                            
                                            3) Cancelar clase
                                            
                                            4) Ver calificacion de una clase
                                            
                                            5) Salir
                                                    """);
                                            System.out.println(Colores.NARANJA+"----------------------------------");
                                            opc3 = t.next();
                                            System.out.println(Colores.CYAN);
                                            switch (opc3) {
                                                case "1" -> {
                                                    for(Docente r: docentes){
                                                        System.out.println("Materia: "+r.getMateria()+" Codigo de clase: "+r.getClase() + " Docente: "+ r.getNombre() + " "+r.getApellido());
                                                    }
                                                    if (docentes.size()==0){
                                                        System.out.println(Colores.ROJO+"Aun no hay clases :(");
                                                    }
                                                }
                                                case "2" -> {
                                                    String codigo;
                                                    boolean encontrado=false;
                                                    boolean valido=true;
                                                    System.out.println("Ingrese codigo de clase a inscribir: ");
                                                    codigo = t.next();
                                                    for(Docente r: docentes){
                                                        if (r.getClase().equals(codigo) && r.validarInscrito(nombre, apellido, documento)) {
                                                            r.añadirEstudiante(nombre,apellido,documento);
                                                            System.out.println("En la clase: " + r.getMateria()+ " codigo: "+ r.getClase());
                                                        }
                                                    }
                                                    for (Docente r: docentes){
                                                        if (r.getClase().equals(codigo)&&!r.validarInscrito(nombre, apellido, documento)){
                                                            valido = false;
                                                        }
                                                    }
                                                    if (!valido){
                                                        System.out.println(Colores.VERDE+"El estudiante ya esta inscrito");
                                                    }

                                                    for (Docente x : docentes){
                                                        if (x.getClase().equals(codigo)){
                                                            encontrado=true;
                                                        }
                                                    }
                                                    if (!encontrado){
                                                        System.out.println(Colores.ROJO+"Clase no encontrada");
                                                    }

                                                }
                                                case "3" -> {
                                                    String codigo;
                                                    boolean encontrado=false;
                                                    System.out.println("Ingrese codigo de clase a Cancelar: ");
                                                    codigo = t.next();
                                                    for (Docente m : docentes){
                                                        if (m.getClase().equals(codigo)){
                                                            m.removerEstudiante(nombre,apellido,documento);
                                                            encontrado=true;
                                                        }
                                                    }
                                                    if (!encontrado){
                                                        System.out.println(Colores.ROJO+"No se encontro esta clase");
                                                    }
                                                }
                                                case "4" -> {
                                                    String clase;
                                                    boolean encontrado=false;
                                                    System.out.println("Que clase quieres consultar");
                                                    clase = t.next().strip();
                                                    for (Docente m: docentes){
                                                        if ( m.getClase().equals(clase)){
                                                            m.visualizar(nombre , apellido , documento);
                                                            encontrado=true;
                                                        }
                                                    }
                                                    if (!encontrado){
                                                        System.out.println(Colores.ROJO+"No estas inscrito a esta clase");
                                                    }
                                                }
                                                case "5" -> {
                                                    cerrado2 = true;
                                                    System.out.println("Saliendo");
                                                    limpiarPantalla();
                                                }
                                                default -> System.out.println(Colores.ROJO+"Ingrese una opcion correcta ");
                                            }
                                        }while (cerrado2 != true);
                                    }

                                }

                                if (!encontrado2){
                                    System.out.println(Colores.ROJO+"Usuario no encontrado");
                                }

                            }
                            case "3" -> {
                                cerrado1 = true;
                                System.out.println("Saliendo...");
                                limpiarPantalla();

                            }
                            default -> System.out.println(Colores.ROJO+"Ingrese una opcion correcta");
                        }
                    }while (cerrado1!=true);


                }

                case "2" -> {
                    boolean cerrar2=false;
                    String opc2;
                    do {

                        System.out.println(Colores.NARANJA+"--------------------------------------------------");
                        System.out.println(Colores.NARANJA+"  >> Que accion como docente quieres realizar <<");
                        System.out.println(Colores.NARANJA+"--------------------------------------------------");
                        System.out.println(Colores.CYAN+ """
                
                1) Registrarme en una clase
                
                2) Iniciar sesion
                
                3) Salir
                                        """);
                        System.out.println(Colores.NARANJA+"--------------------------------------------------");
                        opc2 = t.next();
                        limpiarPantalla();
                        switch (opc2) {

                            case "1" -> {
                                String nombre;
                                String apellido;
                                String materia;
                                boolean valido = true;
                                String clase;
                                System.out.println(Colores.NARANJA+"----------------------");
                                System.out.println(Colores.NARANJA+"  **Registrando**");
                                System.out.println(Colores.NARANJA+"----------------------");
                                System.out.println(Colores.CYAN);
                                System.out.println("Ingrese su nombre: ");
                                nombre = t.next().strip();
                                System.out.println("Ingrese su apellido: ");
                                apellido = t.next().strip();
                                System.out.println("Ingrese que Materia va a dictar: ");
                                materia = t.next().strip();
                                System.out.println("ingrese su codigo de clase: ");
                                clase = t.next().strip();
                                System.out.println(Colores.NARANJA+"----------------------");
                                for (Docente e: docentes){
                                    if (e.getClase().equals(clase)){
                                        valido = false;
                                    }
                                }
                                if (valido) {
                                    docentes.add(new Docente(nombre, apellido, clase, materia));
                                    System.out.println(Colores.CYAN+"Se registro correctamente");
                                }else System.out.println(Colores.ROJO+"Este  codigo de clase ya existe ");
                            }
                            case "2" -> {
                                String nombre;
                                String apellido;
                                String clase;
                                boolean encontrado2 = false;
                                System.out.println(Colores.NARANJA+"----------------------");
                                System.out.println(Colores.NARANJA+" **Iniciando sesion**");
                                System.out.println(Colores.NARANJA+"----------------------");
                                System.out.println(Colores.CYAN);
                                System.out.println("Identificate: ");
                                System.out.println("Ingrese su nombre: ");
                                nombre = t.next().strip();
                                System.out.println("Ingrese su apellido: ");
                                apellido = t.next().strip();
                                System.out.println("ingrese su codigo de clase: ");
                                clase = t.next().strip();
                                System.out.println(Colores.NARANJA+"----------------------");
                                for (Docente m: docentes){
                                    if (m.getNombre().equals(nombre) && m.getApellido().equals(apellido) && m.getClase().equals(clase)){
                                        String opc3;
                                        boolean cerrar3=false;

                                        do {
                                            encontrado2=true;

                                            System.out.println(Colores.NARANJA+"----------------------------------");
                                            System.out.println(Colores.NARANJA+"      >>Que deseas hacer <<");
                                            System.out.println(Colores.NARANJA+"----------------------------------");
                                            System.out.println(Colores.CYAN+ """
                                                    
                                                    1) Registrar notas
                                                    
                                                    2) Visualizar notas
                                                    
                                                    3) Salir
                                                    """);
                                            System.out.println(Colores.NARANJA+"----------------------------------");
                                            opc3 = t.next();
                                            System.out.println(Colores.CYAN);
                                            switch (opc3) {
                                                case "1" -> {
                                                    for (Docente e : docentes) {
                                                        if (e.getNombre().equals(nombre) && e.getApellido().equals(apellido) && e.getClase().equals(clase)) {
                                                            e.registrarNotas();
                                                        }
                                                    }
                                                }
                                                case "2" -> {
                                                    for (Docente e : docentes) {
                                                        if (e.getNombre().equals(nombre) && e.getApellido().equals(apellido) && e.getClase().equals(clase)) {
                                                           e.visualizarP();
                                                        }
                                                    }
                                                }
                                                case "3" -> {
                                                    cerrar3 = true;
                                                    System.out.println("Saliendo...");
                                                    limpiarPantalla();
                                                }
                                                default -> System.out.println(Colores.ROJO+"Ingresa una opcion valida");
                                            }
                                        }while (cerrar3!=true);
                                    }
                                }

                                if (!encontrado2){
                                    System.out.println(Colores.ROJO+"Usuario no encontrado");
                                }


                            }


                            case "3" -> {
                                cerrar2=true;
                                System.out.println("Saliendo...");
                                limpiarPantalla();
                            }

                            default -> {
                                System.out.println(Colores.ROJO+"Ingresa una opcion correcta");
                            }
                        }
                    }while (cerrar2 != true);

                }

                case "3" -> {
                    boolean cerrar2=false;
                    String opc2;
                    do{

                        System.out.println(Colores.NARANJA+"---------------------------------------------------");
                        System.out.println(Colores.NARANJA+"  >> Que accion deseas realizar como directivo <<");
                        System.out.println(Colores.NARANJA+"---------------------------------------------------");
                        System.out.println(Colores.CYAN+ """
                                
                            1) Ver lista de docentes
                            
                            2) Ver clases con mayor promedio de notas 
                            
                            3) Ver clases con menor promedio de notas  
                            
                            4) Ver promedio total de la institucion
                            
                            5) Salir 
                                """);
                        System.out.println(Colores.NARANJA+"---------------------------------------------------");
                    opc2 = t.next();
                        System.out.println(Colores.CYAN);
                    switch (opc2) {
                        case "1" -> {
                            for (Docente e: docentes){
                                System.out.println("Docente: "+e.getNombre()+" "+e.getApellido()+" Clase: "+e.getClase());
                            }
                            if(docentes.size()==0){
                                System.out.println(Colores.ROJO+"No hay docentes registrados");
                            }
                        }

                        case "2" -> {
                            double n =5.1;

                            for (Docente e: docentes){
                                if(e.promedioDeClase()>3.0){
                                    System.out.println("Docente: " +e.getNombre()+" "+e.getApellido()+" El promedio de su clase es: "+formato.format(e.promedioDeClase()));
                                }
                            }
                            if(docentes.size()==0){
                                System.out.println(Colores.ROJO+"No hay docentes registrados");
                            }
                        }
                        case "3" -> {
                            double n =0.0;
                            for (Docente e: docentes){

                                if(e.promedioDeClase()<3.0){
                                    System.out.println("Docente: " +e.getNombre()+" "+e.getApellido()+" El promedio de su clase es: "+formato.format(e.promedioDeClase()));
                                }
                            }
                            if(docentes.size()==0){
                                System.out.println(Colores.ROJO+"No hay docentes registrados");
                            }
                        }
                        case "4" -> {
                            double promedio;
                            double p=0;
                            for (Docente e: docentes){
                                p = p + e.promedioDeClase();
                            }
                            promedio = p/ docentes.size();
                            System.out.println("El promedio institucional es de: "+formato.format(promedio));
                        }
                        case "5" -> {
                            cerrar2=true;
                            System.out.println("Saliendo...");
                            limpiarPantalla();
                        }
                        default -> {
                            System.out.println(Colores.ROJO+"Ingrese una opcion correcta");
                        }
                    }
                }while (cerrar2!=true);

                }

                case "4" -> {
                    guardarDocentes(docentes);
                    guardarEstudiantes(estudiantes);
                    cerrar = true;
                    System.out.println("Cerrando...");
                }

                default -> {
                    System.out.println(Colores.ROJO+"Ingresa una opcion correcta");

                }

            }

        }while (cerrar!=true);

    }
    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la pantalla.");
        }
    }



    public static void guardarDocentes(List<Docente> docentes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("docentes.txt"))) {
            for (Docente d : docentes) {
                StringBuilder sb = new StringBuilder();
                sb.append(d.getNombre()).append(",").append(d.getApellido()).append(",").append(d.getClase()).append(",").append(d.getMateria());
                for (Estudiante e : d.getEstudiantes()) {
                    sb.append(";")
                            .append(e.getNombre()).append(":")
                            .append(e.getApellido()).append(":")
                            .append(e.getDocumento()).append(":");
                    List<Double> notas = e.getNotas();
                    for (int i = 0; i < notas.size(); i++) {
                        sb.append(notas.get(i));
                        if (i < notas.size() - 1) sb.append("|");
                    }
                }
                writer.write(sb.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDocentes(List<Docente> docentes) {
        try (BufferedReader reader = new BufferedReader(new FileReader("docentes.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                String[] ddatos = partes[0].split(",");
                Docente d = new Docente(ddatos[0], ddatos[1], ddatos[2], ddatos[3]);

                for (int i = 1; i < partes.length; i++) {
                    String[] edatos = partes[i].split(":");
                    Estudiante e = new Estudiante(edatos[0], edatos[1], edatos[2]);
                    if (edatos.length > 3 && !edatos[3].isEmpty()) {
                        String[] snotas = edatos[3].split("\\|");
                        List<Double> notas = new ArrayList<>();
                        for (String n : snotas) {
                            notas.add(Double.parseDouble(n));
                        }
                        e.setNotas(notas);
                    }
                    d.getEstudiantes().add(e);
                }
                docentes.add(d);
            }
        } catch (IOException e) {
            System.out.println("");
        }
    }

    public static void guardarEstudiantes(List<Estudiante> estudiantes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes.txt"))) {
            for (Estudiante e : estudiantes) {
                writer.write(e.getNombre() + "," + e.getApellido() + "," + e.getDocumento());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarEstudiantes(List<Estudiante> estudiantes) {
        try (BufferedReader reader = new BufferedReader(new FileReader("estudiantes.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                Estudiante e = new Estudiante(partes[0], partes[1], partes[2]);
                estudiantes.add(e);
            }
        } catch (IOException e) {
            System.out.println("");
        }
    }


}