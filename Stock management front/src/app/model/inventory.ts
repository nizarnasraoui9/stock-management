import { LineInventory } from "./line-inventory";

export class Inventory {
    id!: number;
    date!: Date;
    lineInventories!: LineInventory[];
}
