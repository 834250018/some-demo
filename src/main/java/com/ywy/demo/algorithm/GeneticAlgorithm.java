package com.ywy.demo.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * 简单遗传算法实现(通过选择交叉变异不断进化,得到最优解)
 * 这里的例子是求f(x,y)=x²+y²的最大值
 * x∈{0,1,2,3,4,5,6,7} 二进制表示法为{000 001 010 011 100 101 110 111}
 * y∈{0,1,2,3,4,5,6,7} 二进制表示法为{000 001 010 011 100 101 110 111}
 * 最优解为max = f(7,7)=7²+7² = 98 = 111111
 * 下面用遗传算法得到最优解
 *
 * @author ve
 * @date 2020/5/15
 */
public class GeneticAlgorithm {

    // 基因长度
    public static final int GENE_LENGTH = 6;
    // 基因种类总数,其中Xx这类一大一小的占2个量
    public static final int NUM = 1 << GENE_LENGTH;
    // 初始个体数量
    public static final int INIT_CHROMOSOME_SIZE = 4;
    // 进化次数
    public static final int ITERATION_NUM = 30;
    public static List<Chromosome> chromosomes;
    public static Map<String, Double> scaleMap = new HashMap<>(); // 基因型对应的概率
    public static Map<String, Double> scoreMap = new HashMap<>(); // 基因型对应的分数
    public static Map<String, Integer> countMap = new HashMap<>(); // 基因型对应的个数

    /**
     * 初始化种群
     */
    private static void init() {
        List<Chromosome> chromosomes = new ArrayList<>();
        for (int i = 0; i < INIT_CHROMOSOME_SIZE; i++) {
            chromosomes.add(Chromosome.newInstance(GENE_LENGTH));
        }
        System.out.println();
        GeneticAlgorithm.chromosomes = chromosomes;

        double max = 0d;
        for (int i = 0; i < NUM; i++) {
            String s = Integer.toBinaryString(i);
            String str = String.format("%" + GENE_LENGTH + "s", s);
            str = str.replaceAll(" ", "0");
            double x = Integer.parseUnsignedInt(str.substring(0, 3), 2);
            double y = Integer.parseUnsignedInt(str.substring(3, 5), 2);

            scoreMap.put(str, Math.pow(x, 2) + Math.pow(y, 2)); // 存入当前得分
            if (max < scoreMap.get(str)) {
                max = scoreMap.get(str);
            }
        }
        for (Map.Entry<String, Double> stringDoubleEntry : scoreMap.entrySet()) {
            scaleMap.put(stringDoubleEntry.getKey(), stringDoubleEntry.getValue() / max);
        }
        System.out.println();
    }

    /**
     * 计算种群适应度
     * 与基因型的整体数量无关
     */
    private static void compute() {
        Map<String, List<Chromosome>> collect =
            GeneticAlgorithm.chromosomes.stream().collect(Collectors.groupingBy(Chromosome::getGene_bi));
        collect.forEach((s, chromosomes1) -> {
            countMap.put(s, chromosomes1.size());
        });
        // 计算每个个体的当代得分
        for (Chromosome chromosome : GeneticAlgorithm.chromosomes) {
            // 向上取两位小数
            chromosome
                .setScore_scale(new BigDecimal(chromosome.getScore_scale()).setScale(2, RoundingMode.UP).doubleValue());
        }
    }

    /**
     * 选择操作
     * 为保证程序的正常进行,在个体数量较小的时候提高存活率,个体数量较大的时候降低存活率
     */
    private static void select() {
        List<Chromosome> chromosomes = new ArrayList<>();
        for (Chromosome chromosome : GeneticAlgorithm.chromosomes) {
            boolean b = ThreadLocalRandom.current().nextDouble() < scaleMap.get(chromosome.getGene_bi()) + Math
                .pow(0.3, countMap.get(chromosome.getGene_bi()));
            if (b) {
                chromosomes.add(chromosome);
            }

        }
        GeneticAlgorithm.chromosomes = chromosomes;
    }

