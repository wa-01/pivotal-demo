package com.jalasoft.pivotal;

import com.jalasoft.pivotal.core.Environment;

public class Main {

    public static void main(String[] args) {
        System.out.println(Environment.getInstance().getValue("$['credentials']['owner']['username']"));
        System.out.println(Environment.getInstance().getValue("$['credentials']['owner']['password']"));
        System.out.println(Environment.getInstance().getValue("$['browser']"));
    }
}
