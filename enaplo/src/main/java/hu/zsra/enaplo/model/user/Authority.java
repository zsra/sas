package hu.zsra.enaplo.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Authority model class to store roles in the db.
 */
@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Role name.
     */
    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private UserRoleName name;


    /**
     * Get authority.
     *
     * @return authority of user.
     */
    @Override
    public String getAuthority() {
        return name.name();
    }

    /**
     * Get Role name.
     *
     * @return Role name.
     */
    @JsonIgnore
    public UserRoleName getName() {
        return name;
    }

    /**
     * Get role id.
     *
     * @return Id of the Authority.
     */
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(UserRoleName name) {
        this.name = name;
    }
}
