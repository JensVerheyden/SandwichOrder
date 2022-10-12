package be.abis.sandwichorder.model;

public class MenuPreview {

    Menu dayMenu;

    public MenuPreview(Menu dayMenu) {
        this.dayMenu = dayMenu;
    }

    public void printMenu() {

        System.out.println(dayMenu.getSandwichCompany());
        System.out.println("-------------------------------");
        for (Sandwich s : dayMenu.getSandwichList()) {
            System.out.printf("%-20s %-20s %-20s %-20s \n",
                    s.getOrderInMenu(),s.getName(), s.getIngredientList(), s.getPrice());
        }

    }

    public Menu getDayMenu() {
        return dayMenu;
    }

    public void setDayMenu(Menu dayMenu) {
        this.dayMenu = dayMenu;
    }
}
