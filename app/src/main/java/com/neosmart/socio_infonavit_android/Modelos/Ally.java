package com.neosmart.socio_infonavit_android.Modelos;
/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * DevArpez
 */
public class Ally{
    public int id;
    public String name;
    public String slug;
    public String mini_logo_file_name;
    public String mini_logo_full_path;
    public String description;

    public Ally(int id, String name, String slug, String mini_logo_file_name, String mini_logo_full_path, String description) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.mini_logo_file_name = mini_logo_file_name;
        this.mini_logo_full_path = mini_logo_full_path;
        this.description = description;
    }

    public Ally() {
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMini_logo_file_name() {
        return mini_logo_file_name;
    }

    public void setMini_logo_file_name(String mini_logo_file_name) {
        this.mini_logo_file_name = mini_logo_file_name;
    }

    public String getMini_logo_full_path() {
        return mini_logo_full_path;
    }

    public void setMini_logo_full_path(String mini_logo_full_path) {
        this.mini_logo_full_path = mini_logo_full_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ally{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", slug='").append(slug).append('\'');
        sb.append(", mini_logo_file_name='").append(mini_logo_file_name).append('\'');
        sb.append(", mini_logo_full_path='").append(mini_logo_full_path).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
