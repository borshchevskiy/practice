package my.home.hibernate_test_relation.many_to_many.entity;

import com.sun.xml.bind.v2.model.core.ID;

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
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "section_name")
    private String sectionName;

    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private List<Child> children;

    public Section() {
    }

    public Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public void addChildToSection(Child child){
        if (children == null){
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
