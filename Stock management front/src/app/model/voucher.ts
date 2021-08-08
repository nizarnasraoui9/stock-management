import { LineVoucher } from "./line-movement";

export class Voucher {
    id!: number;
    type!: string;
    reason!: string;
    date!: Date;
    lineVouchers!: LineVoucher[];
}
