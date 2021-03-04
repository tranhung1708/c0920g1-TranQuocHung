import {CustomerType} from './customer-type';

export class Customer {
  id: number;
  name: string;
  dayOfBirth: string;
  address: string;
  customerType: CustomerType;

  constructor() {
  }
}
