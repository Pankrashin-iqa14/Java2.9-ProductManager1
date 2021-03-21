package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager manager;

    private Product prod1 = new Book(1, "Mumu", 200, "Turgenev");
    private Product prod2 = new Book(2, "Idiot", 400, "Dostoevskiy");
    private Product prod3 = new Book(3, "Revisor", 600, "Checkhov");
    private Product prod4 = new Smartphone(4, "Iphone11", 2500, "Apple");
    private Product prod5 = new Smartphone(5, "Redminote10", 1000, "Xiaomi");
    private Product prod6 = new Smartphone(6, "Iphone12", 5000, "Apple");



    @Test
    public void shouldFindNameAuthor() {
        Product[] returned = new Product[]{prod1, prod2, prod3, prod4, prod5, prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Checkhov");
        Product[] expected = new Product[]{prod3};

        assertArrayEquals(actual, expected);

    }
    @Test
    public void shouldFindNameBook() {
        Product[] returned = new Product[]{prod1, prod2, prod3, prod4, prod5, prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Idiot");
        Product[] expected = new Product[]{prod2};

        assertArrayEquals(actual, expected);

    }
    @Test
    public void shouldFindNameSmartphone() {
        Product[] returned = new Product[]{prod1, prod2, prod3, prod4, prod5, prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Redminote10");
        Product[] expected = new Product[]{prod5};

        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldFindEmpty() {
        Product[] returned = new Product[]{prod1, prod2, prod3, prod4, prod5, prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("null");
        Product[] expected = new Product[]{};

        assertArrayEquals(actual, expected);


    }
    @Test
    public void shouldFindBook1() {
        Product[] returned = new Product[]{prod1};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Mumu");
        Product[] expected = new Product[]{prod1};

        assertArrayEquals(actual, expected);


    }
    @Test
    public void shouldFindSmartphoneManufact() {
        Product[] returned = new Product[]{prod4, prod5, prod6};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{prod4, prod6};

        assertArrayEquals(actual, expected);


    }


}