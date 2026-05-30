package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import models.user.User;

public class UserDatabase {

    // ARRAYLIST PRINCIPAL
    public static ArrayList<User> users = new ArrayList<>();

    // RUTA ARCHIVO
    public static String path = "archivos/users.csv";

    // GUARDAR USUARIO
    public static void saveUser(User user) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(path, true)
                    );

            String line =
                    user.getId() + "," +
                    user.getCarnet() + "," +
                    user.getName() + "," +
                    user.getLastname() + "," +
                    user.getAge() + "," +
                    user.getPhone() + "," +
                    user.getMail() + "," +
                    user.getAddress();

            bw.write(line);

            bw.newLine();

            bw.close();

            users.add(user);

        } catch (Exception e) {

            System.out.println(
                    "ERROR AL GUARDAR USUARIO"
            );
        }
    }

    // CARGAR USUARIOS
    public static void loadUsers() {

        try {

            users.clear();

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(path)
                    );

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String id = data[0];
                String carnet = data[1];
                String name = data[2];
                String lastname = data[3];

                int age =
                        Integer.parseInt(data[4]);

                String phone = data[5];
                String mail = data[6];
                String address = data[7];

                User user = new User(
                        id,
                        carnet,
                        name,
                        lastname,
                        age,
                        phone,
                        mail,
                        address
                );

                users.add(user);
            }

            br.close();

        } catch (Exception e) {

            System.out.println(
                    "ERROR AL CARGAR USUARIOS"
            );
        }
    }

    // SOBREESCRIBIR ARCHIVO
    public static void updateFile() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(path)
                    );

            for (User user : users) {

                String line =
                        user.getId() + "," +
                        user.getCarnet() + "," +
                        user.getName() + "," +
                        user.getLastname() + "," +
                        user.getAge() + "," +
                        user.getPhone() + "," +
                        user.getMail() + "," +
                        user.getAddress();

                bw.write(line);

                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {

            System.out.println(
                    "ERROR AL ACTUALIZAR ARCHIVO"
            );
        }
        
        
    }
}
// lista global de usuarios, ARRAYLIST