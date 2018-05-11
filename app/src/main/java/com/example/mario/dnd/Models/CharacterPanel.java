package com.example.mario.dnd.Models;

import com.example.mario.dnd.Common.CharacterClass;

public class CharacterPanel {

    private String mCharacterName;
    private CharacterClass mCharacterClass;
    private int mCharacterLevel;

    public CharacterPanel(String characterName, CharacterClass characterClass, int characterlevel) {
        mCharacterName = characterName;
        mCharacterClass = characterClass;
        mCharacterLevel = characterlevel;
    }

    public String getCharacterName() {
        return mCharacterName;
    }

    public String getCharacterClass() {
        return mCharacterClass.name();
    }

    public int getCharacterLevel() {
        return mCharacterLevel;
    }
}
