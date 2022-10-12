package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.SandwichCompany;

public interface CompanyRepository {

    SandwichCompany findCompany(String name);
    void addSandwichCompany(SandwichCompany company);
    void removeSandwichCompany(String companyName);

}
