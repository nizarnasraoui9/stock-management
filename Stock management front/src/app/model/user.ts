import { Company } from "./company";
import { Language } from "./language";

export class User {
    id!: number;
    name!: string;
    familyName!: string;
    phone!: string;
    login!: string;
    password!: string;
    languages!: Language[];
    company!: string;
}
