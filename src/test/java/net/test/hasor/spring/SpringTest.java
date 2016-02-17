/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.test.hasor.spring;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.hasor.core.AppContext;
import net.test.hasor.spring.event.tohasor.SpringEventPublisher;
import net.test.hasor.spring.event.tospring.HasorEventPublisher;
/**
 * 
 * @version : 2016年2月15日
 * @author 赵永春(zyc@hasor.net)
 */
public class SpringTest {
    private ApplicationContext applicationContext;
    @Before
    public void initSpring() {
        this.applicationContext = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
    }
    //
    //
    @Test
    public void springPublisherEvent() {
        SpringEventPublisher springPublisher = (SpringEventPublisher) applicationContext.getBean("springEventPublisher");
        //
        springPublisher.publishSyncEvent();//通过Spring发送事件给Hasor
    }
    @Test
    public void hasorPublisherEvent() {
        AppContext appContext = (AppContext) applicationContext.getBean("hasor");
        //
        HasorEventPublisher hasorPublisher = appContext.getInstance(HasorEventPublisher.class);
        hasorPublisher.publishEvent();//通过Hasor发送事件给Spring
    }
    @Test
    public void spring() {
        Object obj1 = this.applicationContext.getBean("test");
        System.out.println("@@@@@@@@@@@@@@" + obj1);
        //
        Object obj2 = this.applicationContext.getBean("hello");
        System.out.println("@@@@@@@@@@@@@@" + obj2);
    }
}