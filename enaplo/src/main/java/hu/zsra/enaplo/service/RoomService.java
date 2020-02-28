package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.response.RoomResponseDTO;
import hu.zsra.enaplo.model.Room;

import java.util.List;

/**
 * This interface contains all related function definitions to the room.
 */
public interface RoomService {

    /**
     * Returns a List of Room.
     *
     * @return Rooms from database.
     */
    List<Room> findAll();

    /**
     * Returns a Room object by id, if course exist
     * or returns a null value.
     *
     * @param id Id of the Room.
     * @return a Room object by id.
     * @see Room
     */
    Room findById(Long id);

    /**
     * Creates a new Room and save into the database.
     *
     * @param roomResponseDTO Submitted DTO from web application.
     * @return  a new Room object.
     * @see Room
     */
    Room create(RoomResponseDTO roomResponseDTO);

    /**
     * Deletes a Room from database by id.
     *
     * @param id Id of the Room.
     */
    void delete(Long id);
}
