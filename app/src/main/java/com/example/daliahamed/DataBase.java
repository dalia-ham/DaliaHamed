package com.example.daliahamed;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Menu> items = new ArrayList<>();

    public DataBase() {
        items.add(new Menu("Aluminum", "Al", "metal", 13));
        items.add(new Menu("Silicon", "Si", "nonMetal", 14));
        items.add(new Menu("Gold", "Au", "metal", 79));
        items.add(new Menu("Silver", "Ag", "metal", 47));
        items.add(new Menu("Lead", "Pb", "metal", 82));
        items.add(new Menu("Mercury", "Hg", "metal", 80));
        items.add(new Menu("Boron", "B", "nonMetal", 5));
        items.add(new Menu("Helium", "He", "nonMetal", 2));
        items.add(new Menu("Neon", "Ne", "nonMetal", 10));
        items.add(new Menu("Argon", "Ar", "nonMetal", 18));
        items.add(new Menu("Krypton", "Kr", "nonMetal", 36));
        items.add(new Menu("Xenon", "Xe", "nonMetal", 54));
        items.add(new Menu("Radon", "Rn", "nonMetal", 86));
        items.add(new Menu("Lithium", "Li", "metal", 3));
        items.add(new Menu("Rubidium", "Rb", "metal", 37));
        items.add(new Menu("Cesium", "Cs", "metal", 55));
        items.add(new Menu("Francium", "Fr", "metal", 87));
        items.add(new Menu("Beryllium", "Be", "metal", 4));
        items.add(new Menu("Scandium", "Sc", "metal", 21));
        items.add(new Menu("Titanium", "Ti", "metal", 22));
        items.add(new Menu("Vanadium", "V", "metal", 23));
        items.add(new Menu("Chromium", "Cr", "metal", 24));
        items.add(new Menu("Manganese", "Mn", "metal", 25));
        items.add(new Menu("Cobalt", "Co", "metal", 27));

        items.add(new Menu("Nickel", "Ni", "metal", 28));
        items.add(new Menu("Arsenic", "As", "nonMetal", 33));
        items.add(new Menu("Selenium", "Se", "nonMetal", 34));
        items.add(new Menu("Bromine", "Br", "nonMetal", 35));
        items.add(new Menu("Iodine", "I", "nonMetal", 53));
        items.add(new Menu("Tin", "Sn", "metal", 50));
        items.add(new Menu("Antimony", "Sb", "nonMetal", 51));
        items.add(new Menu("Tellurium", "Te", "nonMetal", 52));
        items.add(new Menu("Polonium", "Po", "metal", 84));
        items.add(new Menu("Boron", "B", "metalloid", 5));
        items.add(new Menu("Silicon", "Si", "metalloid", 14));
        items.add(new Menu("Germanium", "Ge", "metalloid", 32));
        items.add(new Menu("Arsenic", "As", "metalloid", 33));
        items.add(new Menu("Antimony", "Sb", "metalloid", 51));
        items.add(new Menu("Tellurium", "Te", "metalloid", 52));
        items.add(new Menu("Polonium", "Po", "metalloid", 84));


    }

    public String[] getCategories(){
        //assume we are reading data from database
        String[] categories={"metal","nonMetal", "metalloid"};
        return categories;
    }
    public List <Menu> getMenuItems(String catogery){
        List<Menu>result =new ArrayList<>();
        for(Menu m:items){
            if(m.getSymbol().equals(catogery)){
                result.add(m);
            }
        }
        return result;
    }
}
/*
public String[] getCategories(){
        //assume we are reading data from database
    String[] categories={"Hot Drinks","Cold Drinks", "Sandwiches"};
    return categories;
  }
  public List <MenuItem>getMenuItems(String catogery){
        List<MenuItem>result =new ArrayList<>();
        for(MenuItem m:items){
            if(m.getCategory().equals(catogery)){
                result.add(m);
            }
        }
        return result;
  }
 */
