package hu.zsra.enaplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rooms model to store the school room.
 */
@Entity
@Table(name = "rooms")
public class Room {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    /**
     * Classroom where course hold.
     */
    @Column(name = "classroomNumber", nullable = false, length = 15)
    @Getter @Setter
    private String classroomNumber;

    /**
     * Empty constructor.
     */
    public Room() {
    }

    /**
     * Constructor to make a new instance.
     *
     * @param classroomNumber The room number.
     */
    public Room(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    @Getter @Setter
    private List<TimeTableEntity> timeTableEntities = new ArrayList<>();
}
