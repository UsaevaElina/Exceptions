import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepoTest {
    @Test
    public void testShopRepoException() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(17, "apple", 200);
        Product product2 = new Product(25, "orange", 202);
        Product product3 = new Product(55, "banana", 67);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(0);
        });
    }

    @Test
    public void testForGetter() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(17, "apple", 200);
        Product product2 = new Product(25, "orange", 202);
        Product product3 = new Product(55, "banana", 67);

        int[] expected = {17,25,55};
        int[] actual ={product1.getId(), product2.getId(), product3.getId()};
    }
    @Test
    public void testForFindByAll(){
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(17, "apple", 200);
        Product product2 = new Product(25, "orange", 202);
        Product product3 = new Product(55, "banana", 67);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product expected = product1;
        Assertions.assertEquals(expected, repo.findById(17));
    }
    @Test
    public  void testForFindAll(){
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(17, "apple", 200);
        Product product2 = new Product(25, "orange", 202);
        Product product3 = new Product(55, "banana", 67);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(17);
        Product[] actual3 = repo.findAll();
        Product[] expected3 = {product2, product3};
        Assertions.assertArrayEquals(actual3, expected3);
    }
}