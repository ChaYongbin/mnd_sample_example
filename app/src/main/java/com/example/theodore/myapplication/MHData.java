package com.example.theodore.myapplication;

/**
 * Created by theodore on 2016. 10. 12..
 */

public class MHData {
    private String hsptnm;
    private String zipcd;
    private String hspt_addr;
    private String hspt_cntadr;
    private String ltd;
    private String lngt;

    public MHData(String hsptnm, String zipcd, String hspt_addr, String hspt_cntadr, String ltd, String lngt) {
        this.hsptnm = hsptnm;
        this.zipcd = zipcd;
        this.hspt_addr = hspt_addr;
        this.hspt_cntadr = hspt_cntadr;
        this.ltd = ltd;
        this.lngt = lngt;
    }

    public String getHsptnm() {
        return hsptnm;
    }

    public String getZipcd() {
        return zipcd;
    }

    public String getHspt_addr() {
        return hspt_addr;
    }

    public String getHspt_cntadr() {
        return hspt_cntadr;
    }

    public String getLtd() {
        return ltd;
    }

    public String getLngt() {
        return lngt;
    }
}
