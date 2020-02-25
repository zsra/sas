package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class MessageResponseDTO {

    @Getter
    @Setter
    private String text;

    public MessageResponseDTO() {

    }

    public MessageResponseDTO(String text) {
        this.text = text;

    }
}
