package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.response.RoomResponseDTO;
import hu.zsra.enaplo.model.Room;
import hu.zsra.enaplo.repository.RoomRepository;
import hu.zsra.enaplo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This interface contains all related function definitions to the room.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    /**
     * Returns a List of Room.
     *
     * @return Rooms from database.
     */
    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    /**
     * Returns a Room object by id, if course exist
     * or returns a null value.
     *
     * @param id Id of the Room.
     * @return a Room object by id.
     * @see Room
     */
    @Override
    public Room findById(Long id) {
        return roomRepository.getOne(id);
    }

    /**
     * Creates a new Room and save into the database.
     *
     * @param roomResponseDTO Submitted DTO from web application.
     * @return a new Room object.
     * @see Room
     */
    @Override
    public Room create(RoomResponseDTO roomResponseDTO) {
        return roomRepository.save(new Room(
                roomResponseDTO.getClassroomNumber()
        ));
    }

    /**
     * Deletes a Room from database by id.
     *
     * @param id Id of the Room.
     */
    @Override
    public void delete(Long id) {
        Room room = roomRepository.getOne(id);
        roomRepository.delete(room);
    }
}
