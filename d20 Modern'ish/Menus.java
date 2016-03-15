
/**
 * Write a description of class Menus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Menus
{
    Scanner keyboard = new Scanner(System.in);

    /**
     * toStringMethod that returns a string value for the main menu.
     * 
     * @ return main menu String representation.
     */
    public String dispMainMenu()
    {       
        return
        "***********************************************\n"+
        "*                  Main Menu                  *\n"+
        "***********************************************\n"+
        "* 1) Creat a New Character                    *\n"+
        "* 2) Save Character                           *\n"+
        "* 3) Load Character                           *\n"+
        "* 4) Modify Character                         *\n"+
        "* 5) Perform Character Actions                *\n"+
        "* 6) Exit                                     *\n"+
        "***********************************************\n"+
        "\nYour Selection:  ";
    }

    /**
     * toStringMethod that returns a string value for Character Sheet menu.
     * 
     * @ return charcter sheet menu String representation.
     */
    public String dispCharSheetMenu()
    {     
        return
        "***********************************************\n"+        
        "*            Character Sheet Menu             *\n"+        
        "***********************************************\n"+
        "* a) Primary Character Attributes             *\n"+
        "* s) Character Skills                         *\n"+
        "* p) Character Proficiencies                  *\n"+
        "* r) Return to Previous Menu                  *\n"+
        "***********************************************\n"+        
        "\nYour Selection:  ";        
    }    
            
    /**
     * toStringMethod that returns a string value for a Character Sheet.
     * 
     * @ param firstName - The String value for the character's first name.
     * @ param lastName - The String value for the character's last name.
     */
    public void charSheetMenu(String firstName, String lastName, Attributes myAttributes, Skills mySkills, Proficiencies myProficiencies)
    {
        char charSheetChoice;
        String dispMenu;
        String dispPage;
        
        do
        {
            dispMenu = dispCharSheetMenu();
            System.out.print(dispMenu);
            charSheetChoice = keyboard.next().charAt(0);
            System.out.print("\n");            
            
            if(charSheetChoice == 'a' || charSheetChoice == 'A')
            {
                dispPage = myAttributes.dispAttributes(firstName, lastName);
                System.out.print(dispPage);
            }
            else if(charSheetChoice == 's' || charSheetChoice == 'S')
            {
                dispPage = mySkills.dispSkills(firstName, lastName, myAttributes);
                System.out.print(dispPage);                
            }
            else if (charSheetChoice == 'p' || charSheetChoice == 'P')
            {
                dispPage = myProficiencies.dispProficiencies(firstName, lastName, myAttributes);
                System.out.print(dispPage);                
            }
            else if (charSheetChoice == 'r' || charSheetChoice == 'R')
            {
                System.out.print("Returning you now...\n\n");
            }
            else
            {
                System.out.print("Please make a valid selection.  The choices are\n"+
                                 "not case-sensitive.\n\n");
            }
        }while(charSheetChoice != 'r' && charSheetChoice != 'R');
    }
    
    /**
     * toStringMethod that returns a string value for Modify Character menu.
     * 
     * @ return modify charcter menu String representation.
     */
    public String dispCharModMenu()
    {     
        return
        "***********************************************\n"+        
        "*            Modify Character Menu            *\n"+        
        "***********************************************\n"+
        "* a) Primary Character Attributes             *\n"+
        "* s) Character Skills                         *\n"+
        "* p) Character Proficiencies                  *\n"+
        "* r) Return to Previous Menu                  *\n"+
        "***********************************************\n"+        
        "\nYour Selection:  ";        
    } 
    
    /**
     * A method
     * 
     * @ param firstName - The String value for the character's first name.
     * @ param lastName - The String value for the character's last name.
     */
    public void modifyCharacter(String firstName, String lastName)
    {
        char charSheetChoice;
        String dispMenu;
        String dispPage;
        
        do
        {
            dispMenu = dispCharSheetMenu();
            System.out.print(dispMenu);
            charSheetChoice = keyboard.next().charAt(0);
            System.out.print("\n");            
            

        }while(charSheetChoice != 'r' && charSheetChoice != 'R');
    }    
}   