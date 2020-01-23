import { Student } from './student';

export class Attendance {

    id: number;
    lecture: number;
    dateOfMiss: string;
    student: Student;
    isVerified: boolean;
}