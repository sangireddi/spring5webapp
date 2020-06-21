package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Publisher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;

    @OneToOne(mappedBy = "publisher" , cascade = CascadeType.ALL)
    private Address address;

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(Id, publisher.Id) &&
                Objects.equals(name, publisher.name) &&
                Objects.equals(address, publisher.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, address);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", Address is : Address Line 1 : " + address.getAddressLine1() + " , City : "+address.getCity()+
                " , State :"+address.getState()+" , ZIP : "+address.getZip()+
                '}';
    }
}