    /**
     * 交叉操作
     */
    private static void overlapping() {
        int count = GeneticAlgorithm.chromosomes.size();
        if ((count & 1) != 0) {
            count--;
        }
        ArrayList<Chromosome> chromosomes = new ArrayList<>(GeneticAlgorithm.chromosomes);
        for (int i = 0; i < count; i += 2) {
            int randomInt = ThreadLocalRandom.current().nextInt(chromosomes.size()); // 任选两个交叉
            Chromosome remove = chromosomes.remove(randomInt);
            int randomInt1 = ThreadLocalRandom.current().nextInt(chromosomes.size()); // 任选两个交叉
            Chromosome remove1 = chromosomes.remove(randomInt1);
            GeneticAlgorithm.chromosomes.add(Chromosome.newInstance(remove, remove1));
        }
    }

    /**
     * 变异操作
     */
    private static void variation() {
        List<Chromosome> chromosomes = new ArrayList<>();
        for (Chromosome chromosome : GeneticAlgorithm.chromosomes) {
            if (ThreadLocalRandom.current().nextDouble() >= 0.002d) {
                chromosomes.add(chromosome);
            } else {
                chromosomes.add(Chromosome.newInstance(chromosome));
            }
        }
        GeneticAlgorithm.chromosomes = chromosomes;
    }

    /**
     * 打印种群构成
     */
    private static void print() {
        System.out.println("种群数量: " + GeneticAlgorithm.chromosomes.size());
        Map<String, List<Chromosome>> collect =
            GeneticAlgorithm.chromosomes.stream().collect(Collectors.groupingBy(Chromosome::getGene_bi));
        for (Map.Entry<String, List<Chromosome>> stringListEntry : collect.entrySet()) {
            System.out.println(stringListEntry.getKey() + ": " + stringListEntry.getValue().size());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 初始化种群,4个个体
        init();

        // 迭代演变
        for (int i = 0; i < ITERATION_NUM; i++) {
            compute();
            select();
            overlapping();
            variation();
            System.out.println("第${}代: " + i);
            print();
        }
    }

}

class Chromosome {

    // 每个个体都有自己的基因
    private final boolean[] gene;
    // 基因二进制
    private final String gene_bi;

    // 对应x值
    private final int x;
    // 对应y值
    private final int y;
    // 对应f(x,y)值
    private final double score;
    // 当代的适应性得分(0~1之间)
    private double score_scale;

    private Chromosome(boolean[] gene) {
        this.gene = gene;
        StringBuilder sb = new StringBuilder();
        for (boolean b : gene) {
            sb.append(b ? 1 : 0);
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < gene.length; i++) { // 101011拆成x跟y就是5,3
            if (i < 3) {
                if (gene[i]) {
                    x++;
                }
                if (i < 2) {
                    x = x << 1;
                }
            } else {
                if (gene[i]) {
                    y++;
                }
                if (i < gene.length - 1) {
                    y = y << 1;
                }
            }
        }
        this.x = x;
        this.y = y;
        this.score = Math.pow(x, 2) + Math.pow(y, 2);
        this.gene_bi = sb.toString();
    }

    // 随机基因工厂方法
    public static Chromosome newInstance(int size) {
        boolean[] gene = new boolean[size];
        for (int i = 0; i < size; i++) {
            gene[i] = ThreadLocalRandom.current().nextDouble() >= 0.5;
        }
        return new Chromosome(gene);
    }

    /**
     * 变异
     *
     * @param chromosome
     * @return
     */
    public static Chromosome newInstance(Chromosome chromosome) {
        boolean[] gene = chromosome.getGene();
        int i = ThreadLocalRandom.current().nextInt(GeneticAlgorithm.GENE_LENGTH);
        gene[i] = !gene[i];
        return new Chromosome(gene);
    }

    /**
     * 交叉
     *
     * @param chromosome
     * @param chromosome2
     * @return
     */
    public static Chromosome newInstance(Chromosome chromosome, Chromosome chromosome2) {
        boolean[] booleans = new boolean[chromosome.getGene().length];
        for (int i = 0; i < chromosome.getGene().length; i++) {
            if (ThreadLocalRandom.current().nextDouble() >= 0.5) {
                booleans[i] = chromosome.getGene()[i];
            } else {
                booleans[i] = chromosome2.getGene()[i];
            }
        }
        return new Chromosome(booleans);
    }

    @Override public String toString() {
        return super.toString();
    }

    public boolean[] getGene() {
        return gene;
    }

    public String getGene_bi() {
        return gene_bi;
    }

    public double getScore() {
        return score;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getScore_scale() {
        return score_scale;
    }

    public void setScore_scale(double score_scale) {
        this.score_scale = score_scale;
    }

}