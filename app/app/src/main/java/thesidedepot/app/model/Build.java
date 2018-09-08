package thesidedepot.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Objects;

public class Build implements Parcelable {
    private String _name;
    private String _desc;
    private int hours;
    private ArrayList<String> steps;
    private boolean _done;

    public Build(String _name, String _desc, int hours, ArrayList<String> steps, boolean _done) {
        this._name = _name;
        this._desc = _desc;
        this.hours = hours;
        this.steps = steps;
        this._done = _done;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public boolean is_done() {
        return _done;
    }

    public void set_done(boolean _done) {
        this._done = _done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Build build = (Build) o;
        return ((Build) o).get_name().equals(this._name);
    }

    @Override
    public String toString() {
        return "Build{" +
                "_name='" + _name + '\'' +
                ", _desc='" + _desc + '\'' +
                ", hours=" + hours +
                ", steps=" + steps +
                ", _done=" + _done +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._name);
        dest.writeString(this._desc);
        dest.writeInt(this.hours);
        dest.writeStringList(this.steps);
        dest.writeByte(this._done ? (byte) 1 : (byte) 0);
    }

    protected Build(Parcel in) {
        this._name = in.readString();
        this._desc = in.readString();
        this.hours = in.readInt();
        this.steps = in.createStringArrayList();
        this._done = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Build> CREATOR = new Parcelable.Creator<Build>() {
        @Override
        public Build createFromParcel(Parcel source) {
            return new Build(source);
        }

        @Override
        public Build[] newArray(int size) {
            return new Build[size];
        }
    };
}
