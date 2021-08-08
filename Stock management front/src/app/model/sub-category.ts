import { Category } from "./category";
import { SubSubCategory } from "./sub-sub-category";

export class SubCategory {
    id!: number;
    title!: string;
    category!: Category;
}
