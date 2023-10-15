package ma.projet.entity;

import javax.persistence.Entity;

@Entity
public class Employe extends User  {

    public Employe() {
    }

    public Employe(String email, String password) {
        super(email, password);
    }
  
    @Override
    public String toString() {
        return "ma.projet.entity.Employe[ id=" + id + " ]";
    }
    
}
