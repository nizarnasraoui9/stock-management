import { Model } from "./model";
import { Part } from "./part";

export class Submodel {
    id!: number;
    name!: string;
    //parts!: Part[];
    model!:Model;
}
