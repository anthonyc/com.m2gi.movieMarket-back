export  enum Gender {
    Mr = 0,
    Mrs = 1,
    Miss = 2
};

export class Person {
    id: number;
    gender: Gender;
    firstname: String;
    lastname: String;
    birthday: Date;
}
