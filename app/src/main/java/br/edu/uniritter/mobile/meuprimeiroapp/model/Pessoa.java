package br.edu.uniritter.mobile.meuprimeiroapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pessoa implements Parcelable {
    public String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }
    private Pessoa(Parcel parcel) {
        this.nome = parcel.readString();
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nome);
    }
}
