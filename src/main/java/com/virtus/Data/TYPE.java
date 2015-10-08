/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.Data;

/**
 *
 * @author jared
 */
public enum TYPE {
    Numeric ("Numeric" ),
    Discrete("Discrete"),
    Binary  ("Binary"  );

    private final String name;

    TYPE(String s) {
        name = s;
    }

    public boolean equals(TYPE pType) {
        return (pType == null) ? false : name.equals(pType.toString());
    }

    public String toString() {
        return this.name;
    }
};
