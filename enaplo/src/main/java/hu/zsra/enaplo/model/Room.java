package hu.zsra.enaplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Long id;

    /**
     * Classroom where course hold.
     */
    @Column(name = "classroomNumber", nullable = false, length = 15)
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
    private List<TimeTableEntity> timeTableEntities = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public List<TimeTableEntity> getTimeTableEntities() {
        return timeTableEntities;
    }

    public void setTimeTableEntities(List<TimeTableEntity> timeTableEntities) {
        this.timeTableEntities = timeTableEntities;
    }
}
