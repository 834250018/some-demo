package com.ywy.demo.design_pattern.template_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2019/9/19 11:02
 */
@Slf4j
public class TemplatePatternDemo {
    public static void main(String[] args) {

        log.info("---------穷养------------");
        new AbstractKeepPetCheaply().keepPet();
        log.info("");
        log.info("---------富养------------");
        new AbstractKeepPetEutrophication().keepPet();

    }
}
