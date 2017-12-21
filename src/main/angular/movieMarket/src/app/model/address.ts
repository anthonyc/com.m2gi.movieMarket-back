export class Address {
  id: number;
  streetNumber: string;
  street: string;
  additionalInformation: string;
  zipCode: string;
  city: string;


  public toString(): string {
    return this.streetNumber + ' ' + this.street + ' à ' + this.city + '(' + this.zipCode + ')';
  }
}
