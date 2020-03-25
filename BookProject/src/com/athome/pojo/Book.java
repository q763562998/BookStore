package com.athome.pojo;

public class Book {

    private  int id;
    private String name;
    private double price;
    private String author;
    private int sales;
    private int stock;
    private String img_path="static/img/default.jpg";

    public Book(String test02, double v, String me, int sales, int stock, Object img_path) {
    }

    public Book() {
    }

    public Book(String name, double price, String author, int sales, int stock, String img_path) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;

        if (img_path==""||img_path==null) {
            this.img_path = img_path;
        }
    }

    public Book(int id, String name, double price, String author, int sales, int stock, String img_path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        if (img_path==""||img_path==null) {
            this.img_path = img_path;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {

        if (img_path!=""&&img_path!=null) {
            this.img_path = img_path;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
