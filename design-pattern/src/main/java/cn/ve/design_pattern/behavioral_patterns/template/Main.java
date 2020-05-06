package cn.ve.design_pattern.behavioral_patterns.template;

/**
 * @author ve
 * @date 2019/9/19 11:02
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("---------穷养------------");
        new AbstractKeepPetCheaply().keepPet();
        System.out.println("");
        System.out.println("---------富养------------");
        new AbstractKeepPetEutrophication().keepPet();

    }
}
