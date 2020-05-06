package cn.ve.design_pattern.structural_patterns.facade;

/**
 * @author ve
 * @date 2020/5/6
 */
public class Facade {
    private Door door;
    private Light light;
    private Heater heater;

    public Facade() {
        door = new Door();
        light = new Light();
        heater = new Heater();
    }

    public void open() {
        door.open();
        light.open();
        heater.open();
    }
}
