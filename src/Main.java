import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean cerrar=false;
        String opc;
        List<Docente> docentes = new ArrayList<>();
        List<Estudiante> estudiantes = new ArrayList<>();
        cargarDocentes(docentes);
        cargarEstudiantes(estudiantes);
        Scanner t = new Scanner(System.in).useLocale(Locale.US);



        do {

            System.out.println(Colores.AZUL+"""
                    ----------------------------------------------------------
                       >>BIENVENIDO VAMOS A CALCULAR TU PROMEDIO DE NOTAS<<
                    ----------------------------------------------------------
                    
                    1) Soy un estudiante y quiero calcular mi promedio
                    
                    2) Soy un docente y quiero calcular varios promedios
                    
                    3) Soy un directivo y quiero ver el rendimiento docente
                    
                    4) Cerrar programa
                    
                    ----------------------------------------------------------
                    
                    """);

            opc = t.next();

            limpiarPantalla();

            switch (opc) {

                case "1" -> {
                    String opc2;
                    boolean cerrado1=false;
                    do {
                    System.out.println("""
                            -----------------------------------
                             >> Bienvenido que deseas hacer <<
                            -----------------------------------
                            
                            1) Registrarme
                            
                            2) Iniciar sesion
                            
                            3) Salir
                            
                            ------------------------------------
                            
                            """);
                    opc2 = t.next();

                        switch (opc2) {
                            case "1" -> {
                                String nombre;
                                String apellido;
                                String documento;
                                boolean encontrado;

                                System.out.println("Ingrese su nombre: ");
                                nombre = t.next();
                                System.out.println("Ingrese su apellido: ");
                                apellido = t.next();
                                System.out.println("Ingrese su documento: ");
                                documento = t.next();

                                estudiantes.add(new Estudiante(nombre,apellido,documento));

                            }
                            case "2" -> {
                                String opc3;
                                boolean cerrado2 = false;
                                boolean encontrado2 = false;
                                String nombre;
                                String apellido;
                                String documento;
                                System.out.println("Identificate");
                                System.out.println("Ingrese su nombre: ");
                                nombre = t.next();
                                System.out.println("Ingrese su apellido: ");
                                apellido = t.next();
                                System.out.println("Ingrese su documento: ");
                                documento = t.next();
                                for (Estudiante e: estudiantes) {
                                    if (e.getNombre().equals(nombre) && e.getApellido().equals(apellido) && e.getDocumento().equals(documento)){
                                        do {
                                            encontrado2 = true;
                                            System.out.println("""
                                            ----------------------------------
                                             >> Que deseas hacer <<
                                            ----------------------------------
                                            
                                            1) Ver clases disponibles
                                            
                                            2) Inscribir clase
                                            
                                            3) Cancelar clase
                                            
                                            4) Ver calificacion de una clase
                                            
                                            5) Salir
                                            
                                            -----------------------------------
                                            
                                            """);
                                            opc3 = t.next();

                                            switch (opc3) {
                                                case "1" -> {
                                                    for(Docente r: docentes){
                                                        System.out.println("Materia: "+r.getMateria()+" Codigo de clase: "+r.getClase() + " Docente: "+ r.getNombre() + " "+r.getApellido());
                                                    }
                                                }
                                                case "2" -> {
                                                    int codigo;
                                                    boolean encontrado=false;
                                                    System.out.println("Ingrese codigo de clase a inscribir: ");
                                                    codigo = t.nextInt();
                                                    for(Docente r: docentes){
                                                        if (r.getClase()==codigo) {
                                                            encontrado = true;
                                                            r.añadirEstudiante(nombre,apellido,documento);
                                                            System.out.println("En la clase: " + r.getMateria()+ " codigo: "+ r.getClase());
                                                        }
                                                    }
                                                    if (encontrado==false){
                                                        System.out.println("Clase no encontrada");
                                                    }
                                                }
                                                case "3" -> {
                                                    int codigo;
                                                    boolean encontrado=false;
                                                    System.out.println("Ingrese codigo de clase a Cancelar: ");
                                                    codigo = t.nextInt();
                                                    for (Docente m : docentes){
                                                        if (m.getClase()==codigo){
                                                            m.removerEstudiante(nombre,apellido,documento);

                                                        }
                                                    }
                                                }
                                                case "4" -> {
                                                    int clase;
                                                    System.out.println("Que clase quieres consultar");
                                                    clase = t.nextInt();
                                                    for (Docente m: docentes){
                                                        if ( m.getClase() == clase){
                                                            m.visualizar(nombre , apellido , documento);
                                                        }
                                                    }
                                                }
                                                case "5" -> {
                                                    cerrado2 = true;
                                                    System.out.println("Saliendo");
                                                    limpiarPantalla();
                                                }
                                                default -> System.out.println("Ingrese una opcion correcta ");
                                            }
                                        }while (cerrado2 != true);
                                    }

                                }

                                if (!encontrado2){
                                    System.out.println("Usuario no encontrado");
                                }

                            }
                            case "3" -> {
                                cerrado1 = true;
                                System.out.println("Saliendo...");
                                limpiarPantalla();

                            }
                            default -> System.out.println("Ingrese uma opcion correcta");
                        }
                    }while (cerrado1!=true);


                }

                case "2" -> {
                    boolean cerrar2=false;
                    String opc2;
                    do {
                        System.out.println("""
                --------------------------------------------------
                  >> Que accion como docente quieres realizar <<
                --------------------------------------------------
                
                1) Registrarme en una clase
                
                2) Iniciar sesion
                
                3) Salir
                
                --------------------------------------------------
                
                """);

                        opc2 = t.next();

                        switch (opc2) {

                            case "1" -> {
                                String nombre;
                                String apellido;
                                String materia;
                                int clase;
                                System.out.println("Ingrese su nombre: ");
                                nombre = t.next();
                                System.out.println("Ingrese su apellido: ");
                                apellido = t.next();
                                System.out.println("Ingrese que Materia va a dictar: ");
                                materia = t.next();
                                System.out.println("ingrese su codigo de clase: ");
                                clase = t.nextInt();
                                docentes.add(new Docente(nombre, apellido , clase,materia));
                            }
                            case "2" -> {
                                String nombre;
                                String apellido;
                                int clase;
                                boolean encontrado=false;
                                boolean encontrado2 = false;
                                System.out.println("Identificate: ");
                                System.out.println("Ingrese su nombre: ");
                                nombre = t.next();
                                System.out.println("Ingrese su apellido: ");
                                apellido = t.next();
                                System.out.println("ingrese su codigo de clase: ");
                                clase = t.nextInt();
                                for (Docente m: docentes){
                                    if (m.getNombre().equals(nombre) && m.getApellido().equals(apellido) && m.getClase() == clase){
                                        String opc3;
                                        boolean cerrar3=false;
                                        do {
                                            System.out.println("""
                                                    ----------------------------------
                                                          >>Que deseas hacer <<
                                                    ----------------------------------
                                                    
                                                    1) Registrar notas
                                                    
                                                    2) Visualizar notas
                                                    
                                                    3) Salir
                                                    
                                                    ----------------------------------
                                                    
                                                    """);
                                            opc3 = t.next();
                                            switch (opc3) {
                                                case "1" -> {
                                                    for (Docente e : docentes) {
                                                        if (e.getNombre().equals(nombre) && e.getApellido().equals(apellido) && e.getClase() == clase) {
                                                            e.registrarNotas();
                                                        }
                                                    }
                                                }
                                                case "2" -> {
                                                    for (Docente e : docentes) {
                                                        if (e.getNombre().equals(nombre) && e.getApellido().equals(apellido) && e.getClase() == clase) {
                                                           e.visualizarP();
                                                        }
                                                    }
                                                }
                                                case "3" -> {
                                                    cerrar3 = true;
                                                    System.out.println("Saliendo...");
                                                    limpiarPantalla();
                                                }
                                                default -> System.out.println("Ingresa una opcion valida");
                                            }
                                        }while (cerrar3!=true);
                                    }
                                }

                                if (!encontrado2){
                                    System.out.println("Usuario no encontrado");
                                }


                            }


                            case "3" -> {
                                cerrar2=true;
                                System.out.println("Saliendo...");
                                limpiarPantalla();
                            }

                            default -> {
                                System.out.println("Ingresa una opcion correcta");
                            }
                        }
                    }while (cerrar2 != true);

                }

                case "3" -> {
                    boolean cerrar2=false;
                    String opc2;
                    do{
                    System.out.println("""
                            ---------------------------------------------------
                              >> Que accion deseas realizar como directivo <<
                            ---------------------------------------------------
                            
                            1) Ver lista de docentes
                            
                            2) Ver clases con mayor promedio de notas 
                            
                            3) Ver clases con menor promedio de notas  
                            
                            4) Ver promedio total de la institucion
                            
                            5) Salir 
                            
                            ----------------------------------------------------
                            """);
                    opc2 = t.next();
                    switch (opc2) {
                        case "1" -> {
                            for (Docente e: docentes){
                                System.out.println("Docente: "+e.getNombre()+" "+e.getApellido()+" Clase: "+e.getClase());
                            }
                        }

                        case "2" -> {
                            for (Docente e: docentes){
                                double n =5.0;
                                n = n - 0.1;
                                if(e.promedioDeClase()<= n && e.promedioDeClase()>3.0){
                                    System.out.println("Docente: " +e.getNombre()+" "+e.getApellido()+" El promedio de su clase es: "+e.promedioDeClase());
                                }
                            }
                        }
                        case "3" -> {
                            for (Docente e: docentes){
                                double n =0.0;
                                n = n + 0.1;
                                if(e.promedioDeClase()>= n && e.promedioDeClase()<3.0){
                                    System.out.println("Docente: " +e.getNombre()+" "+e.getApellido()+" El promedio de su clase es: "+e.promedioDeClase());
                                }
                            }
                        }
                        case "4" -> {
                            double promedio;
                            double p=0;
                            for (Docente e: docentes){
                                p = p + e.promedioDeClase();
                            }
                            promedio = p/ docentes.size();
                            System.out.println("El promedio institucional es de: "+promedio);
                        }
                        case "5" -> {
                            cerrar2=true;
                            System.out.println("Saliendo...");
                            limpiarPantalla();
                        }
                        default -> {
                            System.out.println("Ingrese una opcion correcta");
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
                    System.out.println("Ingresa una opcion correcta");
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
                Docente d = new Docente(ddatos[0], ddatos[1], Integer.parseInt(ddatos[2]), ddatos[3]);

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