
/**
 * The Proficiencies Class
 * 
 * @Paul Cummings 
 * @version-1.0  9 March 2016
 */
public class Proficiencies
{
    //Base Proficiency Fields
    private boolean unarmedPenalty;
    private boolean improvisedPenalty;
    private boolean meleeWepsPenalty;
    private boolean pistolsPenalty;
    private boolean archThrownPenalty;
    private boolean shotgunsPenalty;
    private boolean riflesPenalty;
    private boolean smgsPenalty;
    private boolean sniperPenalty;
    private boolean gattlingGunPenalty;
    private boolean grenadeLauncherPenalty;
    private boolean rocketLauncherPenalty;

    private int unarmedTier;
    private int improvisedTier;
    private int meleeWepsTier;
    private int pistolsTier;
    private int archThrownTier;
    private int shotgunsTier;
    private int riflesTier;
    private int smgsTier;
    private int sniperTier;
    private int gattlingGunTier;
    private int grenadeLauncherTier;
    private int rocketLauncherTier;
        
    /**
     * Default Constructor for objects of class Skills.
     */

    public Proficiencies()
    {          
        //Core Skill fields that can change
        unarmedPenalty = true;
        improvisedPenalty = true;
        meleeWepsPenalty = true;
        pistolsPenalty = true;
        archThrownPenalty = true;
        shotgunsPenalty = true;
        riflesPenalty = true;
        smgsPenalty = true;
        sniperPenalty = true;
        gattlingGunPenalty = true;
        grenadeLauncherPenalty = true;
        rocketLauncherPenalty = true;

        unarmedTier = 0;
        improvisedTier = 0;
        meleeWepsTier = 0;
        pistolsTier = 0;
        archThrownTier = 0;
        shotgunsTier = 0;
        riflesTier = 0;
        smgsTier = 0;
        sniperTier = 0;
        gattlingGunTier = 0;
        grenadeLauncherTier = 0;
        rocketLauncherTier = 0;           
    }      
    
    /**
     * toStringMethod that returns a string value of the Character Proficiencies.
     * 
     * @ param firstName - Takes in the firstName String for display.
     * @ param lastName - Takes in the lastName String for display.
     */
    public String dispProficiencies(String firstName, String lastName, Attributes myAttributes)
    {     
        return
        "***********************************************\n"+
        "*   " + firstName + " " + lastName + "\n"+
        "***********************************************\n"+
        "*  Proficiency\t\tTier\n"+        
        "*  Unarmed:\t\t " + unarmedTier + "\n"+
        "*  Improvised:\t\t " + improvisedTier + "\n"+
        "*  Clubs & Blades:\t " + meleeWepsTier + "\n"+
        
        "*  Pistols & Magnums:\t " + pistolsTier + "\n"+
        "*  Archery & Thrown:\t " + archThrownTier + "\n"+
        "*  Shotguns:\t\t " + shotgunsTier + "\n"+
        
        "*  Rifles:\t\t " + riflesTier + "\n"+
        "*  SMGs:\t\t " + smgsTier + "\n"+
        "*  Sniper:\t\t " + sniperTier + "\n"+
        
        "*  Gattling Gun:\t " + gattlingGunTier + "\n"+
        "*  Grenade Launcher:\t " + grenadeLauncherTier + "\n"+
        "*  Rocket Launcher:\t " + rocketLauncherTier + "\n"+        
        "***********************************************\n"+
        "\n\n";        
    }    
}