package hu.zsra.enaplo.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Message to Home page.
     */
    @Column(name = "text", nullable = false, length = 255)
    private String text;

    /**
     * Text created at this time.
     */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
