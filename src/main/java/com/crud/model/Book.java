package com.crud.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String title;

    @Column
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String description;

    @Column
    @NotNull
    @NotEmpty
    @Size(max=100)
    private String author;

    @Column
    @NotNull
    @NotEmpty
    @Size(max=20)
    private String isbn;

    @Column
    @NotNull
    @NotEmpty
    @Size(max=11)
    @Pattern(regexp="[0-9]+")
    private String printYear;

    @Column
    private boolean readAlready;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrintYear() {
        return printYear;
    }

    public void setPrintYear(String printYear) {
        this.printYear = printYear;
    }

    public boolean isReadAlready() {
        return readAlready;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
    }

}