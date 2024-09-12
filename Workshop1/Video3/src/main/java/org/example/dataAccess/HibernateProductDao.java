package org.example.dataAccess;

import org.example.entities.Product;

public class HibernateProductDao implements ProductDao{
    public void add(Product product){
        //Sadece db erişim kodları yazılır.
        System.out.println("Hibernate ile veritabanına eklendi");
    }
}
