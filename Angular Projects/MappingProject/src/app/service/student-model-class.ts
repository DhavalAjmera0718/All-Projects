export class StudentModelClass {

    constructor() {
        this.sid = 0;
        this.sname = '';
        this.department = '';
        this.course = {
            cid: 0,
            name: '',
            fee: ''
        };
    }

    sid: number;
    sname: string;
    department: string;
    course?: {
        cid: number;
        name: string;
        fee: string;
    };
}
