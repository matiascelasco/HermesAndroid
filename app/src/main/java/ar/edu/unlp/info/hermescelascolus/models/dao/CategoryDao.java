package ar.edu.unlp.info.hermescelascolus.models.dao;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Category;

public class CategoryDao implements Dao<Category> {

    @Override
    public List<Category> all() {
        return Arrays.asList(Category.values());
    }

    @Override
    public Category getById(long id) {
        return Category.values()[(int) id];
    }

    @Override
    public void save(Category category) {
        throw new RuntimeException("Categories can't be added or updated");
    }

    @Override
    public void delete(Category category) {
        throw new RuntimeException("Categories can't be deleted");
    }
}
