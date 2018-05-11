package com.example.mario.dnd.Views;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mario.dnd.Adapters.CharacterPanelAdapter;
import com.example.mario.dnd.Common.CharacterClass;
import com.example.mario.dnd.Listeners.HomeFragmentListener;
import com.example.mario.dnd.Models.CharacterPanel;
import com.example.mario.dnd.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeFragmentListener {

    private Context mContext;
    private Toolbar mToolbar; //TODO:(Mario) Toolbar helper class?
    private Menu mToolbarMenu;
    private MenuItem mToolbarOptions;

    private RecyclerView mSquarePanelListView;
    private CharacterPanelAdapter mCharacterPanelAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mToolbar = view.findViewById(R.id.toolbar_home);
        mToolbar.setTitle(R.string.home_title);
        mToolbar.setOverflowIcon(ContextCompat.getDrawable(mContext, R.mipmap.ic_more_vert_black_24dp));
        mToolbar.inflateMenu(R.menu.menu_toolbar_home);

        mToolbarMenu = mToolbar.getMenu();
        mToolbarOptions = mToolbarMenu.getItem(0);
        mToolbarOptions.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(mContext, "Options clicked!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mSquarePanelListView = view.findViewById(R.id.recycler_view_home);
        mCharacterPanelAdapter = new CharacterPanelAdapter(mContext, this);
        mCharacterPanelAdapter.setData(generateSquarePanelList());
        mSquarePanelListView.setAdapter(mCharacterPanelAdapter);
        mSquarePanelListView.setLayoutManager(new LinearLayoutManager(mContext));

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

    @Override
    public void createCharacter() {
        getFragmentManager().beginTransaction().replace(R.id.content, new CharacterSetupFragment()).commit();
    }

    private List<CharacterPanel> generateSquarePanelList() {
        List<CharacterPanel> characterPanelList = new ArrayList<>();
        characterPanelList.add(new CharacterPanel("Melzar", CharacterClass.Wizard, 2));
        characterPanelList.add(new CharacterPanel("Lozar", CharacterClass.Bard, 4));
        characterPanelList.add(new CharacterPanel(null, CharacterClass.Monk, 0)); //Dummy panel for the 'Char creation panel'
        return characterPanelList;
    }

}
