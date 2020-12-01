package com.ywy.demo.akka;

import akka.actor.UntypedActor;

/**
 * @author 83425
 * @date 2020/11/15 17:36
 */
public class AskActorDemo extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("发送者是:" + getSender());
        getSender().tell("hhhhh", self());
    }
}
