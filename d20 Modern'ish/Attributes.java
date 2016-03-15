
/**
 * The Attributes Class is broken up into fields for Base Attributes and fields for Derivitive Attributes.
 * The Base Attributes must be given default values through the constructor, which then in turn call methods
 * to give the Derivitive Attributes their values.  There are several getMethods that can be called upon
 * to ensure that when a Base Attribute field is changed, so too is its Derivitive Attribute fields.
 * 
 * @Paul Cummings 
 * @version-1.0  7 March 2016
 */
public class Attributes
{
    //Base Attribut Fields
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;
    
    private int fortBonus;
    private int refBonus;
    private int willBonus;     
  
    private int offense;
    private int defense;
    private int luckSurge;    
    
    private int totalSP;    
    
    
    //Derivitive Attribute Fields
    private int str;
    private int con;
    private int dex;
    private int intel;
    private int wis;
    private int cha;
       
    private int wndMax;
    private int wndCurrent;
    private int vitMax;
    private int vitCurrent;  
    
    private int ac;   
    private int fortSave;
    private int refSave;
    private int willSave;   
    
    private int init;
    private int toHitMelee;
    private int toHitRanged;       
    private int dr;
        
    /**
     * Default Constructor for objects of class Attributes.
     */
    public Attributes()
    {          
        //Core Attributes that can change
        strength = 8;
        constitution = 8;
        dexterity = 8;
        intelligence = 8;
        wisdom = 8;
        charisma = 8;     
  
        fortBonus = 0;
        refBonus = 0;
        willBonus = 0;         

        offense = 1;
        defense = 1;
        luckSurge = 1;        
  
        totalSP = 0;        
        
        
        //Derivitive Attributes that are automatically updated
        str = setAttributeModifier(strength);
        con = setAttributeModifier(constitution);
        dex = setAttributeModifier(dexterity);
        intel = setAttributeModifier(intelligence);
        wis = setAttributeModifier(wisdom);
        cha = setAttributeModifier(charisma);
                             
        setWndMax(constitution);
        wndCurrent = wndMax;
        setVitMax(wndMax, totalSP);
        vitCurrent = vitMax;
        
        setAC(dex, intel, defense);
        setFortSave(str, con);
        setRefSave(dex, intel);
        setWillSave(wis, cha);
                    
        init = getInitiative(dex);
        toHitMelee = getToHitMelee(str, offense);        
        toHitRanged = getToHitRanged(dex, offense);       
        dr = getDR(str);        
    }

    /**
     * getMethod that takes in a user value for a Base Attribute.  This method verifies that the new value is in bounds,
     * and then returns that value.
     * 
     * @param baseAttribute - The new value for a Base Attribute.  Must be between 8 & 20.
     */
    public int getBaseAttribute(int baseAttribute)
    { 
        int newBaseAttribute;
        
        if(baseAttribute < 8)
        {
            newBaseAttribute = 8;
        }
        else if(baseAttribute > 20)
        {
            newBaseAttribute = 20;
        }
        else
        {
            newBaseAttribute = baseAttribute;
        }     
        return newBaseAttribute;      
    }    
    
    /**
     * setMethod that takes in a Base Attribute and returns the modifier.
     * 
     * @param baseAttribute - Takes in the value for a Base Attribute.
     */
    public int setAttributeModifier(int baseAttribute)
    {         
        int newModifier;
        newModifier = (baseAttribute - 10) / 2;   
        return newModifier;
    }     
    
    /**
     * getMethod that takes in a Base Attribute and returns the modifier.
     * 
     * @return str - Returns the value for the str field
     */
    public int getSTR()
    {
        return str;
    }      
    
    /**
     * getMethod that takes in a Base Attribute and returns the modifier.
     * 
     * @return con - Returns the value for the con field
     */
    public int getCON()
    {
        return con;
    } 
    
    /**
     * getMethod that takes in a Base Attribute and returns the modifier.
     * 
     * @return dex - Returns the value for the dex field
     */
    public int getDEX()
    {
        return dex;
    } 
    
