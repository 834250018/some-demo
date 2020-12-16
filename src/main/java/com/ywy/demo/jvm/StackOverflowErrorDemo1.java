package com.ywy.demo.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * -Xss128k
 *
 * @author 83425
 * @date 2020/12/17
 */
@Slf4j
public class StackOverflowErrorDemo1 {

    static int deep = 0;// 局部变量越多,越早抛出异常,deep越小

    public static void main(String[] args) {
        long
                l1,l11,l21,l31,l41,l51,l61,l71,l81,l91,l101,l111,l121,l131,
                l2,l12,l22,l32,l42,l52,l62,l72,l82,l92,l102,l112,l122,l132,
                l3,l13,l23,l33,l43,l53,l63,l73,l83,l93,l103,l113,l123,l133,
                l4,l14,l24,l34,l44,l54,l64,l74,l84,l94,l104,l114,l124,l134,
                l5,l15,l25,l35,l45,l55,l65,l75,l85,l95,l105,l115,l125,l135,
                l6,l16,l26,l36,l46,l56,l66,l76,l86,l96,l106,l116,l126,l136,
                l7,l17,l27,l37,l47,l57,l67,l77,l87,l97,l107,l117,l127,l137,
                l8,l18,l28,l38,l48,l58,l68,l78,l88,l98,l108,l118,l128,l138,
                l9,l19,l29,l39,l49,l59,l69,l79,l89,l99,l109,l119,l129,l139,
                l0,l10,l20,l30,l40,l50,l60,l70,l80,l90,l100,l110,l120,l130
                ;
        try {
            justOverflow();
        } catch (Throwable t) {
            System.out.println("stack length:" + deep);
            throw t;
        }
    }

    private static void justOverflow() {
        deep++;
        justOverflow();
    }
}
