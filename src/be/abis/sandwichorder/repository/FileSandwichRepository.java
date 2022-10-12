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


    public FileSandwichRepository() throws IOException {

        List<String> stringLines = Files.readAllLines(Path.of(fileLocation));
        for (String s : stringLines) {
            String[] splittedLineArray = s.split(";");

            Sandwich sandwich = new Sandwich();
            for (int i = 0; i < splittedLineArray.length; i++) {
                switch (i) {
                    case 0:
                        sandwich.setID(splittedLineArray[i]);
                    case 1:
                        sandwich.setOrderInMenu(splittedLineArray[i]);
                    case 2:
                        sandwich.setSandwichCompany(fileCompanyRepository.findCompany(splittedLineArray[i]));
                    case 3:
                        sandwich.setName(splittedLineArray[i]);
                    case 4:
                        sandwich.setCategory(splittedLineArray[i]);
                    case 5:
                        sandwich.setPrice(splittedLineArray[i]);
                    case 6:
                        sandwich.setIngredientList(splittedLineArray[i]);
                }
                System.out.println((splittedLineArray[i]));

            }
            sandwichList.add(sandwich);
        }
    }

    public static FileSandwichRepository getInstance() throws IOException {
        if (instance == null) { instance = new FileSandwichRepository();}
        return instance;
    }

    public List<Sandwich> findSandwichesByRestaurant(String name) {
        List<Sandwich> sandwichListOfCompany = new ArrayList<>();
        for (Sandwich s : sandwichList) {
            if (s.getSandwichCompany().getName() != null && s.getSandwichCompany().getName().equals(name)) {
                sandwichListOfCompany.add(s);
            }
        }

        return sandwichListOfCompany;
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
            String[] sandwichToArray = new String[7];
            sandwichToArray[0] = sandwich.getID();
            sandwichToArray[1] = sandwich.getOrderInMenu();
            sandwichToArray[2] = sandwich.getSandwichCompany().getName();
            sandwichToArray[3] = sandwich.getName();
            sandwichToArray[4] = sandwich.getCategory();
            sandwichToArray[5] = sandwich.getPrice();
            sandwichToArray[6] = sandwich.getIngredientList();
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

    public void removeSandwichFromRepo(String sandwichName, String sandwichCompany) {

        Sandwich sandwichToRemove = sandwichList.stream()
                        .filter(sandwich -> sandwich.getName().equals(sandwichName))
                        .filter(sandwich -> sandwich.getSandwichCompany().getName().equals(sandwichCompany))
                        .findFirst().orElse(null);

        sandwichList.remove(sandwichToRemove);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation));
            for (Sandwich sw : sandwichList) {
                String[] sandwichToArray = new String[7];
                sandwichToArray[0] = sw.getID();
                sandwichToArray[1] = sw.getOrderInMenu();
                sandwichToArray[2] = sw.getSandwichCompany().getName();
                sandwichToArray[3] = sw.getName();
                sandwichToArray[4] = sw.getCategory();
                sandwichToArray[5] = sw.getPrice();
                sandwichToArray[6] = sw.getIngredientList();
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
