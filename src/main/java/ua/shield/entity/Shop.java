package ua.shield.entity;

import javax.persistence.*;

/**
 * Created by sa on 23.03.17.
 */
@Entity
@Table(name="shops")
public class Shop {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="employees_number")
    private Integer emplNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmplNumber() {
        return emplNumber;
    }

    public void setEmplNumber(Integer emplNumber) {
        this.emplNumber = emplNumber;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emplNumber=" + emplNumber +
                '}';
    }
}
