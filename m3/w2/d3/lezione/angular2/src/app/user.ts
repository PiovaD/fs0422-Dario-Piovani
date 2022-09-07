export class User {

  id?: number | undefined;
  name: string
  lastName: string
  active: boolean

  constructor(name: string, lastName: string, active: boolean = true) {
    this.name = name;
    this.lastName = lastName;
    this.active = active;
  }

}
