package xjhxjhxjhxjh.com.github.domain;
/**
 * 联系人Bean
 * @author xjhxjhxjh
 *
 */
public class Contact {
    private int id;
    private String name;
    private String sex;
    private String telephoneNumber;
    private String address;
    private String qqNumber;
    private String ugroup;
    
    public Contact() {}
    public Contact(int id, String name, String sex, String telephoneNumber, String address, String qqNumber,
            String ugroup) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.qqNumber = qqNumber;
        this.ugroup = ugroup;
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getqqNumber() {
        return qqNumber;
    }
    public void setqqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }
    public String getUgroup() {
        return ugroup;
    }
    public void setUgroup(String ugroup) {
        this.ugroup = ugroup;
    }
    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", sex=" + sex + ", telephoneNumber=" + telephoneNumber
                + ", address=" + address + ", qqNumber=" + qqNumber + ", ugroup=" + ugroup + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((qqNumber == null) ? 0 : qqNumber.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        result = prime * result + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
        result = prime * result + ((ugroup == null) ? 0 : ugroup.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (qqNumber == null) {
            if (other.qqNumber != null)
                return false;
        } else if (!qqNumber.equals(other.qqNumber))
            return false;
        if (sex == null) {
            if (other.sex != null)
                return false;
        } else if (!sex.equals(other.sex))
            return false;
        if (telephoneNumber == null) {
            if (other.telephoneNumber != null)
                return false;
        } else if (!telephoneNumber.equals(other.telephoneNumber))
            return false;
        if (ugroup == null) {
            if (other.ugroup != null)
                return false;
        } else if (!ugroup.equals(other.ugroup))
            return false;
        return true;
    }
    
}
