package com.amazing.intercom.pojo;

public class Follow {
    private int id;
    private int u_id;
    private int f_u_id;//被关注用户id

    public Follow(int id, int u_id, int f_u_id) {
        this.id = id;
        this.u_id = u_id;
        this.f_u_id = f_u_id;
    }

    public Follow(int u_id, int f_u_id) {
        this.u_id=u_id;
        this.f_u_id=f_u_id;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", u_id=" + u_id +
                ", f_u_id=" + f_u_id +
                '}';
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

    public int getF_u_id() {
        return f_u_id;
    }

    public void setF_u_id(int f_u_id) {
        this.f_u_id = f_u_id;
    }
}