    /**
     * getMethod that takes in a Base Attribute and returns the modifier.
     * 
     * @return intel - Returns the value for the intel field
     */
    public int getINT()
    {
        return intel;
    } 
    
    /**
     * getMethod that takes in a Base Attribute and returns the modifier.
     * 
     * @return wis - Returns the value for the wis field
     */
    public int getWIS()
    {
        return wis;
    } 
    
    /**
     * getMethod that takes in a Base Attribute and returns the modifier.
     * 
     * @return cha - Returns the value for the cha field
     */
    public int getCHA()
    {
        return cha;
    }     
    
    /**
     * setMethod that changes the strength field.  It utilizes a Method call to verify the value.
     * 
     * @param baseAttribute - The new value for the strength field.  Must be between 8 & 20.  This also assings/
     *                         updates strength modifier (str field), fort field, dr field, and toHitMelee field.
     */
    public void setStrength(int baseAttribute)
    {          
        strength = getBaseAttribute(baseAttribute);
        setAttributeModifier(strength);
        dr = getDR(str);
        setFortSave(str, con);
        toHitMelee = getToHitMelee(str, offense);             
    }     
    
    /**
     * setMethod that changes the constitution field.  It utilizes a Method call to verify the value.
     * 
     * @param baseAttribute - The new value for the constitution field.  Must be between 8 & 20.  This also assings/
     *                         updates constitution modifier (con field), vitMax field, wndMax field, and fort field.
     */
    public void setConstitution(int baseAttribute)
    {          
        constitution = getBaseAttribute(baseAttribute);
        setAttributeModifier(constitution);
        setWndMax(constitution);
        setVitMax(wndMax, totalSP);
        setFortSave(str, con); 
    }      
    
    /**
     * setMethod that changes the dexterity field.  It utilizes a Method call to verify the value.
     * 
     * @param baseAttribute - The new value for the dexterity field.  Must be between 8 & 20.  This also assings/
     *                         updates dexterity modifier (dex field), ac field, ref field, and toHitRanged field.
     */
    public void setDexterity(int baseAttribute)
    {          
        dexterity = getBaseAttribute(baseAttribute);
        setAttributeModifier(dexterity);
        setRefSave(dex, intel);
        setAC(dex, intel, defense);
        toHitRanged = getToHitRanged(dex, offense);
    }      
    
     /**
     * setMethod that changes the intelligence field.  It utilizes a Method call to verify the value.
     * 
     * @param baseAttribute - The new value for the intelligence field.  Must be between 8 & 20.  This also assings/
     *                         updates intelligence modifier (intel field), ac field, and ref field.
     */
    public void setIntelligence(int baseAttribute)
    {          
        intelligence = getBaseAttribute(baseAttribute);
        setAttributeModifier(intelligence);
        setRefSave(dex, intel);
        setAC(dex, intel, defense);
    }     
    
    /**
     * setMethod that changes the strength field.  It utilizes a Method call to verify the value.
     * 
     * @param baseAttribute - The new value for the wisdom field.  Must be between 8 & 20.  This also assings/
     *                         updates wisdom modifier (wis field), and will field.
     */
    public void setWisdom(int baseAttribute)
    {          
        wisdom = getBaseAttribute(baseAttribute);        
        setAttributeModifier(wisdom);
        setWillSave(wis, cha);
    }      
    
    /**
     * setMethod that changes the charisma field.  It utilizes a Method call to verify the value.
     * 
     * @param baseAttribute - The new value for the charisma field.  Must be between 8 & 20.  This also assings/
     *                         updates charisma modifier (cha field), and will field.
     */
    public void setCharisma(int baseAttribute)
    {          
        charisma = getBaseAttribute(baseAttribute);        
        setAttributeModifier(charisma);
        setWillSave(wis, cha);                                                                                                                                                     
    }      

    /**
     * getMethod that verifies and returns the value for the init field.
     * 
     * @param dex - Takes in the value of the dex field. 

     * 
     * @return init - Returns the verified value of the init field.
     */
    public int getInitiative(int dex)
    {   
        init = dex;
        return init;
    }      
    
