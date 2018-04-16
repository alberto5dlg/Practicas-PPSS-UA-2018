package ppss;

import java.util.Objects;

public class Customer {
    private int _id;
    private String _firstName;
    private String _lastName;
    private String _street;
    private String _city;
    
    public Customer(int id, String firstName, String lastName) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
    }
    
    public int getId() {
        return _id;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this._id;
        hash = 59 * hash + Objects.hashCode(this._firstName);
        hash = 59 * hash + Objects.hashCode(this._lastName);
        hash = 59 * hash + Objects.hashCode(this._street);
        hash = 59 * hash + Objects.hashCode(this._city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this._id != other._id) {
            return false;
        }
        if (!Objects.equals(this._firstName, other._firstName)) {
            return false;
        }
        if (!Objects.equals(this._lastName, other._lastName)) {
            return false;
        }
        if (!Objects.equals(this._street, other._street)) {
            return false;
        }
        if (!Objects.equals(this._city, other._city)) {
            return false;
        }
        return true;
    }

    public String getStreet() {
        return _street;
    }

    public String getCity() {
        return _city;
    }

    public void setStreet(String street) {
        _street = street;
    }

    public void setCity(String city) {
        _city = city;
    }
    
}
