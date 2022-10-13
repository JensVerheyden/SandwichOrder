package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.Sandwich;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSandwichRepository {

    private static FileSandwichRepository instance;

    private List<Sandwich> sandwichList = new ArrayList<>();
    FileCompanyRepository fileCompanyRepository = FileCompanyRepository.getInstance();
    private static final String fileLocation = "src/be/abis/sandwichorder/resources/sandwiches.csv";


    public FileSandwichRepository() {

        List<String> stringLines = null;
        try {
            stringLines = Files.readAllLines(Path.of(fileLocation));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String s : stringLines) {
            String[] vals = s.split(";");
            if (!vals[0].equals("")){
                Sandwich sa = new Sandwich();
                sa.setID(!vals[0].equals("null") ? vals[0]:null);
                sa.setSandwichCompany(!vals[1].equals("null") ? (FileCompanyRepository.getInstance().findCompany(vals[1])):null);
                sa.setName(!vals[2].equals("null") ? vals[2]:null);
                sa.setCategory(!vals[3].equals("null") ? vals[3]:null);
                sa.setPrice(!vals[4].equals("null") ? vals[4]:null);
                sa.setIngredientList(vals[5]);

                sandwichList.add(sa);
            }



        }
    }

    public static FileSandwichRepository getInstance(){
        if (instance == null) { instance = new FileSandwichRepository();}
        return instance;
    }

    public List<Sandwich> findSandwichesByRestaurant(String name) {
        return getSandwichList().stream()
                .filter(s -> s.getSandwichCompany().getName().equals(name))
                .toList();
    }

    public List<Sandwich> getSandwichList() {
        return sandwichList;
    }

    public void setSandwichList(ArrayList<Sandwich> sandwichList) {
        this.sandwichList = sandwichList;
    }


    public void addSandwichToRepo(Sandwich sandwich) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation, true));
            String[] sandwichToArray = new String[6];
            sandwichToArray[0] = sandwich.getID();
            sandwichToArray[1] = sandwich.getSandwichCompany().getName();
            sandwichToArray[2] = sandwich.getName();
            sandwichToArray[3] = sandwich.getCategory();
            sandwichToArray[4] = sandwich.getPrice();
            sandwichToArray[5] = sandwich.getIngredientList();
            bufferedWriter.newLine();
            for (String s : sandwichToArray) {
                bufferedWriter.write(s);
                bufferedWriter.write(";");
            }
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sandwichList.add(sandwich);
    }

    public void removeSandwichFromRepo(Sandwich sandwich) {

        sandwichList.remove(sandwich);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation));
            for (Sandwich sw : sandwichList) {
                String[] sandwichToArray = new String[6];
                sandwichToArray[0] = sw.getID();
                sandwichToArray[1] = sw.getSandwichCompany().getName();
                sandwichToArray[2] = sw.getName();
                sandwichToArray[3] = sw.getCategory();
                sandwichToArray[4] = sw.getPrice();
                sandwichToArray[5] = sw.getIngredientList();
                for (String s : sandwichToArray) {
                    bufferedWriter.write(s);
                    bufferedWriter.write(";");
                }
                bufferedWriter.newLine();

            } bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
