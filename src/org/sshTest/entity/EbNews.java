package org.sshTest.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SDUST-132 on 2016/7/6.
 */

@Entity
@Table(name="easybuy_news")
public class EbNews {
    private Integer en_id;
    private String en_title;
    private String en_content;
    private Date en_create_time;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEn_id() {
        return en_id;
    }

    public void setEn_id(Integer en_id) {
        this.en_id = en_id;
    }

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    public String getEn_content() {
        return en_content;
    }

    public void setEn_content(String en_content) {
        this.en_content = en_content;
    }

    public Date getEn_create_time() {
        return en_create_time;
    }

    public void setEn_create_time(Date en_create_time) {
        this.en_create_time = en_create_time;
    }

    @Override
    public String toString() {
        return "EbNews{" +
                "en_id=" + en_id +
                ", en_title='" + en_title + '\'' +
                ", en_content='" + en_content + '\'' +
                ", en_create_time=" + en_create_time +
                '}';
    }
}
