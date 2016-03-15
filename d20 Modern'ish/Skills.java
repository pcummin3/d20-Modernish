
/**
 * The Skills Class
 * 
 * @Paul Cummings 
 * @version-1.0  9 March 2016
 */
public class Skills
{  
    Attributes baseAttributes = new Attributes();
    
    //Base Skill Fields
    private int acrobaticsRanks;
    private int computerUseRanks;
    private int athleticsRanks;
    private int bluffRanks;
    private int diplomacyRanks;
    private int engineeringRanks;
    private int demolitionsRanks;
    private int pharmMedicineRanks;
    private int mechanicalRanks;
    private int insightRanks;
    private int intimidateRanks;
    private int electronicsRanks;
    private int perceptionRanks;
    private int driveRanks;
    private int stealthRanks;
    private int streetwiseRanks;
    private int thieveryRanks;

    private boolean acrobaticsTrained;
    private boolean computerUseTrained;
    private boolean athleticsTrained;
    private boolean bluffTrained;
    private boolean diplomacyTrained;
    private boolean engineeringTrained;
    private boolean demolitionsTrained;
    private boolean pharmMedicineTrained;
    private boolean mechanicalTrained;
    private boolean insightTrained;
    private boolean intimidateTrained;
    private boolean electronicsTrained;
    private boolean perceptionTrained;
    private boolean driveTrained;
    private boolean stealthTrained;
    private boolean streetwiseTrained;
    private boolean thieveryTrained;

    //Derivitive Skill Fields
    private int acrobaticsTotal;
    private int computerUseTotal;
    private int athleticsTotal;
    private int bluffTotal;
    private int diplomacyTotal;
    private int engineeringTotal;
    private int demolitionsTotal;
    private int pharmMedicineTotal;
    private int mechanicalTotal;
    private int insightTotal;
    private int intimidateTotal;
    private int electronicsTotal;
    private int perceptionTotal;
    private int driveTotal;
    private int stealthTotal;
    private int streetwiseTotal;
    private int thieveryTotal;

    /**
     * Default Constructor for objects of class Skills.
     */

    public Skills()
    {          
        //Core Skill fields that can change
        acrobaticsRanks = 0;
        computerUseRanks = 0;
        athleticsRanks = 0;
        bluffRanks = 0;
        diplomacyRanks = 0;
        engineeringRanks = 0;
        demolitionsRanks = 0;
        pharmMedicineRanks = 0;
        mechanicalRanks = 0;
        insightRanks = 0;
        intimidateRanks = 0;
        electronicsRanks = 0;
        perceptionRanks = 0;
        driveRanks = 0;
        stealthRanks = 0;
        streetwiseRanks = 0;
        thieveryRanks = 0;

        acrobaticsTrained = false;
        computerUseTrained = false;
        athleticsTrained = false;
        bluffTrained = false;
        diplomacyTrained = false;
        engineeringTrained = false;
        demolitionsTrained = false;
        pharmMedicineTrained = false;
        mechanicalTrained = false;
        insightTrained = false;
        intimidateTrained = false;
        electronicsTrained = false;
        perceptionTrained = false;
        driveTrained = false;
        stealthTrained = false;
        streetwiseTrained = false;
        thieveryTrained = false;    

        //Derivitive Skill fields that are automatically updated
        acrobaticsTotal = getSkillTotal(acrobaticsRanks, acrobaticsTrained, baseAttributes.getDEX());       
        computerUseTotal = getSkillTotal(computerUseRanks, computerUseTrained, baseAttributes.getINT());
        athleticsTotal = getSkillTotal(athleticsRanks, athleticsTrained, baseAttributes.getSTR());
        bluffTotal = getSkillTotal(bluffRanks, bluffTrained, baseAttributes.getCHA());
        diplomacyTotal = getSkillTotal(diplomacyRanks, diplomacyTrained, baseAttributes.getCHA());
        engineeringTotal = getSkillTotal(engineeringRanks, engineeringTrained, baseAttributes.getINT());
        demolitionsTotal = getSkillTotal(demolitionsRanks, demolitionsTrained, baseAttributes.getINT());
        pharmMedicineTotal = getSkillTotal(pharmMedicineRanks, pharmMedicineTrained, baseAttributes.getINT());
        mechanicalTotal = getSkillTotal(mechanicalRanks, mechanicalTrained, baseAttributes.getINT());
        insightTotal = getSkillTotal(insightRanks, insightTrained, baseAttributes.getWIS());
        intimidateTotal = getSkillTotal(intimidateRanks, intimidateTrained, baseAttributes.getCHA());
        electronicsTotal = getSkillTotal(electronicsRanks, electronicsTrained, baseAttributes.getINT());
        perceptionTotal = getSkillTotal(perceptionRanks, perceptionTrained, baseAttributes.getWIS());
        driveTotal = getSkillTotal(driveRanks, driveTrained, baseAttributes.getDEX());
        stealthTotal = getSkillTotal(stealthRanks, stealthTrained, baseAttributes.getDEX());
        streetwiseTotal = getSkillTotal(streetwiseRanks, streetwiseTrained, baseAttributes.getCHA());
        thieveryTotal = getSkillTotal(thieveryRanks, thieveryTrained, baseAttributes.getDEX());    
    }

