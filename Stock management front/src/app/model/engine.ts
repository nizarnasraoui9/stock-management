import { Brand } from "./brand";
import { BrandEngine } from "./brand-engine";
import { Model } from "./model";
import { Part } from "./part";
import { Submodel } from "./submodel";

export class Engine {
    id!: number;
    name!: string;
    brand!:Brand;
    model!:Model;
    submodel!:Submodel;
    year!:String;
    //parts!: Part[];
    //engineBrands!: BrandEngine[];
}
