package com.hxsn.lfqx.entity;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 *
 * Created by jiely on 2017/3/6.
 */
@Entity
@Table(name="sn_zsk_crop")
public class Crop implements java.io.Serializable{
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "cropid", unique = true, nullable = false, length = 36)
    private String cropId;

    @Column(name = "cropname")
    private String cropName;
    @Column(name = "cropalias")
    private String cropAlias;
    @Column(name = "crtime")
    private Date ceateTime;
    @Column(name = "remark", length = 2000)
    private String remark;
    @Column(name = "cruser", length = 50)
    private String cruser;

    public String getCropId() {
        return cropId;
    }

    public void setCropId(String cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropAlias() {
        return cropAlias;
    }

    public void setCropAlias(String cropAlias) {
        this.cropAlias = cropAlias;
    }

    public Date getCeateTime() {
        return ceateTime;
    }

    public void setCeateTime(Date ceateTime) {
        this.ceateTime = ceateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }
}
