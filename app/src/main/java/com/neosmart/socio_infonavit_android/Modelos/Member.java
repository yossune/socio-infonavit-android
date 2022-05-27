package com.neosmart.socio_infonavit_android.Modelos;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * Brentec
 */
public class Member {
    public int id;
    public int user_id;
    public String id_socio_infonavit;
    public String name;
    public String lastname;
    public String lastname_mother;
    public Object mobile;
    public Object zipcode;
    public String avatar;
    public boolean subscribed_to_newsletter;
    public String only_name;

    public Member(int id, int user_id, String id_socio_infonavit, String name, String lastname,
                  String lastname_mother, Object mobile, Object zipcode, String avatar, boolean subscribed_to_newsletter,
                  String only_name) {
        this.id = id;
        this.user_id = user_id;
        this.id_socio_infonavit = id_socio_infonavit;
        this.name = name;
        this.lastname = lastname;
        this.lastname_mother = lastname_mother;
        this.mobile = mobile;
        this.zipcode = zipcode;
        this.avatar = avatar;
        this.subscribed_to_newsletter = subscribed_to_newsletter;
        this.only_name = only_name;
    }
    public Member() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getId_socio_infonavit() {
        return id_socio_infonavit;
    }
    public void setId_socio_infonavit(String id_socio_infonavit) {
        this.id_socio_infonavit = id_socio_infonavit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname_mother() {
        return lastname_mother;
    }
    public void setLastname_mother(String lastname_mother) {
        this.lastname_mother = lastname_mother;
    }
    public Object getMobile() {
        return mobile;
    }
    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }
    public Object getZipcode() {
        return zipcode;
    }
    public void setZipcode(Object zipcode) {
        this.zipcode = zipcode;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public boolean isSubscribed_to_newsletter() {
        return subscribed_to_newsletter;
    }
    public void setSubscribed_to_newsletter(boolean subscribed_to_newsletter) {
        this.subscribed_to_newsletter = subscribed_to_newsletter;
    }
    public String getOnly_name() {
        return only_name;
    }
    public void setOnly_name(String only_name) {
        this.only_name = only_name;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Member [id=");
        builder.append(id);
        builder.append(", user_id=");
        builder.append(user_id);
        builder.append(", id_socio_infonavit=");
        builder.append(id_socio_infonavit);
        builder.append(", name=");
        builder.append(name);
        builder.append(", lastname=");
        builder.append(lastname);
        builder.append(", lastname_mother=");
        builder.append(lastname_mother);
        builder.append(", mobile=");
        builder.append(mobile);
        builder.append(", zipcode=");
        builder.append(zipcode);
        builder.append(", avatar=");
        builder.append(avatar);
        builder.append(", subscribed_to_newsletter=");
        builder.append(subscribed_to_newsletter);
        builder.append(", only_name=");
        builder.append(only_name);
        builder.append("]");
        return builder.toString();
    }


}
