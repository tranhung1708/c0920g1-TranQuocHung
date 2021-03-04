import {TestModuleType} from './test-module-type';

export class TesstModule {
  id?: number;
  name: string;
  ngayMoSo: string;
  thoiGianGui: string;
  kiHan: string;
  soTienGui: string;
  laiSuat: string;
  uuDai: string;

  testType: TestModuleType;

  constructor() {
  }
}
