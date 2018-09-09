package thesidedepot.app.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GridAdapter extends BaseAdapter {
    Context context;
    private final String[] materials;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, String[] materials) {
        this.context = context;
        this.materials = materials;
    }

    @Override
    public int getCount() {
        return materials.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
