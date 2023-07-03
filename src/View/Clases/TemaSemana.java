/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Clases;
import java.util.ArrayList;
import java.util.List;

class RegistroAsistencia {
   
    private String nombre;
    private String fecha;

    public RegistroAsistencia(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }
}

public class TemaSemana {
    public static void bubbleSort(List<RegistroAsistencia> registros) {
        int n = registros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (registros.get(j).getFecha().compareTo(registros.get(j + 1).getFecha()) > 0) {
                    // Intercambiar los registros en la lista
                    RegistroAsistencia temp = registros.get(j);
                    registros.set(j, registros.get(j + 1));
                    registros.set(j + 1, temp);
                }
            }
        }
    }
    
    public static RegistroAsistencia buscarRegistroPorNombre(List<RegistroAsistencia> registros, String nombreBuscado) {
        for (RegistroAsistencia registro : registros) {
            if (registro.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return registro;
            }
        }
        return null; // Si no se encuentra el registro
    }

    public static void main(String[] args) {
        List<RegistroAsistencia> registros = new ArrayList<>();
        registros.add(new RegistroAsistencia("Juan", "2023-05-22"));
        registros.add(new RegistroAsistencia("Maria", "2023-05-18"));
        registros.add(new RegistroAsistencia("Pedro", "2023-05-23"));
        registros.add(new RegistroAsistencia("Miguel", "2023-05-13"));
        registros.add(new RegistroAsistencia("Lucas", "2023-05-19"));
        registros.add(new RegistroAsistencia("Pablo", "2023-05-26"));

        // Llamar al método bubbleSort para ordenar los registros por fecha
        bubbleSort(registros);
        
        //nombre a buscar
        String nombreBuscado = "Jerry";
        
        // Llamar al método buscarRegistroPorNombre para encontrar el registro de asistencia por nombre
        RegistroAsistencia registroEncontrado = buscarRegistroPorNombre(registros, nombreBuscado);


        // Imprimir los registros ordenados
        System.out.println("Registros de asistencia ordenados por fecha de ingreso:");
        for (RegistroAsistencia registro : registros) {
            System.out.println(registro.getNombre() + " - " + registro.getFecha());
        }
        
        System.out.println("");
        // Imprimir el registro encontrado
        if (registroEncontrado != null) {
            System.out.println("Registro de asistencia encontrado:");
            System.out.println("Nombre: " + registroEncontrado.getNombre());
            System.out.println("Fecha: " + registroEncontrado.getFecha());
        } else {
            System.out.println("Registro de asistencia no encontrado para el nombre: " + nombreBuscado);
        }
    }
}
    

