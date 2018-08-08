/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author anthony.arce
 */
public class Empleado extends Persona  {
    
    private int codigoEmpleado;
    private String departamento;

    public Empleado(){}

    public Empleado(int codigoEmpleado, String departamento, String nombre, String direccion, int edad) {
        super(nombre, direccion, edad);
        this.codigoEmpleado = codigoEmpleado;
        this.departamento = departamento;
    }

  
    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return  super.toString() +","+ codigoEmpleado + ", " + departamento+","  ;
    }
    
    
    public String buscarEmpleado ( int codigoEmpleado){
      String m="";
     LinkedList<Empleado> listaEmpleado = recuperarDeArchivo();
      
     
        for (int i = 0; i < listaEmpleado.size(); i++) {
            if(codigoEmpleado == listaEmpleado.get(i).codigoEmpleado){
            m = listaEmpleado.get(i).toString();
            }
            
            
        }
    
        
        return m;
    }
    
    
    
    

    public boolean guardarEmpleados(LinkedList<Empleado> listaEmpleados) {
        boolean g = false;
        try { 
            // Actualizar el nombre del archivo
            String nombreArchivo = "datos.txt";               

           // crea un objeto para la escritura en un archivo de texto
            PrintWriter  salida  =  new  PrintWriter( 
                    new BufferedWriter( new FileWriter( nombreArchivo ) ) ) ;

            // Se puede eliminar            
            System.out.println("Se ingresarán los datos al archivo" );
            String linea;
            // Recorrido por el LinkedList
            // Actualizar según los datos a almacenar
            
            for (Empleado dato : listaEmpleados)
            {
                // crea linea con el formato definido por el programador
                
                
                linea= 
                        dato.getCodigoEmpleado()+"--"+
                        dato.getDepartamento()+"--"+
                        dato.getNombre()+"--"+
                       dato.getDireccion()+"--"+
                        dato.getEdad();
                         
                        
                        
              
                
                // envia la cadena al archivo de texto
                salida.println(linea);
            }
            
            salida.close();
            System.out.println("\n\n Archivo cerrado" );    
            g=true;
       } catch(IOException  e ) { 
           // Se ´puede personalizar el mensaje de error
           e.printStackTrace() ; 
           
       }
        
        
        return g;
        
    }
    
    
    
     public static LinkedList<Empleado> recuperarDeArchivo() 
            
    {
       LinkedList<Empleado> losEmpleado=  new LinkedList<>();
        try { 

            String Archivo = "datos.txt";                
 
            BufferedReader  input  =  new  BufferedReader( 
                new  FileReader(Archivo) ) ;
            String[] datos;
            String linea;
            int laEdad;
            String nombre;
            String direccion;
            String Departamento;
            int codigo;
            
            while( ( linea = input.readLine() ) != null )
            {
                // Separa cada dato de la cadena leida, usando el formato utilizado al guardar
                datos = linea.split("--");
                nombre = datos[2];
                direccion = datos[3];
                Departamento = datos[1];
                codigo =  Integer.parseInt(datos[0]);
                laEdad = Integer.parseInt(datos[4]);
                losEmpleado.add(new Empleado(codigo, Departamento, nombre, direccion, laEdad));
                System.out.println("se leyó"+nombre);
            }
            input.close();
            
                                                      
       } catch( java.io.IOException  e ) { 
           // Se ´puede personalizar el mensaje de error           
           e.printStackTrace() ; 
       }
        return losEmpleado;
    }

    public boolean crearFileXML(LinkedList<Empleado> listaEmpleados) {
        
        try{
                
                Element company = new Element ("Company");
                Document doc = new Document (company);
                for (int i = 0; i < listaEmpleados.size(); i++) {
                 Element empleado = new Element ("Empleado");
                 empleado.addContent(new Element("Nombre").setText(listaEmpleados.get(i).getNombre()));
                 empleado.addContent(new Element("Direccion").setText(listaEmpleados.get(i).getDireccion()));
                 
            }
               
                
//                empleado.setAttribute(new Attribute ("id","l"));
                
        
        }
        

        
    return false;        
        
    }

    
    
    
    
    
    
    

    
    
    
    
    
    
            
    
    
}
