import {ICustomerType} from './customer-type';

export class ICustomer {
  id?: number;
  name: string;
  dateOfBirth: string;
  gender: string;
  address: string;
  idCard: string;
  phoneNumber: string;
  email: string;
  customerType: ICustomerType;

  constructor() {
  }
}
