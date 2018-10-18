package com.session.sessiontest1.classload;

public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            System.out.println(System.getProperty("java.class.path"));
            Class typeLoaded = Class.forName("com.session.sessiontest1.classload.TestBean");
            System.out.println(typeLoaded.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
