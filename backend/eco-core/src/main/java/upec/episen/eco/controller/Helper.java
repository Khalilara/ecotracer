package upec.episen.eco.controller;

public class Helper {

    public static String usageCategoryRectifier(String category) {
        if (category.contains(" ")) return category.replace(" ", "_");
        return category;
    }
}
