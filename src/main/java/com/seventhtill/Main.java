package com.seventhtill;

import com.seventhtill.race.dwarf.Dwarf;
import com.seventhtill.race.dwarf.HillDwarf;
import com.seventhtill.race.dwarf.MountainDwarf;
import com.seventhtill.race.elf.Elf;
import com.seventhtill.race.elf.HighElf;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Elf test = new HighElf(); //testing creation
        System.out.println(test.getAbilities());
    }
}
