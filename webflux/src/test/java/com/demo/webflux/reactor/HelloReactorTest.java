package com.demo.webflux.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

/**
 * 初识Reactor
 * 反应式流规范定义了4种类型：Publisher、Subscriber、Subscription和Processor
 * @author hjx
 * @version 1.0
 * @date 2021/7/19 19:40
 */
public class HelloReactorTest
{
    /**
     * 创建Flux，并且添加一个订阅者Consumer
     */
    @Test
    public void Hello(){
        Flux<Integer> numberFlux = Flux.just(1, 2, 3, 4);
        numberFlux.subscribe(f->System.out.println("Here's some number:"+f));
    }

    @Test
    public void from(){
        Integer[] numbers = {1,2,3,4};
        // from 数组 迭代器 stream
        Flux<Integer> numberFlux = Flux.fromArray(numbers);
        numberFlux.subscribe(f->System.out.println("Here's some number:"+f));
    }
}
