package com.springcloud.kafkamodel.PageEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;


@RestController
@RequestMapping(path = "/event")
public class PageEventRestController {
    @Autowired
    private StreamBridge streamBridge;
    @GetMapping(path = "/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String topic, @PathVariable String name){
        PageEvent pageEvent = new PageEvent(name, "ie017", new Date(), new Random().nextInt(99));
        streamBridge.send(topic, pageEvent);
        return pageEvent;
        /*On commencera à faire un test avec le topic mytopic qui était deja créer,
        * On peut spécifier les parameters des kafka dans application.properties
        * sinon spring concéder les parameters par défaut comme le port 9092*/

        /*Le résultat d'exécution de lien http://localhost:8080/event/publish/mytopic/ahmed est par exemple :
        * {
             "name": "ahmed",
             "user": "ie017",
             "date": "2022-09-11T19:41:07.331+00:00",
             "duration": 96
          }
          * est cet objet-là était envoyé vers des consommateurs qui sont abonnées à le topic mytopic
          * , et lorsqu'on affiche ce message-là via la console cmd en trouve le résultat suivant :
          * {"name":"ahmed","user":"ie017","date":"2022-09-11T19:41:07.331+00:00","duration":96} */
    }
}
