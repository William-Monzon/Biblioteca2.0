package services.user;

import models.user.User;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class ArrayListUser {

    
    
    // ARRAYLIST
    private ArrayList<User> listUser;

    
    
    
    // CONSTRUCTOR
    public ArrayListUser() {

        listUser = new ArrayList<>();

        uploadFile();
    }

    
    
    
    // LEE EL ARCHIVO TXT
    public void uploadFile() {

        try {

            BufferedReader br =
                new BufferedReader(
                    new FileReader("archivos/usuarios.txt")
                );

            String linea;

            
            
            while ((linea = br.readLine()) != null) {

                
                
                // ; PARA SEPARA LOS DATOS DEL USER
                String[] datos =
                    linea.split(";");

                
                
                // CONVERTIR DATOS, POSICIONES DE CADA DATO
                int id =
                    Integer.parseInt(datos[0]);

                int age =
                    Integer.parseInt(datos[1]);

                String phone =
                    datos[2];

                String name =
                    datos[3];

                String lastname =
                    datos[4];

                String carnet =
                    datos[5];

                String mail =
                    datos[6];

                String address =
                    datos[7];

                
                
                // CREAR OBJETO
                User user = new User(id,age, phone, name, lastname, carnet, mail, address);
                      
                    

                
                // AGREGAR AL ARRAYLIST
                listUser.add(user);
            }

            br.close();

            System.out.println(
                "¡¡ USUARIO GUARDADO !!"
            );

        } catch (Exception e) {

            System.out.println(
                "ERROR AL CARGAR EL ARCHIVO"
            );

            e.printStackTrace();
        }
    }

    
    
    
    // CREA LA LISTA DE LOS USUARIOS
    public ArrayList<User> listUsers() {

        return listUser;
    }
}