package com.ywy.demo.design_pattern.template_pattern;

/**
 * @author ve
 * @date 2019/9/19 11:02
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {

        System.out.println("---------穷养------------");
        new KeepPetCheaply().keepPet();
        System.out.println();
        System.out.println("---------富养------------");
        new KeepPetEutrophication().keepPet();

    }
}
