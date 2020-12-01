package com.ywy.demo.akka;

import akka.actor.*;
import akka.japi.Creator;

/**
 * @author 83425
 * @date 2020/11/15 17:17
 */
public class PropsDemoActor extends UntypedActor {
    public static Props createProps() {
        return Props.create((Creator<Actor>) PropsDemoActor::new);
    }

    public static void main(String[] args) {
        ActorRef actorRef = ActorSystem.create().actorOf(PropsDemoActor.createProps());
    }

    @Override
    public void onReceive(Object message) throws Exception {

    }
}
