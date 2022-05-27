package com.neosmart.socio_infonavit_android.Modelos;

import java.util.Date;

public class Wallet{
    public int id;
    public String name;
    public String description;
    public String display_text;
    public String icon;
    public String path;
    public String primary_color;
    public String secondary_color;
    public Date created_at;
    public Date updated_at;
    public int display_index;
    public String avatar;
    public Object mobile_cover_url;
    public Object desktop_cover_url;
    public int max_level;
    public int max_level_phase_2;
    public int max_level_phase_3;
    public int max_level_phase_4;
    public int max_level_phase_5;

    public Wallet(int id, String name, String description, String display_text, String icon, String path, String primary_color, String secondary_color, Date created_at, Date updated_at, int display_index, String avatar, Object mobile_cover_url, Object desktop_cover_url, int max_level, int max_level_phase_2, int max_level_phase_3, int max_level_phase_4, int max_level_phase_5) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.display_text = display_text;
        this.icon = icon;
        this.path = path;
        this.primary_color = primary_color;
        this.secondary_color = secondary_color;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.display_index = display_index;
        this.avatar = avatar;
        this.mobile_cover_url = mobile_cover_url;
        this.desktop_cover_url = desktop_cover_url;
        this.max_level = max_level;
        this.max_level_phase_2 = max_level_phase_2;
        this.max_level_phase_3 = max_level_phase_3;
        this.max_level_phase_4 = max_level_phase_4;
        this.max_level_phase_5 = max_level_phase_5;
    }

    public Wallet() {
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

    public String getDisplay_text() {
        return display_text;
    }

    public void setDisplay_text(String display_text) {
        this.display_text = display_text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPrimary_color() {
        return primary_color;
    }

    public void setPrimary_color(String primary_color) {
        this.primary_color = primary_color;
    }

    public String getSecondary_color() {
        return secondary_color;
    }

    public void setSecondary_color(String secondary_color) {
        this.secondary_color = secondary_color;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getDisplay_index() {
        return display_index;
    }

    public void setDisplay_index(int display_index) {
        this.display_index = display_index;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getMobile_cover_url() {
        return mobile_cover_url;
    }

    public void setMobile_cover_url(Object mobile_cover_url) {
        this.mobile_cover_url = mobile_cover_url;
    }

    public Object getDesktop_cover_url() {
        return desktop_cover_url;
    }

    public void setDesktop_cover_url(Object desktop_cover_url) {
        this.desktop_cover_url = desktop_cover_url;
    }

    public int getMax_level() {
        return max_level;
    }

    public void setMax_level(int max_level) {
        this.max_level = max_level;
    }

    public int getMax_level_phase_2() {
        return max_level_phase_2;
    }

    public void setMax_level_phase_2(int max_level_phase_2) {
        this.max_level_phase_2 = max_level_phase_2;
    }

    public int getMax_level_phase_3() {
        return max_level_phase_3;
    }

    public void setMax_level_phase_3(int max_level_phase_3) {
        this.max_level_phase_3 = max_level_phase_3;
    }

    public int getMax_level_phase_4() {
        return max_level_phase_4;
    }

    public void setMax_level_phase_4(int max_level_phase_4) {
        this.max_level_phase_4 = max_level_phase_4;
    }

    public int getMax_level_phase_5() {
        return max_level_phase_5;
    }

    public void setMax_level_phase_5(int max_level_phase_5) {
        this.max_level_phase_5 = max_level_phase_5;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wallet{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", display_text='").append(display_text).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append(", primary_color='").append(primary_color).append('\'');
        sb.append(", secondary_color='").append(secondary_color).append('\'');
        sb.append(", created_at=").append(created_at);
        sb.append(", updated_at=").append(updated_at);
        sb.append(", display_index=").append(display_index);
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", mobile_cover_url=").append(mobile_cover_url);
        sb.append(", desktop_cover_url=").append(desktop_cover_url);
        sb.append(", max_level=").append(max_level);
        sb.append(", max_level_phase_2=").append(max_level_phase_2);
        sb.append(", max_level_phase_3=").append(max_level_phase_3);
        sb.append(", max_level_phase_4=").append(max_level_phase_4);
        sb.append(", max_level_phase_5=").append(max_level_phase_5);
        sb.append('}');
        return sb.toString();
    }
}
