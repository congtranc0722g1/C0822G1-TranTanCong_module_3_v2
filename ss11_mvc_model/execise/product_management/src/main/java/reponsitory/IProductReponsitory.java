package reponsitory;

import model.Product;

import java.util.List;

public interface IProductReponsitory {
    List<Product> showAll();

    void add (Product product);

    Product searchById(int id);

    void remove(int id);
}
