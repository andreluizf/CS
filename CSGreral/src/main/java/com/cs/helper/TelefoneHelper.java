package com.cs.helper;

import java.io.Serializable;

public class TelefoneHelper implements Serializable {

    private String mask = "(99)9999-9999?9";

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = (mask.length() == 14) ? "(99)99999-999?9" : "(99)9999-9999?9";
    }
}