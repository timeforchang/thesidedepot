package thesidedepot.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User implements Parcelable {
    private String _username;
    private String _pWord;
    private boolean _loggedIn;
    private ArrayList<Build> _buildList;
    private Map<String, Boolean> _badges;

    public Map<String, Boolean> get_badges() {
        return _badges;
    }

    public void set_badges(Map<String, Boolean> _badges) {
        this._badges = _badges;
    }

    public void set_badge(String key) {
        this._badges.put(key, true);
    }

    public ArrayList<Build> get_buildList() {
        return _buildList;
    }

    public void set_buildList(ArrayList<Build> _buildList) {
        this._buildList = _buildList;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_pWord() {
        return _pWord;
    }

    public void set_pWord(String _pWord) {
        this._pWord = _pWord;
    }

    public boolean is_loggedIn() {
        return _loggedIn;
    }

    public void set_loggedIn(boolean _loggedIn) {
        this._loggedIn = _loggedIn;
    }

    public User(String _username, String _pWord, boolean _loggedIn, ArrayList<Build> _buildList) {
        this._username = _username;
        this._pWord = _pWord;
        this._loggedIn = _loggedIn;
        this._buildList = _buildList;
        this._badges = new HashMap<String, Boolean>();
        _badges.put("HoReB", false);
        _badges.put("HoReS", false);
        _badges.put("HoReG", false);
        _badges.put("DIYB", false);
        _badges.put("DIYS", false);
        _badges.put("DIYG", false);
        _badges.put("LGOB", false);
        _badges.put("LGOS", false);
        _badges.put("LGOG", false);
        _badges.put("HoMaB", false);
        _badges.put("HoMaS", false);
        _badges.put("HoMaG", false);
    }

    @SuppressWarnings("unused")
    public User() {}


    @Override
    public String toString() {
        return "User{" +
                ", _username='" + _username + '\'' +
                ", _pWord='" + _pWord + '\'' +
                ", _loggedIn=" + _loggedIn +
                ", _buildList=" + _buildList +
                ", _badges=" + _badges +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean ret = false;
        if (o instanceof User) {
            User ptr = (User) o;
            ret = ptr.get_username().equals(this._username);
        }
        return ret;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._username);
        dest.writeString(this._pWord);
        dest.writeByte(this._loggedIn ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this._buildList);
        dest.writeInt(this._badges.size());
        for (Map.Entry<String, Boolean> entry : this._badges.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeValue(entry.getValue());
        }
    }

    protected User(Parcel in) {
        this._username = in.readString();
        this._pWord = in.readString();
        this._loggedIn = in.readByte() != 0;
        this._buildList = in.createTypedArrayList(Build.CREATOR);
        int _badgesSize = in.readInt();
        this._badges = new HashMap<String, Boolean>(_badgesSize);
        for (int i = 0; i < _badgesSize; i++) {
            String key = in.readString();
            Boolean value = (Boolean) in.readValue(Boolean.class.getClassLoader());
            this._badges.put(key, value);
        }
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
