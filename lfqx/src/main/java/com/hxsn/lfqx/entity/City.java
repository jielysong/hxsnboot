package com.hxsn.lfqx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * Created by Administrator on 2017/3/4.
 */
@Entity
@Table(name="sn_city_code")
public class City implements Serializable{

    @Column(name = "citycode")
    @Id
    private String cityCody;
    private String city;
    private String county;
    private String province;
    private String pcode;
    private Integer clevel;

    public Integer getClevel() {
        return clevel;
    }

    public void setClevel(Integer clevel) {
        this.clevel = clevel;
    }

    public String getCityCody() {
        return cityCody;
    }

    public void setCityCody(String cityCody) {
        this.cityCody = cityCody;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
}
