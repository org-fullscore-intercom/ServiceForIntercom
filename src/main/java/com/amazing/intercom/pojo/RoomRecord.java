package com.amazing.intercom.pojo;

public class RoomRecord {
    private int id;
    private int u_id;
    private int r_id;
    private int state;//0表示离线，1标志在线

    public RoomRecord(int id, int u_id, int r_id, int state) {
        this.id = id;
        this.u_id = u_id;
        this.r_id = r_id;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RoomRecord{" +
                "id=" + id +
                ", u_id='" + u_id + '\'' +
                ", r_id='" + r_id + '\'' +
                ", state=" + state +
                '}';
    }
}
