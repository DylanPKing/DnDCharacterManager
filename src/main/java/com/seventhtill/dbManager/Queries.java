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
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Queries {
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
    public static int addArmour(DnDCharacterDTO DnDCharacterDTO) {
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
        int armourRow = 0;
        sql = "SELECT id FROM armour WHERE name = ? and disadvantage = ? and baseArmour = ? and weight = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setBoolean(2, adv);
            pstmt.setInt(3, baseArm);
            pstmt.setInt(4,weight);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                armourRow = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Added a character's Armour! " + "Armour index: " + armourRow);
        return armourRow;
    }

    //Add a weapon to the weapon db
    public static int addWeapon(DnDCharacterDTO DnDCharacterDTO) {
        int weaponRow = 0;
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
        sql = "SELECT id FROM weapon WHERE weight = ? and properties = ? and damageDie = ? and damageType = ? and name = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,weight);
            pstmt.setString(2,  listOfProperties);
            pstmt.setInt(3, dmgDie);
            pstmt.setObject(4, dmgType);
            pstmt.setString(5, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                weaponRow = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Added a character's weapon! " + "Weapon index: " + weaponRow);
        return weaponRow;
    }

    //Add a DnD Character to the dndcharacter db
    public static void addDnDCharacter(DnDCharacterDTO DnDCharacterDTO, int armourId, int weaponId) {
        String name = DnDCharacterDTO.getCharacterName();
        Race aRace = DnDCharacterDTO.getCharacterRace();
        DnDClass aClass = DnDCharacterDTO.getCharacterClass();

        String sql = "INSERT INTO dndcharacter (characterName, characterRace, characterClass, characterWeapon, characterArmour) VALUES(?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,name);
            pstmt.setObject(2, aRace);
            pstmt.setObject(3, aClass);
            pstmt.setInt(4, weaponId);
            pstmt.setInt(5, armourId);
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
                tempWeapon = getCharacterWeapon();

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
        return characters;
    }

    public static Weapon getCharacterWeapon() {
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
        int weaponId, weight, damageDie, damageType;
        String sql = "SELECT * FROM dndcharacter WHERE characterWeapon = ?";

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                weaponId = rs.getInt("id");
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

    public static ArmourComposite getCharacterArmour(int id) {
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
        String sql = "SELECT * FROM dndcharacter WHERE characterArmour = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             ResultSet rs    = pstmt.executeQuery(sql)){


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

    public static void deleteDnDCharacter(String characterName, int weaponId, int armourId) {
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

        deleteArmour(armourId);
        deleteWeapon(weaponId);
    }

    public static void deleteWeapon(int id) {
        String sql = "DELETE from weapon WHERE weapon.id = ?";
        try (Connection conn = connect();
              PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1,id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteArmour(int id) {
        String sql = "DELETE from armour WHERE armour.id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1,id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Update weapon based on it's id
    public static void updateWeapon(int weight, List<String> list, int dmgDie, DamageType dmgType, String name, int id) {

        List<String> properties = list;
        String listOfProperties = "";
        for(String property : properties) {
            listOfProperties += property + ", ";
        }

        String sql = "UPDATE weapon set weight = ?, "
                + "properties = ?,"
                + "damageDie = ?,"
                + "damageType = ?,"
                + "name = ?"
                +"where id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, weight);
            pstmt.setString(2, listOfProperties);
            pstmt.setInt(3, dmgDie);
            pstmt.setObject(4, dmgType);
            pstmt.setString(5, name);
            pstmt.setInt(6, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Update armour based on it's id
    public static void updateArmour(String name, boolean disadvantage, int baseArmour, int weight, int id) {
        String sql = "UPDATE armour set name = ?, "
                + "disadvantage = ?,"
                + "baseArmour = ?,"
                + "weight = ?"
                +"where id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setBoolean(2, disadvantage);
            pstmt.setInt(3, baseArmour);
            pstmt.setInt(4, weight);
            pstmt.setInt(5, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Update a DnDCharacter based on it's original name.
    public static void updateDnDCharacter(String newName, Race newRace, DnDClass newClass, int newWeaponId, int newArmourId, String oldName) {
        String sql = "UPDATE dndcharacter set characterName = ?, "
                + "characterRace = ?,"
                + "characterClass = ?,"
                + "characterWeapon = ?,"
                + "characterArmour = ?"
                +"where characterName = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, newName);
            pstmt.setObject(2, newRace);
            pstmt.setObject(3, newClass);
            pstmt.setInt(4, newWeaponId);
            pstmt.setInt(5, newArmourId);
            pstmt.setString(6, oldName);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
