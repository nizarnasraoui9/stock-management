import { Inventory } from "./inventory";
import { Part } from "./part";

export class LineInventory {
    id!: number;
    quantity!: number;
    part!: Part;
    inventory!: Inventory;
}
