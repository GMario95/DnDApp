package com.example.mario.dnd.Views;

import com.example.mario.dnd.Common.CharacterClass;

public class SquarePanel {

    private String mCharacterName;
    private CharacterClass mCharacterClass;
    private int mCharacterLevel;

    public SquarePanel(String characterName, CharacterClass characterClass, int characterlevel) {
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
