export  enum Gender {
    MR = 0,
    MRS = 1,
    MISS = 2
}

export class Person {
    id: number;
    gender: Gender;
    firstname: String;
    lastname: String;
    birthday: Date;
}
