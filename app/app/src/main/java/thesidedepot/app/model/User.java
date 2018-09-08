package thesidedepot.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

public class User implements Parcelable {
    private String _username;
    private String _pWord;
    private boolean _loggedIn;

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

    public User(String _username, String _pWord, boolean _loggedIn) {
        this._username = _username;
        this._pWord = _pWord;
        this._loggedIn = _loggedIn;
    }

    @SuppressWarnings("unused")
    public User() {}


    @Override
    public String toString() {
        return "User{" +
                ", _username='" + _username + '\'' +
                ", _pWord='" + _pWord + '\'' +
                ", _loggedIn=" + _loggedIn +
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
    }

    protected User(Parcel in) {
        this._username = in.readString();
        this._pWord = in.readString();
        this._loggedIn = in.readByte() != 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
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
