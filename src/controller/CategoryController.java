package controller;

import repository.CategoryRepository;

public class CategoryController {

    private final CategoryRepository repo = new CategoryRepository();

    public void showCategories() {
        repo.showCategories();
    }
}
