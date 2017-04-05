package com.hxsn.lfqx.entity;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 *
 * Created by jiely on 2017/3/6.
 */
@Entity
@Table(name = "sn_zsk_pests")
public class Pest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    // Property accessors
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "pestsid", unique = true, nullable = false, length = 36)
    private String pestsid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cropid")
    private Crop snZskCrop;
    @Column(name = "stagesid", length = 36)
    private String stagesid;
    private String pestsname;
    private String scientific;
    private String alias;
    private String pestsimg;
    private String remark;
    private String cruser;
    private Date crtime;
    private String lmuser;
    private Date lmtime;
}
