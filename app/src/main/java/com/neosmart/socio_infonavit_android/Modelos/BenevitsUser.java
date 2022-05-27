package com.neosmart.socio_infonavit_android.Modelos;

import java.util.ArrayList;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * Brentec
 */
public class BenevitsUser {
   public ArrayList<Benevits> locked;
   public ArrayList<Benevits> unlocked;

    public BenevitsUser(ArrayList<Benevits> locked, ArrayList<Benevits> unlocked) {
        this.locked = locked;
        this.unlocked = unlocked;
    }

    public BenevitsUser() {
    }

    public ArrayList<Benevits> getLocked() {
        return locked;
    }

    public void setLocked(ArrayList<Benevits> locked) {
        this.locked = locked;
    }

    public ArrayList<Benevits> getUnlocked() {
        return unlocked;
    }

    public void setUnlocked(ArrayList<Benevits> unlocked) {
        this.unlocked = unlocked;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BenevitsUser{");
        sb.append("locked=").append(locked);
        sb.append(", unlocked=").append(unlocked);
        sb.append('}');
        return sb.toString();
    }
}
