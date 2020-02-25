package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.response.RemarkResponseDTO;
import hu.zsra.enaplo.model.Remark;

import java.util.List;

/**
 * This interface contains all related function definitions to the remark.
 */
public interface RemarkService {

    /**
     * Returns a List of Remark by student id.
     *
     * @return Remarks from database by student id.
     */
    List<Remark> findAllByStudent(Long student_id);

    /**
     * Returns a Remark object by id, if course exist
     * or returns a null value.
     *
     * @param id Id of the Remark.
     * @return a Remark object by id.
     * @see Remark
     */
    Remark findById(Long id);

    /**
     * Creates a new remark and save into the database.
     *
     * @param remarkResponseDTO Submitted DTO from web application.
     * @return  a new Remark object.
     * @see Remark
     */
    Remark create(RemarkResponseDTO remarkResponseDTO);

    /**
     * Updates a remark from database by id.
     *
     * @param id Id of the remark.
     * @param remarkResponseDTO Submitted DTO from web application.
     * @return an updated remark.
     * @see Remark
     */
    Remark update(Long id, RemarkResponseDTO remarkResponseDTO);

    /**
     * Deletes a remark from database by id.
     *
     * @param id Id of the remark.
     */
    void delete(Long id);
}
