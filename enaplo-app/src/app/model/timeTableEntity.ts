import { Course } from './course';
import { Classroom } from './classroom';

export class TimeTableEntity {

    id: number;
    day: number;
    lessonNumber: number;
    course: Course;
    classroomNumber: string;
    classroom: Classroom;
}