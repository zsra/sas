package hu.zsra.enaplo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Message model class stores info.
 */
@Entity
@Table(name = "messages")
public class Message {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Message to Home page.
     */
    @Getter
    @Setter
    @Column(name = "text", nullable = false, length = 255)
    private String text;

    /**
     * Text created at this time.
     */
    @Getter
    @Setter
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    /**
     * Empty constructor.
     */
    public Message() {
    }

    /**
     * Constructor to make a new instance.
     *
     * @param text Text.
     */
    public Message(String text) {
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }
}
