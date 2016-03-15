/**
 * The Driver Class
 * 
 * @Paul Cummings 
 * @version-1.0  9 March 2016
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Driver
{
    public static void main(String[] args) throws IOException
    {
        String dispMenu;
        String characterSheet;
        String characterFirstName = "";
        String characterLastName = "";
        int menuSelection;
        String continueOrV;

        Scanner keyboard = new Scanner(System.in);
        Menus myMenus = new Menus();
        Attributes myAttributes = new Attributes();
        Skills mySkills = new Skills();
        Proficiencies myProficiencies = new Proficiencies();
        Enemy myEnemy = new Enemy();

        do
        {
            dispMenu = myMenus.dispMainMenu();
            System.out.print(dispMenu);
            menuSelection = keyboard.nextInt();
            System.out.print("\n");

            if(menuSelection == 1)
            {
                System.out.print("Please enter your character's first name:  ");
                characterFirstName = keyboard.next();
                System.out.print("Please enter your character's last name:  ");
                characterLastName = keyboard.next();                
                System.out.print("\n\n");

                System.out.print("New base-line character sheet created.\n\n"+
                    "Press v to view your character sheet,\n"+
                    "or any other key to continue:  ");
                continueOrV = keyboard.next();
                System.out.print("\n\n");

                if(continueOrV.charAt(0) == 'v' || continueOrV.charAt(0) == 'V')
                {
                    myMenus.charSheetMenu(characterFirstName, characterLastName, myAttributes, mySkills, myProficiencies);
                }                
            }
            else if(menuSelection == 2)
            {
            }
            else if(menuSelection == 3)
            {
            }
            else if(menuSelection == 4)
            {
                if(characterFirstName == "" || characterLastName == "")
                {
                    System.out.print("\nYou have not yet loaded or created\n"+
                        "a new Character for use!\n\n");
                }
                else
                {
                    myMenus.modifyCharacter(characterFirstName, characterLastName);
                }

            }
            else if(menuSelection == 5)
            {
            }
            else
            {
                System.out.println("\nThank you for using d20 Modern'ish!");
            }           
        }while(menuSelection != 6);
    }

}
