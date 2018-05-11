package com.example.mario.dnd.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mario.dnd.Listeners.HomeFragmentListener;
import com.example.mario.dnd.R;
import com.example.mario.dnd.Models.CharacterPanel;

import java.util.ArrayList;
import java.util.List;

public class CharacterPanelAdapter extends RecyclerView.Adapter<CharacterPanelAdapter.SquarePanelViewHolder> {

    private Context mContext;
    private HomeFragmentListener mListener;
    private List<CharacterPanel> mCharacterPanelList = new ArrayList<>();

    public CharacterPanelAdapter(Context context, HomeFragmentListener listener) {
        mContext = context;
        mListener = listener;
    }

    public void setData(List<CharacterPanel> characterPanelList) {
        mCharacterPanelList = characterPanelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SquarePanelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_character_panel, parent, false);
        return new SquarePanelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SquarePanelViewHolder holder, int position) {
        if(position == mCharacterPanelList.size()-1) { //Create character panel
            holder.activeLayout.setVisibility(View.GONE);
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.createCharacter();
                }
            });

        } else { //Active character panel
            CharacterPanel currentPanel = mCharacterPanelList.get(position);
            holder.parentLayout.setOnClickListener(null);
            holder.characterName.setText(currentPanel.getCharacterName());
            holder.characterClass.setText(currentPanel.getCharacterClass());
            holder.characterLevel.setText(String.valueOf(currentPanel.getCharacterLevel()));
        }
    }

    @Override
    public int getItemCount() {
        return mCharacterPanelList.size();
    }

    public class SquarePanelViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout parentLayout;
        private RelativeLayout activeLayout;
        private TextView characterName;
        private TextView characterClass;
        private ImageView characterClassImage;
        private TextView characterLevel;

        public SquarePanelViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.content);
            activeLayout = itemView.findViewById(R.id.layout_active_panel);
            characterName = itemView.findViewById(R.id.textview_character_name);
            characterClass = itemView.findViewById(R.id.textview_character_class);
            characterClassImage = itemView.findViewById(R.id.imageview_character_class);
            characterLevel = itemView.findViewById(R.id.textview_character_level);
        }
    }
}
