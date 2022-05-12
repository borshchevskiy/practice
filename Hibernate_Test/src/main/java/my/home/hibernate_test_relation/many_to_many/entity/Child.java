package my.home.hibernate_test_relation.many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
        CREATE TABLE children (
        id SERIAL NOT NULL PRIMARY KEY ,
        first_name VARCHAR(15),
        age INT
        );

        CREATE TABLE section (
        id SERIAL NOT NULL PRIMARY KEY ,
        section_name VARCHAR(15)
        );

        CREATE TABLE child_section (
        child_id INT NOT NULL ,
        section_id INT NOT NULL,
        PRIMARY KEY (child_id, section_id),
        FOREIGN KEY (child_id) REFERENCES children(id),
        FOREIGN KEY (section_id) REFERENCES section(id)
        )
*/

@Entity
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sections;

    public Child() {
    }

    public Child(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public void addSectionToChild(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