    /**
     * setMethod that verifies and sets the value for the wndMax field.
     * 
     * @param constitution - Takes in the value of the constitution field.
     * 
     * @return wndMax - Returns the verified value of the wndMax field.
     */
    public void setWndMax(int constitution)
    {   
        wndMax = constitution;
    }     
   
    /** 
     * getMethod that verifies and returns the value for the wndMax field.
     * 
     * @param constitution - Takes in the value of the constitution field.
     * 
     * @return wndMax - Returns the verified value of the wndMax field.
     */
    public int getWndMax()
    {   
        return wndMax;
    }          
    
    /**
     * setMethod that verifies and sets the value for the wndMax field.
     * 
     * @param constitution - Takes in the value of the constitution field.
     * 
     * @return wndMax - Returns the verified value of the wndMax field.
     */
    public void setWndCurrent(int current)
    {   
        if(current > wndMax)
        {
            wndCurrent = wndMax;
        }
        else
        {
            wndCurrent = current;
        }
    }     
    
    /**
     * getMethod that returns the value for the wndCurrent field.
     * 
     * @return wndCurrent - Returns the value of the wndCurrent field.
     */
    public int getWndCurrent()
    {   
        return wndCurrent;
    }      

    /**
     * setMethod that verifies and sets the value for the vitMax field.
     * 
     * @param wndMax - Takes in the value of the wndMax field. 
     * @param totalSP - Takes in the value of the totalSP field.
     */
    public void setVitMax(int wndMax, int totalSP)
    {   
        vitMax = (wndMax * 2) + (totalSP / 2);
        if(vitMax > (wndMax * 5))
        {
            vitMax = (wndMax * 5);
        }
    }      
    
    /**
     * getMethod that returns the value for the vitMax field.
     * 
     * @return vitMax - Returns the value of the vitMax field.
     */
    public int getVitMax()
    {   
        return vitMax;
    }   
    
    /**
     * setMethod that verifies and sets the value for the vitCurrent field.
     * 
     * @param wndMax - Takes in the value of the wndMax field. 
     * @param totalSP - Takes in the value of the totalSP field.
     */
    public void setVitCurrent(int current)
    {   
        if(current > vitMax)
        {
            wndCurrent = wndMax;
        }
        else if(current < 0)
        {
            wndCurrent = 0;
        }
        else
        {
            wndCurrent = current;
        }
    }      
    
    /**
     * getMethod that returns the value for the vitCurrent field.
     * 
     * @return vitCurrent - Returns the value of the vitCurrent field.
     */
    public int getVitCurrent()
    {   
        return vitCurrent;
    }     
    
    /**
     * setMethod that verifies and sets the value for the ac field.
     * 
     * @param dex - Takes in the value of the dex field. 
     * @param intel - Takes in the value of the intel field.
     * @param defense - Takes in the value of the defense field.
     */
    public void setAC(int dex, int intel, int defense)
    {   
        if(dex >= intel)
        {
            ac = dex + defense + 10;
        }
        else
        {
            ac = intel + defense + 10;
        }   
    }    
    
    /**
     * getMethod that returns the value for the ac field.
     * 
     */
    public int getAC()
    {   
        return ac;
    }     
    
    /**
     * setMethod that verifies and sets the value for the fortSave field.
     * 
     * @param str - Takes in the value of the str field. 
     * @param con - Takes in the value of the con field.
     */
    public void setFortSave(int str, int con)
    {   
        if(str >= con)
        {
            fortSave = str + fortBonus;
        }
        else
        {
            fortSave = con + fortBonus;
        }
    }     

    /**
     * getMethod that verifies and sets the value for the fortSave field.
     *  
     * @return fortSave - Returns the fortSave field.
     */
    public int getFortSave()  
    {
        return fortSave;
    }
    
    /**
     * setMethod that verifies and returns the value for the refSave field.
     * 
     * @param dex - Takes in the value of the dex field. 
     * @param intel - Takes in the value of the intel field. 
     */
    public void setRefSave(int dex, int intel)
    {   
        if(dex >= intel)
        {
            refSave = dex + refBonus;
        }
        else
        {
            refSave = intel + refBonus;
        }
    }   
    
