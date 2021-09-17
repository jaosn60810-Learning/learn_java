package tool;

import java.util.ArrayList;

public class Bag {
    private ArrayList<Item> items = new ArrayList<>();


    public void addItem(String itemName, int itemNum) {
        itemName = itemName.toLowerCase();
        if (items.size() == 0) {
            switch (itemName) {
                case "cannedfood":
                    items.add(new CannedFood());
                    break;
                case "carton":
                    items.add(new Carton());
                    break;
                case "cathair":
                    items.add(new CatHair());
                    break;
                case "doghair":
                    items.add(new DogHair());
                    break;
                case "fishfood":
                    items.add(new FishFood());
                    break;
                case "fishscale":
                    items.add(new FishScale());
                    break;
                case "insectfood":
                    items.add(new InsectFood());
                    break;
                case "sawdust":
                    items.add(new Sawdust());
                    break;
                case "seaweed":
                    items.add(new Seaweed());
                    break;
                case "woodhouse":
                    items.add(new WoodHouse());
                    break;
            }
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().toLowerCase().equals(itemName)) {
                if (items.get(i).getCount() + itemNum <= items.get(i).getItemsLimit()) {
                    items.get(i).setCount(items.get(i).getCount() + itemNum);
                    return;
                } else {
                    int itemsLeft = items.get(i).getItemsLimit() - items.get(i).getCount();
                    itemNum -= itemsLeft;
                    items.get(i).setCount(items.get(i).getItemsLimit());
                    switch (itemName) {
                        case "cannedfood":
                            items.add(new CannedFood());
                            break;
                        case "carton":
                            items.add(new Carton());
                            break;
                        case "cathair":
                            items.add(new CatHair());
                            break;
                        case "doghair":
                            items.add(new DogHair());
                            break;
                        case "fishfood":
                            items.add(new FishFood());
                            break;
                        case "fishscale":
                            items.add(new FishScale());
                            break;
                        case "insectfood":
                            items.add(new InsectFood());
                            break;
                        case "sawdust":
                            items.add(new Sawdust());
                            break;
                        case "seaweed":
                            items.add(new Seaweed());
                            break;
                        case "woodhouse":
                            items.add(new WoodHouse());
                            break;
                    }
                }
            }
        }

        switch (itemName) {
            case "cannedfood":
                items.add(new CannedFood());
                break;
            case "carton":
                items.add(new Carton());
                break;
            case "cathair":
                items.add(new CatHair());
                items.get(items.size()-1).setCount(itemNum);
                break;
            case "doghair":
                items.add(new DogHair());
                break;
            case "fishfood":
                items.add(new FishFood());
                break;
            case "fishscale":
                items.add(new FishScale());
                break;
            case "insectfood":
                items.add(new InsectFood());
                break;
            case "sawdust":
                items.add(new Sawdust());
                break;
            case "seaweed":
                items.add(new Seaweed());
                break;
            case "woodhouse":
                items.add(new WoodHouse());
                break;


        }
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
