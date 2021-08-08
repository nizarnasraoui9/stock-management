import { Brand } from "./brand";
import { Engine } from "./engine";
import { Submodel } from "./submodel";

export class Model {
    id!: number;
    name!: string;
    brand!:Brand;
    //submodels!: Submodel[];
    //engines!: Engine[];
}
