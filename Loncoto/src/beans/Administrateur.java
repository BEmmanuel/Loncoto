package beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="3")
public class Administrateur extends Utilisateur {

}
