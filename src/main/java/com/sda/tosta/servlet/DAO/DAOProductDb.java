package com.sda.tosta.servlet.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DAOProductDb {
    private static DAOProductDb instance;
    private List<Product> productList;

    private DAOProductDb() {
        productList = new ArrayList<>();
        productList.add(new Product(0L, "Beal", "Lina dynamiczna 60m",
                Arrays.asList("Wspinaczka", "Asekuracja"), 499L, "https://www.e-horyzont.pl/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/9/a/9a81a6d05e5492e822bc982e32a54eecbc488c12_antidote_blue.jpg"));
        productList.add(new Product(1L, "Black Diamond", "Uprząż wspinaczkowa", Arrays.asList("Wspinaczka", "Asekuracja"), 186L, "https://www.e-horyzont.pl/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/c/6/c66b5c3cd7e9a98d89ca20b154c46a8ec143bc87_momentum_astral_blue2.jpg"));
        productList.add(new Product(2L, "Black Diamond", "Zestaw expresów", Arrays.asList("Wspinaczka", "Expresy i karabinki"), 223L, "https://www.e-horyzont.pl/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/b/6/b6c288cf8fc63c594318ea0e07e5acd34c033292_freewire_pack.jpg"));
        productList.add(new Product(3L, "Black Diamond", "Karabinek HMS", Arrays.asList("Wspinaczka", "Expresy i karabinki"), 39L, "https://www.e-horyzont.pl/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/e/d/eda31d576ac6df41af3bc13475f8a6468ad1e49d_rocklok_screwgate.jpg"));
        productList.add(new Product(4L, "Black Diamond", "Expres", Arrays.asList("Wspinaczka", "Karabinki i expresy"), 55L, "https://www.e-horyzont.pl/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/9/1/914344c4bcb8a941c9af85c3674b5ab4aee283ce_positron_qd_12.jpg"));
        productList.add(new Product(5L, "Wired Hex", "Kości Hex", Arrays.asList("Wspinaczka", "Kości, friendy"), 240L, "https://www.e-horyzont.pl/media/catalog/product/cache/e4d64343b1bc593f1c5348fe05efa4a6/e/4/e4d8c99b88dc0fc827475937118727a9e5a2e135_16615_27256.jpg"));
        productList.add(new Product(6L, "Camp", "Kości zestaw", Arrays.asList("Wspinaczka", "Kości, friendy"), 173L, "https://www.e-horyzont.pl/media/catalog/product/cache/e4d64343b1bc593f1c5348fe05efa4a6/3/f/3fc88f989756b6aa5f8887d03cd154710f3f7d3b_96605_25549.jpg"));
        productList.add(new Product(7L, "Petzl", "Kubek asekuracyjny", Arrays.asList("Wspinczka", "Asekuracja"), 85, "https://www.e-horyzont.pl/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/3/5/3584cdecd386ba664d0ff0d218450fa349e98ef6_atc_guide_anthracite.jpg"));
        productList.add(new Product(8L, "La Sportiva", "Buty wspinaczkowe", Arrays.asList("Wspinaczka", "Buty"), 519, "https://www.e-horyzont.pl/media/catalog/product/cache/e4d64343b1bc593f1c5348fe05efa4a6/2/c/2cb23e09f117630431d6bba0c2f796960277eed1_solution.jpg"));
    }

    public static DAOProductDb getInstance() {
        if (instance == null) {
            instance = new DAOProductDb();
        }
        return instance;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Optional<Product> getProductById(int id) {
        return productList.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }

    public long createNewProduct(String name, String description, List<String> categories, long price, String image) {
        int idCounter = getProductList().size();
        Product product = new Product(idCounter, name, description, categories, price, image);
        productList.add(product);
        return product.getId();
    }

    public void deleteProductById(int id) {
        productList.remove(id);
    }
}
