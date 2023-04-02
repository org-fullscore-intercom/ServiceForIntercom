package com.amazing.intercom.pojo;

public class Room {
    private int id;
    private String name;
    private String introduction;
    private String type;
    private int owner;

    public Room(int id, String name, String introduction, String type, int owner) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.type = type;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                ", owner=" + owner +
                '}';
    }
}
