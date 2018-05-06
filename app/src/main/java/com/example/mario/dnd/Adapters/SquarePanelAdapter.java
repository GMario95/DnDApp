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

import com.example.mario.dnd.R;
import com.example.mario.dnd.Views.SquarePanel;

import java.util.ArrayList;
import java.util.List;

public class SquarePanelAdapter extends RecyclerView.Adapter<SquarePanelAdapter.SquarePanelViewHolder> {

    private Context mContext;
    private List<SquarePanel> mSquarePanelList = new ArrayList<>();

    public SquarePanelAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<SquarePanel> squarePanelList) {
        mSquarePanelList = squarePanelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SquarePanelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_square_panel, parent, false);
        return new SquarePanelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SquarePanelViewHolder holder, int position) {
        if(position == mSquarePanelList.size()-1) { //Create character panel
            holder.activeLayout.setVisibility(View.GONE);
            holder.createCharacterImage.setVisibility(View.VISIBLE);
            holder.createCharacterImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        } else { //Active character panel
            SquarePanel currentPanel = mSquarePanelList.get(position);
            holder.activeLayout.setVisibility(View.VISIBLE);
            holder.createCharacterImage.setVisibility(View.GONE);
            holder.createCharacterImage.setOnClickListener(null);

            holder.characterName.setText(currentPanel.getCharacterName());
            holder.characterClass.setText(currentPanel.getCharacterClass());
            holder.characterLevel.setText(currentPanel.getCharacterLevel());
        }
    }

    @Override
    public int getItemCount() {
        return mSquarePanelList.size();
    }

    public class SquarePanelViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout activeLayout;
        private TextView characterName;
        private TextView characterClass;
        private TextView characterLevel;
        private ImageView createCharacterImage;

        public SquarePanelViewHolder(View itemView) {
            super(itemView);
            activeLayout = itemView.findViewById(R.id.layout_active_panel);
            characterName = itemView.findViewById(R.id.textview_character_name);
            characterClass = itemView.findViewById(R.id.textview_character_class);
            characterLevel = itemView.findViewById(R.id.textview_character_level);
            createCharacterImage = itemView.findViewById(R.id.imageview_new_char);
        }
    }
}
