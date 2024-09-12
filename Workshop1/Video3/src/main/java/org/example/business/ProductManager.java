package org.example.business;

import org.example.core.logging.Logger;
import org.example.dataAccess.ProductDao;
import org.example.entities.Product;

import java.util.List;

public class ProductManager {
    private ProductDao productDao;
//    private List<Logger> loggers;
    private Logger[] loggers;
    public ProductManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) {
        //iş kuralları
        if (product.getUnitPrice() < 10) {
            try {
                throw new Exception("Ürün fiyatı 10'dan küçük olamaz.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        //ProductDao productDao = new HibernateProductDao();
        productDao.add(product);

        for (Logger logger: loggers)
        {
            logger.log(product.getName());
        }
    }
}
