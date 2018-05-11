package com.example.mario.dnd.Views;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mario.dnd.R;

public class CharacterSetupFragment extends Fragment {

    private Context mContext;
    private Toolbar mToolbar;
    //TODO:(Mario) Add back button to toolbar

    private EditText mCharacterNameField;
    private EditText mCharacterClassField;
    private EditText mCharacterLevelField;
    private Button mSubmitButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_setup, container, false);

        mToolbar = view.findViewById(R.id.toolbar_character_setup);
        //TODO:(Mario) Setup toolbar

        mCharacterNameField = view.findViewById(R.id.edittext_character_name);
        mCharacterClassField = view.findViewById(R.id.edittext_character_class);
        mCharacterLevelField = view.findViewById(R.id.edittext_character_level);
        mSubmitButton = view.findViewById(R.id.button_character_setup);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:(Mario) Create a bundle, add form data, and pass it to a new profile fragment
                //New fragment should handle instantiating a singleton of a CharacterModel
                Toast.makeText(mContext,
                        mCharacterNameField.getText().toString() + " : " +
                        mCharacterClassField.getText().toString() + " : " +
                        mCharacterLevelField.getText().toString()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
