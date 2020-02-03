import { ArchiveReport } from './archiveReport';

export class Archive {

    id: number;
    username: string;
    fullName: string;
    dateOfBirth: string;
    reports: ArchiveReport[];
}