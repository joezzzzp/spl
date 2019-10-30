package com.learn.spl.entity;

/**
 * @author created by zzz at 2019/10/29 10:57
 */

public class User {

    private String name;

    private int age;

    private int gender;

    private Desc desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Desc getDesc() {
        return desc;
    }

    public void setDesc(Desc desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", desc=" + desc +
                '}';
    }

    public static class Desc {

        private String note;

        private String fullDesc;

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getFullDesc() {
            return fullDesc;
        }

        public void setFullDesc(String fullDesc) {
            this.fullDesc = fullDesc;
        }

        @Override
        public String toString() {
            return "Desc{" +
                    "note='" + note + '\'' +
                    ", fullDesc='" + fullDesc + '\'' +
                    '}';
        }
    }
}
