package services.loans;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import models.book.Material;
import models.loans.Loans;
import models.user.User;

public class ArrayListLoans {

    private final ArrayList<Loans> loans = new ArrayList<>();

    private final ArrayList<User> users = new ArrayList<>();

    private final ArrayList<Material> materials = new ArrayList<>();



    public List<Loans> getLoans() {
        return loans;
    }



    public void addLoan(Loans loan) {
        loans.add(loan);
    }



    public void addUser(User user) {
        users.add(user);
    }



    public void addMaterial(Material material) {
        materials.add(material);
    }



    public void clear() {
        loans.clear();
    }



    

    public void saveLoans(Path file) throws IOException {

        try (BufferedWriter out =
                Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {

            for (Loans l : loans) {

                out.write(l.getId() + ";");

                out.write(l.getUser().getId() + ";");

                out.write(l.getMaterial().getCode() + ";");

                out.write(l.getDateLoans() + ";");

                out.write(l.getDeadline() + ";");

                if (l.getDateDelivery() != null) {
                    out.write(l.getDateDelivery().toString());
                }

                out.newLine();
            }
        }
    }



   
    public void archiveLoans(Path file) throws IOException {

        loans.clear();

        if (!Files.isRegularFile(file)) {
            return;
        }

        try (BufferedReader in =
                Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            String line;

            while ((line = in.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                StringTokenizer t = new StringTokenizer(line, ";");

                int id = Integer.parseInt(t.nextToken().trim());

                String userCode = t.nextToken().trim();

                String materialCode = t.nextToken().trim();

                LocalDate dateLoans =
                        LocalDate.parse(t.nextToken().trim());

                LocalDate deadline =
                        LocalDate.parse(t.nextToken().trim());

                String delivery = "";

                if (t.hasMoreTokens()) {
                    delivery = t.nextToken().trim();
                }

                LocalDate dateDelivery;

                if (delivery.isEmpty()) {
                    dateDelivery = null;
                } else {
                    dateDelivery = LocalDate.parse(delivery);
                }

                User user = findUser(userCode);

                Material material = findMaterial(materialCode);

                Loans loan = new Loans(
                        id,
                        material,
                        user,
                        dateLoans,
                        deadline,
                        dateDelivery
                );

                loans.add(loan);
            }
        }
    }



  
    private User findUser(String userCode) {

        for (User u : users) {

            if (String.valueOf(u.getId()).equals(userCode)) {
                return u;
            }
        }

        return null;
    }



    private Material findMaterial(String materialCode) {

        for (Material m : materials) {

            if (m.getCode().equals(materialCode)) {
                return m;
            }
        }

        return null;
    }
}
