import { Brand } from "./brand";
import { Category } from "./category";
import { Engine } from "./engine";
import { Image } from "./image";
import { Manufacture } from "./manufacture";
import { Model } from "./model";
import { SubSubCategory } from "./sub-sub-category";
import { Submodel } from "./submodel";

export class Part {
    id!: number;

    name!: string;

    description!: string;

    warranty!: string;

    material!: string;

    reference!: string;

    type!: string;

    colorFinish!: string;

    fits!: string;

    design!: string;

    notes!: string;

    position!: string;

    quantity!: number;

    buyPrice!: number;

    sellPrice!: number;

    tva!: number;

    image!: Image;

    category!: Category;

    manufacture!: Manufacture;
    isEngine!:Boolean;

    //engines!: Engine[];
    //engine!:Engine;

    submodel!: Submodel;
    //brand!:Brand;
    subsubcategory!:SubSubCategory;
    //model!:Model;

    photoPath!:string;


}
