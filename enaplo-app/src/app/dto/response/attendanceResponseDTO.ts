import { AttendanceDTO } from '../AttendanceDTO';

export class AttendanceResponseDTO {

    attendanceDTO: AttendanceDTO[];
    lesson: number;
    dateOfMiss: string;
}