package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String message = "Vade oranı";

        Product product1 = new Product();
        product1.setName("X Kahve Makinesi");
        product1.setUnitPrice(7500);
        product1.setDiscount(7);
        product1.setUnitsInStock(3);
        product1.setImageUrl("imageUrl.jpg");

        Product product2 = new Product();
        product2.setName("Y Kahve Makinesi");
        product2.setUnitPrice(5500);
        product2.setDiscount(6);
        product2.setUnitsInStock(2);
        product2.setImageUrl("imageUrl2.jpg");

        Product product3 = new Product();
        product3.setName("Z Kahve Makinesi");
        product3.setUnitPrice(3500);
        product3.setDiscount(3);
        product3.setUnitsInStock(5);
        product3.setImageUrl("imageUrl3.jpg");

        System.out.println(product1.getName());

        Product[] products = {product1, product2, product3};


        for (Product product : products) {
            System.out.println(product.getName());
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(0);
        individualCustomer.setPhoneNumber("0555555555");
        individualCustomer.setCustomerNumber("12345");
        individualCustomer.setFirstName("Engin");
        individualCustomer.setLastName("Demiroğ");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setCompanyName("Kodlama.io");
        corporateCustomer.setPhoneNumber("0533333333");
        corporateCustomer.setTaxNumber("11111111111");
        corporateCustomer.setCustomerNumber("234235");

        Customer[] customers = {individualCustomer, corporateCustomer};
    }
}
