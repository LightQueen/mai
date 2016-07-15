package org.sshTest.entity;

import javax.persistence.*;

/**
 * Created by liupengfei on 2016/7/7.
 */

@Entity
@Table(name="easybuy_product_category")
public class EbProCategory {
    private String epc_name;
    private Integer epc_id;
    private Integer epc_parent_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEpc_parent_id() {
        return epc_parent_id;
    }

    public void setEpc_parent_id(Integer epc_parent_id) {
        this.epc_parent_id = epc_parent_id;
    }

    public String getEpc_name() {
        return epc_name;
    }

    public void setEpc_name(String epc_name) {
        this.epc_name = epc_name;
    }

    public Integer getEpc_id() {
        return epc_id;
    }

    public void setEpc_id(Integer epc_id) {
        this.epc_id = epc_id;
    }

    @Override
    public String toString() {
        return "EbProCategory{" +
                "epc_name='" + epc_name + '\'' +
                ", epc_id=" + epc_id +
                ", epc_parent_id=" + epc_parent_id +
                '}';
    }
}
