package be.abis.sandwichorder.model;

public class MenuPreview {

    Menu dayMenu;

    public MenuPreview(Menu dayMenu) {
        this.dayMenu = dayMenu;
    }

    public void printMenu() {
        System.out.println(dayMenu.toString());
    }

    public Menu getDayMenu() {
        return dayMenu;
    }

    public void setDayMenu(Menu dayMenu) {
        this.dayMenu = dayMenu;
    }
}
