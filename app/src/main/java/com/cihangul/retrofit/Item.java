package com.cihangul.retrofit;

/**
 * Created by Cihan on 15.11.2016.
 */

public class Item {
    private String itemIsim;
    private String itemResim;
    private String itemAciklama;

    public Item(String itemIsim, String itemResim, String itemAciklama) {
        this.itemIsim = itemIsim;
        this.itemResim = itemResim;
        this.itemAciklama = itemAciklama;
    }

    public Item() {
    }

    public String getItemIsim() {
        return itemIsim;
    }

    public void setItemIsim(String itemIsim) {
        this.itemIsim = itemIsim;
    }

    public String getItemResim() {
        return itemResim;
    }

    public void setItemResim(String itemResim) {
        this.itemResim = itemResim;
    }

    public String getItemAciklama() {
        return itemAciklama;
    }

    public void setItemAciklama(String itemAciklama) {
        this.itemAciklama = itemAciklama;
    }
}