    /**
     * getMethod that takes in skill ranks and whether or not it has been trained and returns
     * the total bonus for that skill.
     * 
     * @param ranks - Takes in the value for the number of ranks that skill has.
     * @param trained - Takes in the true or false value for whether that skill has been trained.
     */
    public int getSkillTotal(int ranks, boolean trained, int mod)
    {         
        int total = 0;
        total += (ranks + mod);
        if(trained)
        {
            total += 5;
        }       
        return total;      
    }   
    
    /**
     * getMethod that returns String value of yes or no.
     * 
     * @param trained - Takes in the true or false value for whether that skill has been trained.
     */
    public String getTrained(boolean trained)
    {    
        String yesNo;
        
        if(trained == true)
        {
            yesNo = "Yes";
        }
        else
        {
            yesNo = "No";
        }
        return yesNo;      
    }      

    /**
     * toStringMethod that returns a string value of the Character Skills.
     * 
     * @ param firstName - Takes in the firstName String for display.
     * @ param lastName - Takes in the lastName String for display.
     */
    public String dispSkills(String firstName, String lastName, Attributes myAttributes)
    {   
        String acrobaticsYesNo = getTrained(acrobaticsTrained);
        String computerUseYesNo = getTrained(computerUseTrained);
        String athleticsYesNo = getTrained(athleticsTrained);
        String bluffYesNo = getTrained(bluffTrained);
        String diplomacyYesNo = getTrained(diplomacyTrained);
        String engineeringYesNo = getTrained(engineeringTrained);
        String demolitionsYesNo = getTrained(demolitionsTrained);
        String pharmMedicineYesNo = getTrained(pharmMedicineTrained);
        String mechanicalYesNo = getTrained(mechanicalTrained);
        String insightYesNo = getTrained(insightTrained);
        String intimidateYesNo = getTrained(intimidateTrained);
        String electronicsYesNo = getTrained(electronicsTrained);
        String perceptionYesNo = getTrained(perceptionTrained);
        String driveYesNo = getTrained(driveTrained);
        String stealthYesNo = getTrained(stealthTrained);
        String streetwiseYesNo = getTrained(streetwiseTrained);
        String thieveryYesNo = getTrained(thieveryTrained);
                
        return
        "*********************************************************\n"+
        "*   " + firstName + " " + lastName + "\n"+
        "*********************************************************\n"+
        "*  Skill            Total\t=   Mod + Ranks + Specialized\n"+
        "*  Acrobatics        " + acrobaticsTotal + "\t\t=   " + myAttributes.getDEX() + "      "+
        acrobaticsRanks + "         " + acrobaticsYesNo + "\n"+ 
        
        "*  Computer Use      " + computerUseTotal + "\t\t=   " + myAttributes.getINT() + "      "+
        computerUseRanks + "         " + computerUseYesNo + "\n"+
        
        "*  Athletics         " + athleticsTotal + "\t\t=   " + myAttributes.getSTR() + "      "+
        athleticsRanks + "         " + athleticsYesNo + "\n"+
        
        "*  Bluff             " + bluffTotal + "\t\t=   " + myAttributes.getCHA() + "      "+
        bluffRanks + "         " + bluffYesNo + "\n"+
        
        "*  Diplomacy         " + diplomacyTotal + "\t\t=   " + myAttributes.getCHA() + "      "+
        diplomacyRanks + "         " + diplomacyYesNo + "\n"+
        
        "*  Engineering       " + engineeringTotal + "\t\t=   " + myAttributes.getINT() + "      "+
        engineeringRanks + "         " + engineeringYesNo + "\n"+
        
        "*  Demolitions       " + demolitionsTotal + "\t\t=   " + myAttributes.getINT() + "      "+
        demolitionsRanks + "         " + demolitionsYesNo + "\n"+
        
        "*  Pharm/Medicine    " + pharmMedicineTotal + "\t\t=   " + myAttributes.getINT() + "      "+
        pharmMedicineRanks + "         " + pharmMedicineYesNo + "\n"+
        
        "*  Mechanical        " + mechanicalTotal + "\t\t=   " + myAttributes.getINT() + "      "+
        mechanicalRanks + "         " + mechanicalYesNo + "\n"+
        
        "*  Insight           " + insightTotal + "\t\t=   " + myAttributes.getWIS() + "      "+
        insightRanks + "         " + insightYesNo + "\n"+
        
        "*  Intimidate        " + intimidateTotal + "\t\t=   " + myAttributes.getCHA() + "      "+
        intimidateRanks + "         " + intimidateYesNo + "\n"+
        
        "*  Electronics       " + electronicsTotal + "\t\t=   " + myAttributes.getINT() + "      "+
        electronicsRanks + "         " + electronicsYesNo + "\n"+
        
        "*  Perception        " + perceptionTotal + "\t\t=   " + myAttributes.getWIS() + "      "+
        perceptionRanks + "         " + perceptionYesNo + "\n"+
        
        "*  Drive             " + driveTotal + "\t\t=   " + myAttributes.getDEX() + "      "+
        driveRanks + "         " + driveYesNo + "\n"+
        
        "*  Stealth           " + stealthTotal + "\t\t=   " + myAttributes.getDEX() + "      "+
        stealthRanks + "         " + stealthYesNo + "\n"+
        
        "*  Streetwise        " + streetwiseTotal + "\t\t=   " + myAttributes.getCHA() + "      "+
        streetwiseRanks + "         " + streetwiseYesNo + "\n"+
        
        "*  Theivery          " + thieveryTotal + "\t\t=   " + myAttributes.getDEX() + "      "+
        thieveryRanks + "         " + thieveryYesNo + "\n"+
        
        "*********************************************************\n"+        
        "\n\n";  
    }
}