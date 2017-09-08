/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author JoseManuel
 */
public class Tablespace {
    String name;
    int free_space;
    int total_space;
    int used_space;
    float hwm;

    public Tablespace(String name, int free_space, int total_space, int used_space, float hwm) {
        this.name = name;
        this.free_space = free_space;
        this.total_space = total_space;
        this.used_space = used_space;
        this.hwm = hwm;
    }

    public Tablespace() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFree_space() {
        return free_space;
    }

    public void setFree_space(int free_space) {
        this.free_space = free_space;
    }

    public int getTotal_space() {
        return total_space;
    }

    public void setTotal_space(int total_space) {
        this.total_space = total_space;
    }

    public int getUsed_space() {
        return used_space;
    }

    public void setUsed_space(int used_space) {
        this.used_space = used_space;
    }

    public float getHwm() {
        return hwm;
    }

    public void setHwm(float hwm) {
        this.hwm = hwm;
    }
    
}
