package com.neosmart.socio_infonavit_android.Modelos;

import java.util.ArrayList;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * DevArpez
 */
public class Benevits {
    public int id;
    public String name;
    public String description;
    public String title;
    public String instructions;
    public String expiration_date;
    public boolean active;
    public String primary_color;
    public boolean has_coupons;
    public String vector_file_name;
    public String vector_full_path;
    public String slug;
    public Wallet wallet;
    public ArrayList<Object> territories;
    public Ally ally;
    public boolean is_available_in_all_territories;
    public boolean is_available_in_ecommerce;
    public boolean is_available_in_physical_store;


    public boolean bloqueado =false;

    public Benevits(int id, String name, String description, String title, String instructions, String expiration_date, boolean active, String primary_color, boolean has_coupons, String vector_file_name, String vector_full_path, String slug, Wallet wallet, ArrayList<Object> territories, Ally ally, boolean is_available_in_all_territories, boolean is_available_in_ecommerce, boolean is_available_in_physical_store) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.title = title;
        this.instructions = instructions;
        this.expiration_date = expiration_date;
        this.active = active;
        this.primary_color = primary_color;
        this.has_coupons = has_coupons;
        this.vector_file_name = vector_file_name;
        this.vector_full_path = vector_full_path;
        this.slug = slug;
        this.wallet = wallet;
        this.territories = territories;
        this.ally = ally;
        this.is_available_in_all_territories = is_available_in_all_territories;
        this.is_available_in_ecommerce = is_available_in_ecommerce;
        this.is_available_in_physical_store = is_available_in_physical_store;
    }

    public Benevits() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPrimary_color() {
        return primary_color;
    }

    public void setPrimary_color(String primary_color) {
        this.primary_color = primary_color;
    }

    public boolean isHas_coupons() {
        return has_coupons;
    }

    public void setHas_coupons(boolean has_coupons) {
        this.has_coupons = has_coupons;
    }

    public String getVector_file_name() {
        return vector_file_name;
    }

    public void setVector_file_name(String vector_file_name) {
        this.vector_file_name = vector_file_name;
    }

    public String getVector_full_path() {
        return vector_full_path;
    }

    public void setVector_full_path(String vector_full_path) {
        this.vector_full_path = vector_full_path;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Object> getTerritories() {
        return territories;
    }

    public void setTerritories(ArrayList<Object> territories) {
        this.territories = territories;
    }

    public Ally getAlly() {
        return ally;
    }

    public void setAlly(Ally ally) {
        this.ally = ally;
    }

    public boolean isIs_available_in_all_territories() {
        return is_available_in_all_territories;
    }

    public void setIs_available_in_all_territories(boolean is_available_in_all_territories) {
        this.is_available_in_all_territories = is_available_in_all_territories;
    }

    public boolean isIs_available_in_ecommerce() {
        return is_available_in_ecommerce;
    }

    public void setIs_available_in_ecommerce(boolean is_available_in_ecommerce) {
        this.is_available_in_ecommerce = is_available_in_ecommerce;
    }

    public boolean isIs_available_in_physical_store() {
        return is_available_in_physical_store;
    }

    public void setIs_available_in_physical_store(boolean is_available_in_physical_store) {
        this.is_available_in_physical_store = is_available_in_physical_store;
    }
    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Benevits{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", instructions='").append(instructions).append('\'');
        sb.append(", expiration_date='").append(expiration_date).append('\'');
        sb.append(", active=").append(active);
        sb.append(", primary_color='").append(primary_color).append('\'');
        sb.append(", has_coupons=").append(has_coupons);
        sb.append(", vector_file_name='").append(vector_file_name).append('\'');
        sb.append(", vector_full_path='").append(vector_full_path).append('\'');
        sb.append(", slug='").append(slug).append('\'');
        sb.append(", wallet=").append(wallet);
        sb.append(", territories=").append(territories);
        sb.append(", ally=").append(ally);
        sb.append(", is_available_in_all_territories=").append(is_available_in_all_territories);
        sb.append(", is_available_in_ecommerce=").append(is_available_in_ecommerce);
        sb.append(", is_available_in_physical_store=").append(is_available_in_physical_store);
        sb.append('}');
        return sb.toString();
    }
}
