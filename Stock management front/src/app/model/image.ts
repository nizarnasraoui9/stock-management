import { Byte } from "@angular/compiler/src/util";

export class Image {
    id!: number;
    fileName!: string;
    fileType!:string;
    data!:Byte;
}
