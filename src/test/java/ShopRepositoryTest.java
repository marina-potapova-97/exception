import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    void removeWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 10000);
        Product product2 = new Product(2, "Наушники", 5000);
        Product product3 = new Product(3, "Камера", 8000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(2);

        Product[] actual = repo.findAll();
        Product[] extended = {product1, product3};

        Assertions.assertArrayEquals(extended, actual);

    }

    @Test
    void removeWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 10000);
        Product product2 = new Product(2, "Наушники", 5000);
        Product product3 = new Product(3, "Камера", 8000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(23523));
    }
}
