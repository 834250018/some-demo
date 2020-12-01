package com.ywy.demo.akka;

import akka.actor.UntypedActor;

/**
 * @author 83425
 * @date 2020/11/15 17:47
 */
public class TargetActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("targetActor receive: " + message + ", sender= " + getSender());
    }
}
