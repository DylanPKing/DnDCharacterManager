package com.seventhtill.dbManager;

import com.seventhtill.characterSheet.CharacterBuilder;
import com.seventhtill.characterSheet.CharacterDirector;
import com.seventhtill.characterSheet.CharacterSheet;
import com.seventhtill.characterSheet.DnDCharacter;
import com.seventhtill.common.DamageType;
import com.seventhtill.dndclass.AbstractFactoryDndClass;
import com.seventhtill.dndclass.DnDClass;
import com.seventhtill.dndclass.FactoryProducerClass;
import com.seventhtill.item.armour.Armour;
import com.seventhtill.item.armour.ArmourComposite;
import com.seventhtill.item.armour.Shield;
import com.seventhtill.item.weapon.Weapon;
import com.seventhtill.item.weapon.WeaponAttackType;
import com.seventhtill.race.AbstractFactory;
import com.seventhtill.race.FactoryProducer;
import com.seventhtill.race.Race;
import com.seventhtill.ui.*;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Queries {
    public static int armourRow = 0;
    public static int weaponRow = 0;
    /**
     * Connect to the database
     * @return the Connection object
     */
    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/workarea/DnDCharacterManager/db.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //Add an armour to the armour db
    public static void addArmour(DnDCharacterDTO DnDCharacterDTO) {
        armourRow = 0;
        String name = DnDCharacterDTO.getArmourName();
        boolean adv = DnDCharacterDTO.isDisadvantage();
        int baseArm = DnDCharacterDTO.getBaseArmour();
        int weight = DnDCharacterDTO.getArmourWeight();
        String sql = "INSERT INTO armour (name, disadvantage, baseArmour, weight) VALUES(?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setBoolean(2, adv);
            pstmt.setInt(3, baseArm);
            pstmt.setInt(4,weight);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //get the index of the row
        sql = "SELECT * FROM armour";
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                armourRow ++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Added a character's Armour! " + "Armour index: " + armourRow);
    }

    //Add a weapon to the weapon db
    public static void addWeapon(DnDCharacterDTO DnDCharacterDTO) {
        weaponRow = 0;
        int weight = DnDCharacterDTO.getArmourWeight();
        List<String> properties = DnDCharacterDTO.getProperties();

        String listOfProperties = "";
        for(String property : properties) {
            listOfProperties += property + ", ";
        }
        int dmgDie = DnDCharacterDTO.getDamageDie();
        DamageType dmgType = DnDCharacterDTO.getDamageType();
        String name = DnDCharacterDTO.getWeaponName();

        String sql = "INSERT INTO weapon (weight, properties, damageDie, damageType, name) VALUES(?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,weight);
            pstmt.setString(2,  listOfProperties);
            pstmt.setInt(3, dmgDie);
            pstmt.setObject(4, dmgType);
            pstmt.setString(5, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //get the index of the row
        sql = "SELECT * FROM weapon";
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                weaponRow ++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Added a character's weapon! " + "Weapon index: " + weaponRow);
    }

    //Add a DnD Character to the dndcharacter db
    public static void addDnDCharacter(DnDCharacterDTO DnDCharacterDTO) {
        String name = DnDCharacterDTO.getCharacterName();
        Race aRace = DnDCharacterDTO.getCharacterRace();
        DnDClass aClass = DnDCharacterDTO.getCharacterClass();
        int weaponID, armourID; //TODO deal with these ids increments
        weaponID = weaponRow;
        armourID = armourRow;

        String sql = "INSERT INTO dndcharacter (characterName, characterRace, characterClass, characterWeapon, characterArmour) VALUES(?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,name);
            pstmt.setObject(2, aRace);
            pstmt.setObject(3, aClass);
            pstmt.setInt(4, weaponID);
            pstmt.setInt(5, armourID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Added a character!");
    }

    //Retrieve DnD Characters where the weapon and armour ids match their armour and weapon table corresponding entries
    public static ArrayList<DnDCharacter> retrieveDnDCharacter() {
        ArrayList<DnDCharacter> characters = new ArrayList<>();
        String characterName, characterRace, characterClass, characterWeapon, characterArmour;
        int aWeapon, anArmour, aStrength, aConstitution, aDexterity, anIntelligence, aWisdom, aCharisma;
        String sql = "SELECT * FROM dndcharacter";

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                characterName = rs.getString("characterName");
                characterRace = rs.getString("characterRace");
                characterClass =  rs.getString("characterClass");
                aWeapon = rs.getInt("characterWeapon");
                anArmour = rs.getInt("characterArmour");
                aStrength = rs.getInt("strength");
                aConstitution = rs.getInt("constitution");
                aDexterity = rs.getInt("dexterity");
                anIntelligence = rs.getInt("intelligence");
                aWisdom = rs.getInt("wisdom");
                aCharisma =  rs.getInt("charisma");

                //invoke builder for character
                CharacterBuilder newCharacter = new CharacterSheet();
                CharacterDirector characterDirector = new CharacterDirector(newCharacter);
                characterDirector.makeCharacter();
                //objects to be filled
                DnDCharacter aCharacter = characterDirector.getCharacter();
                //variables for each component
                ArmourComposite tempArmour = null;
                Weapon tempWeapon = null;

                //Split for factory to work correctly
                String[] characterRaceSplit = characterRace.split(" ");
                AbstractFactory raceFactory = FactoryProducer.getFactory(characterRaceSplit[0]); //first index
                Race aRace = raceFactory.getRace(characterRace); //entire string

                AbstractFactoryDndClass classFactory = FactoryProducerClass.getFactory(characterClass);
                DnDClass aClass = classFactory.getDndClass(characterClass);

                tempArmour = getCharacterArmour(anArmour);
                tempWeapon = getCharacterWeapon(aWeapon);

                //Create object
                aCharacter.setCharacterName(characterName);
                aCharacter.setCharacterRace(aRace);
                aCharacter.setCharacterClass(aClass);
                aCharacter.setCharacterWeapon(tempWeapon);
                aCharacter.setCharacterArmour(tempArmour);
                //add to list
                characters.add(aCharacter);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("I am found child");
        return characters;
    }

    public static Weapon getCharacterWeapon(int weaponId) {
        //Weapon helpers
        SimpleMeleeWeaponHelper simpleMeleeHelper = new SimpleMeleeWeaponHelper();
        SimpleRangedWeaponHelper simpleRangedHelper = new SimpleRangedWeaponHelper();
        MartialMeleeWeaponHelper martialMeleeHelper = new MartialMeleeWeaponHelper();
        MartialRangedWeaponHelper martialRangedHelper = new MartialRangedWeaponHelper();
        // First set up arrays of each type of weapon
        ArrayList<Weapon> simpleMeleeWeapons = simpleMeleeHelper.init();
        ArrayList<Weapon> simpleRangedWeapons = simpleRangedHelper.init();
        ArrayList<Weapon> martialMeleeWeapons = martialMeleeHelper.init();
        ArrayList<Weapon> martialRangedWeapons = martialRangedHelper.init();

        Weapon aWeapon = null;
        String weaponName;
        int weight, damageDie, damageType;
        //properties blob deal with later
        String sql = "SELECT * FROM dndcharacter WHERE characterWeapon = " + weaponId;

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                weaponName = rs.getString("name");
                weight = rs.getInt("weight");
                damageDie =  rs.getInt("damageDie");
                damageType = rs.getInt("damageType");

                //Add whatever weapon we read
                ArrayList<Weapon> weaponList = (ArrayList<Weapon>) Stream.of(simpleMeleeWeapons, simpleRangedWeapons, martialMeleeWeapons, martialRangedWeapons).flatMap(Collection::stream).collect(Collectors.toList());
                for (Weapon weapon : weaponList) {
                    if (weaponName.contains(weapon.getName())) {
                        aWeapon = weapon;
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return aWeapon;
    }

    public static ArmourComposite getCharacterArmour(int armourId) {
        //Armour helpers
        LightArmourHelper lightArmourHelper = new LightArmourHelper();
        MediumArmourHelper mediumArmourHelper = new MediumArmourHelper();
        HeavyArmourHelper heavyArmourHelper = new HeavyArmourHelper();
        // Make lists for these
        ArrayList<Armour> lightArmour = lightArmourHelper.init();
        ArrayList<Armour> mediumArmour = mediumArmourHelper.init();
        ArrayList<Armour> heavyArmour = heavyArmourHelper.init();

        ArmourComposite anArmour = null;
        String armourName;
        int armourAdvantage, armourBase, armourWeight;
        String sql = "SELECT * FROM dndcharacter WHERE characterArmour = " + armourId;

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                armourName = rs.getString("name");
                armourAdvantage = rs.getInt("disadvantage");
                armourBase = rs.getInt("baseArmour");
                armourWeight = rs.getInt("weight");

                //Add whatever armour we read
                ArrayList<Armour> armourList = (ArrayList<Armour>) Stream.of(lightArmour, mediumArmour, heavyArmour).flatMap(Collection::stream).collect(Collectors.toList());
                armourList.add(new Shield());
                for (Armour armour : armourList) {
                    if (armourName.contains(armour.getName())) {
                        anArmour.add(armour);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return anArmour;
    }
    //TODO: change
    //Update weapon based on it's id
    public static String updateWeapon(Weapon weapon, WeaponAttackType attackType, int id) {
        return "UPDATE weapon set weapon.name = " + weapon.getName() +
                ", weapon.weight = " + weapon.getWeight() +
                ", weapon.properties = " + weapon.getProperties() +
                ", weapon.damageType = " + attackType.getDamageType() +
                ", weapon.damageDie = " + attackType.getDamageDie() +
                ", WHERE weapon.id = " + id;
    }
    //TODO: change
    //Update armour based on it's id
    public static String updateArmour(Armour armour) {
        return "UPDATE armour set armour.name = " + armour.getName() +
                ", armour.weight = " + armour.getWeight() +
                ",armour.baseArmour = " + armour.getBaseArmour() +
                ",armour.disadvantage = " + armour.isDisadvantage() +
                ", WHERE armour.id = ";
    }
    //TODO: change
    //Update a DnDCharacter based on it's original name.
    public static String updateDnDCharacter(String name, DnDCharacter newDnDCharacter) {
        return "UPDATE dndcharacter set dndcharacter.characterName = " + newDnDCharacter.getCharacterName() +
                ", dndcharacter.characterRace = " + newDnDCharacter.getCharacterRace() +
                ", dndcharacter.characterClass = " + newDnDCharacter.getCharacterClass() +
                ",dndcharacter.characterWeapon = " + newDnDCharacter.getCharacterWeapon() +
                ",dndcharacter.characterArmour = " + newDnDCharacter.getCharacterArmour() +
                ", WHERE dndcharacter.characterName = " + name;
    }

    public static int getCharacterArmourId() {
        int armourId = 0;
        String sql = "SELECT armour.id from armour where armour.id in (select characterArmour from dndcharacter)";
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                armourId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return armourId;
    }

    public static int getCharacterWeaponId() {
        int weaponId = 0;
        String sql = "SELECT weapon.id from weapon where weapon.id in (select characterWeapon from dndcharacter)";
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                weaponId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return weaponId;
    }

    public static void deleteDnDCharacter(String characterName) {
        deleteArmour();
        deleteWeapon();
        String sql = "DELETE from dndcharacter WHERE characterName = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, characterName);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteWeapon() {
        int id = getCharacterWeaponId();
        String sql = "DELETE from weapon WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteArmour() {
        int id = getCharacterArmourId();
        String sql = "DELETE from armour WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
