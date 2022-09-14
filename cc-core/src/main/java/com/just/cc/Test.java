package com.just.cc;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author: Cc
 * @Date: 2022/9/14 16:59
 */
@Slf4j
public class Test {

    private static int redCount = 0;
    private static int blueCount = 0;
    private static ArrayList<String> red = new ArrayList<>();
    private static ArrayList<String> blue = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> teamMembers = new ArrayList<>();
        teamMembers.add("Cc");
        teamMembers.add("弔！宝山小肥棍");
        teamMembers.add("山海");
        teamMembers.add("混圈摩媛：今晚怎么说");
        teamMembers.add("小甲鱼");
        teamMembers.add("宝山马尔扎哈");
        teamMembers.add("本群男德领袖");
        teamMembers.add("格雷福斯");
        teamMembers.add("香波波の臭立立");
        teamMembers.add("吴涛");
        //teamMembers.add("zt");
        //teamMembers.add("秋田阿超");
        randomTeam(teamMembers);
        log.info("red: {}",red);
        log.info("blue: {}",blue);
    }



    public static void randomTeam(ArrayList<String> teamMembers){
        for (String member : teamMembers) {
            int random = new Random().nextInt(100);
            if((random % 2) == 0){
                if(5!=redCount){
                    red.add(member);
                    redCount++;
                }else {
                    blue.add(member);
                    blueCount++;
                }
            }else {
                if(5!=blueCount){
                    blue.add(member);
                    blueCount++;
                }else {
                    red.add(member);
                    redCount++;
                }
            }
        }
    }

}
