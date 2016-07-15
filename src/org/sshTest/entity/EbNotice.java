package sdkd.com.ec.model;

import javax.persistence.*;

/**
 * Created by sdust on 2016/7/13.
 */

@Entity
@Table(name="easybuy_notice")
public class EbNotice {
    private Integer ec_id;
    private String ec_entitle;
    private String ec_content;
    private String ec_creat_time;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEc_id() {
        return ec_id;
    }

    public void setEc_id(Integer ec_id) {
        this.ec_id = ec_id;
    }

    public String getEc_entitle() {
        return ec_entitle;
    }

    public void setEc_entitle(String ec_entitle) {
        this.ec_entitle = ec_entitle;
    }

    public String getEc_content() {
        return ec_content;
    }

    public void setEc_content(String ec_content) {
        this.ec_content = ec_content;
    }

    public String getEc_creat_time() {
        return ec_creat_time;
    }

    public void setEc_creat_time(String ec_creat_time) {
        this.ec_creat_time = ec_creat_time;
    }
}
