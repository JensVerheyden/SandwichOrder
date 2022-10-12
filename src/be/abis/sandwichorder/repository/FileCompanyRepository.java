package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.SandwichCompany;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileCompanyRepository implements CompanyRepository {


    private static FileCompanyRepository instance;
    private List<SandwichCompany> companies = new ArrayList<>();
    private static final String fileLocation = "src/be/abis/sandwichorder/resources/companies.csv";

    public FileCompanyRepository() throws IOException {

        List<String> stringLines = Files.readAllLines(Path.of(fileLocation));
        for (String s : stringLines) {
            String[] splittedLineArray = s.split(";");

            SandwichCompany company = new SandwichCompany();

            for (int i = 0; i < splittedLineArray.length; i++) {
                switch (i) {
                    case 0:
                        company.setName(splittedLineArray[i]);
                    case 1:
                        company.setAddress(splittedLineArray[i]);
                }
            }
            companies.add(company);
        }
    }

    public static FileCompanyRepository getInstance() throws IOException {
        if (instance == null) { instance = new FileCompanyRepository();}
        return instance;
    }

    public SandwichCompany findCompany(String name) {
        SandwichCompany companyFound = null;
        for (SandwichCompany c : this.companies) {
            if (c.getName().equals(name)) {
                companyFound = c;
            }
        }
        return companyFound;
    }

    public void addSandwichCompany(SandwichCompany company) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation, true));
            String[] companyToArray = new String[2];
            companyToArray[0] = company.getName();
            companyToArray[1] = company.getAddress();
            bufferedWriter.newLine();
            for (String c : companyToArray) {
                bufferedWriter.write(c);
                bufferedWriter.write(";");
            }
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } companies.add(company);

    }

    public void removeSandwichCompany(String companyName) {
        SandwichCompany companyToRemove = findCompany(companyName);
        companies.remove(companyToRemove);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation));
            for (SandwichCompany c : companies) {
                String[] companyToArray = new String[2];
                companyToArray[0] = c.getName();
                companyToArray[1] = c.getAddress();
                for (String s : companyToArray) {
                    bufferedWriter.write(s);
                    bufferedWriter.write(";");
                }
                bufferedWriter.newLine();

            } bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<SandwichCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List<SandwichCompany> companies) {
        this.companies = companies;
    }
}