    /**
     * getMethod that verifies and sets the value for the refSave field.
     *  
     * @return refSave - Returns the fortSave field.
     */
    public int getRefSave()  
    {
        return refSave;
    }    
    
    /**
     * setMethod that verifies and returns the value for the fortSave field.
     * 
     * @param wis - Takes in the value of the wis field. 
     * @param cha - Takes in the value of the cha field.
     */
    public void setWillSave(int wis, int cha)
    {   
        if(wis >= cha)
        {
            willSave = wis + willBonus;
        }
        else
        {
            willSave = cha + willBonus;
        }
    }   
    
    /**
     * getMethod that verifies and sets the value for the willSave field.
     *  
     * @return willSave - Returns the willSave field.
     */
    public int getWillSave()  
    {
        return willSave;
    }    
    
    /**
     * getMethod that verifies and returns the value for the toHitMelee field.
     * 
     * @param str - Takes in the value from the str field.
     * @param offense - Takes in the value from the offense field.
     * 
     * @return toHitMelee - Returns the verified value of the toHitMelee field.
     */
    public int getToHitMelee(int str, int offense)
    {   
        toHitMelee = str + offense;
        return toHitMelee;
    }      
    
    /**
     * getMethod that verifies and returns the value for the toHitRanged field.
     * 
     * @param dex - Takes in the value from the dex field.
     * @param offense - Takes in the value from the offense field.
     * 
     * @return toHitRanged - Returns the verified value of the toHitRanged field.
     */
    public int getToHitRanged(int dex, int offense)
    {   
        toHitRanged = dex + offense;
        return toHitRanged;
    }      
    
    /**
     * getMethod that verifies and returns the value for the dr field.
     * 
     * @return dr - Returns the verified value of the dr field.
     */
    public int getDR(int str)
    {   
        double strCast = str;        
        dr = (int)((strCast / 2) + .5);        
        if(dr < 0)
        {
            dr = 0;
        }      
        return dr;
    }    
    
    /**
     * toStringMethod that returns a string value of the Character Attributes.
     * 
     * @ param firstName - Takes in the firstName String for display.
     * @ param lastName - Takes in the lastName String for display.
     */
    public String dispAttributes(String firstName, String lastName)
    {     
        return
        "***********************************************\n"+
        "*   " + firstName + " " + lastName + "\n"+
        "***********************************************\n"+
        "*  Vitality Points:  " + getVitCurrent() + "/" + getVitMax() + "\n"+
        "*  Wound Points:     " + getWndCurrent() + "/" + getWndMax() + "\n"+
        "*\n"+
        "*  AC:    " + ac + "\n"+
        "*  FORT:  " + fortSave + "\n"+
        "*  REF:   " + refSave + "\n"+
        "*  WILL:  " + willSave + "\n"+        
        "*\n"+
        "*  Ability      Score   Mod\n"+
        "*  Strength:      " + strength +     "     " + str + "\n"+
        "*  Constitution:  " + constitution + "     " + con + "\n"+
        "*  Dexterity:     " + dexterity +    "     " + dex + "\n"+
        "*  Intelligence:  " + intelligence + "     " + intel + "\n"+
        "*  Wisdom:        " + wisdom +       "     " + wis + "\n"+
        "*  Charisma:      " + charisma +     "     " + cha + "\n"+
        "*\n"+        
        "*  Offense:     " + offense + "\n"+
        "*  Defense:     " + defense + "\n"+
        "*  Luck/Surge:  " + luckSurge + "\n"+
        "*\n"+      
        "*  Initiative:        " + init + "\n"+
        "*  Damage Reduction:  " + dr + "\n"+
        "*\n"+
        "*  Melee to Hit:   " + toHitMelee + "\n"+
        "*  Ranged to Hit:  " + toHitRanged + "\n"+
        "***********************************************\n"+        
        "\n\n";  
    }    
}
