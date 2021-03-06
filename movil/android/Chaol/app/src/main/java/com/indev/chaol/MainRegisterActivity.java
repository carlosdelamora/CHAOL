package com.indev.chaol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.indev.chaol.fragments.interfaces.MainRegisterInterface;
import com.indev.chaol.models.DecodeExtraParams;
import com.indev.chaol.models.DecodeItem;
import com.indev.chaol.utils.Constants;

import java.util.List;

public class MainRegisterActivity extends AppCompatActivity implements MainRegisterInterface {

    private static DecodeExtraParams _MAIN_DECODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main_register);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        _MAIN_DECODE = (DecodeExtraParams) getIntent().getExtras().getSerializable(Constants.KEY_MAIN_DECODE);

        setTitle(_MAIN_DECODE.getTituloActividad());

        /**Adinistrar los fragmentos dinamicos**/
        closeFragment(_MAIN_DECODE.getFragmentTag());
        openFragment(_MAIN_DECODE.getFragmentTag());

        Log.i("Log", "Check create action - MainRegisterActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Log.i("Log", "Check start action - MainRegisterActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log", "Check resume action - MainRegisterActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Log", "Check pause action - MainRegisterActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Log", "Check stop action - MainRegisterActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Log", "Check restart action - MainRegisterActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Log", "Check destroy action - MainRegisterActivity");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        closeFragment(_MAIN_DECODE.getFragmentTag());
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                closeFragment(_MAIN_DECODE.getFragmentTag());
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    /**
     * Valida el tag enviado y cierra si existe el fragmento
     **/
    private void closeFragment(String tag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null)
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();

    }

    /**
     * Abre el fragmento mediante el tag seleccionado
     **/
    private void openFragment(String tag) {
        FragmentTransaction mainFragment = getSupportFragmentManager().beginTransaction();
        mainFragment.add(R.id.fragment_main_register_container, Constants.TAG_FRAGMENT.get(tag), tag);
        mainFragment.addToBackStack(tag);
        mainFragment.commit();
    }

    @Override
    public void onChangeMainFragment(int idView) {

    }

    @Override
    public void removeSecondaryFragment() {
        List<String> secondaryFragments = Constants.FLETES_TAG_FRAGMENTS;

        for (String tag :
                secondaryFragments) {
            closeFragment(tag);
        }
    }

    @Override
    public void showQuestion() {

    }

    @Override
    public void openExternalActivity(int action, Class<?> externalActivity) {

    }

    @Override
    public void setDecodeItem(DecodeItem decodeItem) {

    }

    @Override
    public DecodeItem getDecodeItem() {
        return null;
    }
}
